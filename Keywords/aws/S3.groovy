package aws

import java.security.MessageDigest
import java.text.SimpleDateFormat

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.classic.methods.HttpPut
import org.apache.hc.client5.http.classic.methods.HttpUriRequest
import org.apache.hc.client5.http.entity.EntityBuilder
import org.apache.hc.client5.http.entity.mime.FileBody
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.HttpEntity
import org.apache.hc.core5.http.io.entity.HttpEntityWrapper
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder
import org.apache.hc.core5.http.message.BasicClassicHttpRequest
import org.apache.http.HttpResponse
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.entity.FileEntity
import org.apache.http.util.EntityUtils

import com.katalon.org.apache.hc.core5.http.ClassicHttpRequest
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class S3 {

	@Keyword
	def putObjectToS3ViaApiGateWay(String apiGateWayEndpoint, String bucket, String filePath, String destinationFileName) {
		if (!apiGateWayEndpoint.endsWith("/")) apiGateWayEndpoint = apiGateWayEndpoint + "/"
		if (bucket.startsWith("/")) bucket = bucket.replace("/", "")

		File file = new File(filePath);

		try {
			CloseableHttpClient httpClient = HttpClients.createDefault()
			BasicClassicHttpRequest request = ClassicRequestBuilder.put(apiGateWayEndpoint+bucket+"/"+destinationFileName).build();
			EntityBuilder entity = EntityBuilder.create();
			entity.setFile(file)
			HttpEntity binFile = entity.build();
			request.setEntity(binFile)
			CloseableHttpResponse response = httpClient.execute(request)
			HttpEntity responseEntity = response.getEntity();
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Uploading file failed..." + e.printStackTrace());
		}


		//		try {
		//			HttpClient httpClient = HttpClients.createDefault()
		//			File file = new File(filePath)
		//			EntityBuilder entity = EntityBuilder.create()
		//			entity.setFile(file)
		//			HttpUriRequest request = RequestBuilder.put()
		//					.setUri(apiGateWayEndpoint+bucket+"/"+destinationFileName)
		//					.setEntity(entity.build()).build();
		//			HttpResponse response = httpClient.execute(request);
		//			int statusCode = response.getStatusLine().getStatusCode();
		//			System.out.println("Status code: " + statusCode);
		//			// Get the response message
		//			String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
		//			System.out.println("Response from server: " + responseBody);
		//		} catch (Exception e) {
		//			System.out.println("Uploading file failed..." + e.printStackTrace());
		//		}


	}


	def putObjectToS3(String bucket, String filePath, String destinationFileName, String accessKey, String secretKey, String region) {

		URL endpointUrl;
		try {
			if (region.equals("us-east-1")) {
				endpointUrl = new URL("https://s3.amazonaws.com/" + bucket + "/" + destinationFileName);
			} else {
				endpointUrl = new URL("https://s3-" + region + ".amazonaws.com/" + bucket + "/" + destinationFileName);
			}
		} catch (MalformedURLException e) {
			KeywordUtil.markWarning("Unable to parse service endpoint: " + e.getMessage());
		}

		HttpPut httpPut = new HttpPut("https://s3.us-east-1.amazonaws.com")
		httpPut.addHeader("Content-Type", "application/x-amz-json-1.1")
		httpPut.addHeader("X-Amz-Target", "S3.PutObject")
		httpPut.addHeader("Authorization", )
	}


	def byte[] fileToByteArray(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] byteArray = new byte[(int)file.length()];
			fis.read(byteArray);
			fis.close();
			return byteArray
		} catch (Exception e) {
			KeywordUtil.markWarning("Some issue with the file path " + file.getAbsolutePath())
		}
	}

	def String computeSignature(URL endPointUrl, String httpMethod, String serviceName, String regionName, Map<String, String> headers,
			Map<String, String> queryParameters,
			String bodyHash,
			String awsAccessKey,
			String awsSecretKey) {

		String ISO8601BasicFormat = "yyyyMMdd'T'HHmmss'Z'";
		String DateStringFormat = "yyyyMMdd";

		String EMPTY_BODY_SHA256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
		String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";

		String SCHEME = "AWS4";
		String ALGORITHM = "HMAC-SHA256";
		String TERMINATOR = "aws4_request";

		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(ISO8601BasicFormat);
		dateTimeFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
		SimpleDateFormat dateStampFormat = new SimpleDateFormat(DateStringFormat);
		dateStampFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));

		Date now = new Date();
		String dateTimeStamp = dateTimeFormat.format(now);

		headers.put("x-amz-date", dateTimeStamp);

		String hostHeader = endPointUrl.getHost();
		int port = endPointUrl.getPort();
		if ( port > -1 ) {
			hostHeader.concat(":" + Integer.toString(port));
		}
		headers.put("Host", hostHeader);

		String canonicalizedHeaderNames = getCanonicalizeHeaderNames(headers);
		String canonicalizedHeaders = getCanonicalizedHeaderString(headers);

		String canonicalizedQueryParameters = getCanonicalizedQueryString(queryParameters);

		String canonicalRequest = getCanonicalRequest(endPointUrl, httpMethod,
				canonicalizedQueryParameters, canonicalizedHeaderNames,
				canonicalizedHeaders, bodyHash);
		System.out.println("--------- Canonical request --------");
		System.out.println(canonicalRequest);
		System.out.println("------------------------------------");

		String dateStamp = dateStampFormat.format(now);
		String scope =  dateStamp + "/" + regionName + "/" + serviceName + "/" + TERMINATOR;
		String stringToSign = getStringToSign(SCHEME, ALGORITHM, dateTimeStamp, scope, canonicalRequest);
		System.out.println("--------- String to sign -----------");
		System.out.println(stringToSign);
		System.out.println("------------------------------------");

		byte[] kSecret = (SCHEME + awsSecretKey).getBytes();
		byte[] kDate = sign(dateStamp, kSecret, "HmacSHA256");
		byte[] kRegion = sign(regionName, kDate, "HmacSHA256");
		byte[] kService = sign(serviceName, kRegion, "HmacSHA256");
		byte[] kSigning = sign(TERMINATOR, kService, "HmacSHA256");
		byte[] signature = sign(stringToSign, kSigning, "HmacSHA256");

		String credentialsAuthorizationHeader =
				"Credential=" + awsAccessKey + "/" + scope;
		String signedHeadersAuthorizationHeader =
				"SignedHeaders=" + canonicalizedHeaderNames;
		String signatureAuthorizationHeader =
				"Signature=" + toHex(signature);

		String authorizationHeader = SCHEME + "-" + ALGORITHM + " "
		+ credentialsAuthorizationHeader + ", "
		+ signedHeadersAuthorizationHeader + ", "
		+ signatureAuthorizationHeader;

		return authorizationHeader;
	}

	def String getCanonicalizeHeaderNames(Map<String, String> headers) {
		List<String> sortedHeaders = new ArrayList<String>();
		sortedHeaders.addAll(headers.keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);

		StringBuilder buffer = new StringBuilder();
		for (String header : sortedHeaders) {
			if (buffer.length() > 0) buffer.append(";");
			buffer.append(header.toLowerCase());
		}

		return buffer.toString();
	}

	def String getCanonicalizedHeaderString(Map<String, String> headers) {
		if ( headers == null || headers.isEmpty() ) {
			return "";
		}

		List<String> sortedHeaders = new ArrayList<String>();
		sortedHeaders.addAll(headers.keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);

		StringBuilder buffer = new StringBuilder();
		for (String key : sortedHeaders) {
			buffer.append(key.toLowerCase().replaceAll("\\s+", " ") + ":" + headers.get(key).replaceAll("\\s+", " "));
			buffer.append("\n");
		}

		return buffer.toString();
	}

	def String getCanonicalRequest(URL endpoint,
			String httpMethod,
			String queryParameters,
			String canonicalizedHeaderNames,
			String canonicalizedHeaders,
			String bodyHash) {
		String canonicalRequest =
				httpMethod + "\n" +
				getCanonicalizedResourcePath(endpoint) + "\n" +
				queryParameters + "\n" +
				canonicalizedHeaders + "\n" +
				canonicalizedHeaderNames + "\n" +
				bodyHash;
		return canonicalRequest;
	}

	def String getCanonicalizedResourcePath(URL endpoint) {
		if ( endpoint == null ) {
			return "/";
		}
		String path = endpoint.getPath();
		if ( path == null || path.isEmpty() ) {
			return "/";
		}

		String encodedPath = urlEncode(path, true);
		if (encodedPath.startsWith("/")) {
			return encodedPath;
		} else {
			return "/".concat(encodedPath);
		}
	}

	def String getCanonicalizedQueryString(Map<String, String> parameters) {
		if ( parameters == null || parameters.isEmpty() ) {
			return "";
		}

		SortedMap<String, String> sorted = new TreeMap<String, String>();

		Iterator<Map.Entry<String, String>> pairs = parameters.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			String key = pair.getKey();
			String value = pair.getValue();
			sorted.put(urlEncode(key, false), urlEncode(value, false));
		}

		StringBuilder builder = new StringBuilder();
		pairs = sorted.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			builder.append(pair.getKey());
			builder.append("=");
			builder.append(pair.getValue());
			if (pairs.hasNext()) {
				builder.append("&");
			}
		}

		return builder.toString();
	}

	def String getStringToSign(String scheme, String algorithm, String dateTime, String scope, String canonicalRequest) {
		String stringToSign =
				scheme + "-" + algorithm + "\n" +
				dateTime + "\n" +
				scope + "\n" +
				toHex(hash(canonicalRequest));
		return stringToSign;
	}

	def byte[] hash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes("UTF-8"));
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException("Unable to compute hash while signing request: " + e.getMessage(), e);
		}
	}

	def byte[] hash(byte[] data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(data);
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException("Unable to compute hash while signing request: " + e.getMessage(), e);
		}
	}

	def byte[] sign(String stringData, byte[] key, String algorithm) {
		try {
			byte[] data = stringData.getBytes("UTF-8");
			Mac mac = Mac.getInstance(algorithm);
			mac.init(new SecretKeySpec(key, algorithm));
			return mac.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException("Unable to calculate a request signature: " + e.getMessage(), e);
		}
	}

	def byte[] fromHex(String hexData) {
		byte[] result = new byte[(hexData.length() + 1) / 2];
		String hexNumber = null;
		int stringOffset = 0;
		int byteOffset = 0;
		while (stringOffset < hexData.length()) {
			hexNumber = hexData.substring(stringOffset, stringOffset + 2);
			stringOffset += 2;
			result[byteOffset++] = (byte) Integer.parseInt(hexNumber, 16);
		}
		return result;
	}

	def String toHex(byte[] data) {
		StringBuilder sb = new StringBuilder(data.length * 2);
		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(data[i]);
			if (hex.length() == 1) {
				// Append leading zero.
				sb.append("0");
			} else if (hex.length() == 8) {
				// Remove ff prefix from negative numbers.
				hex = hex.substring(6);
			}
			sb.append(hex);
		}
		return sb.toString().toLowerCase(Locale.getDefault());
	}

	def String urlEncode(String url, boolean keepPathSlash) {
		String encoded;
		try {
			encoded = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 encoding is not supported.", e);
		}
		if ( keepPathSlash ) {
			encoded = encoded.replace("%2F", "/");
		}
		return encoded;
	}
}