package aws

import org.apache.commons.lang3.RandomUtils
import org.apache.commons.lang3.RandomStringUtils
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.MessageFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.security.MessageDigest
import java.text.SimpleDateFormat

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.hc.client5.http.entity.EntityBuilder
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.Header
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder
import org.apache.hc.core5.http.message.BasicClassicHttpRequest
import org.apache.hc.core5.http.message.BasicHeader
import org.apache.http.HttpEntity
import org.apache.http.entity.ContentType

import com.katalon.org.apache.hc.client5.http.classic.methods.HttpPut
import com.kms.katalon.core.util.KeywordUtil

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import groovy.json.JsonSlurper

import internal.GlobalVariable

public class Transcribe {

	@Keyword
	def String startTranscribe(String s3UriTranscribeFile, String languageCode, String region, String accessKey, String secretKey, Integer timeOutSeconds) {
		if (languageCode.equals("") || languageCode == null) languageCode = "en-IN"
		String jobName = RandomStringUtils.randomAlphabetic(5)+"-"+RandomStringUtils.randomAlphabetic(5)
		String content = MessageFormat.format("'{'\"TranscriptionJobName\":\"{0}\",\"LanguageCode\":\"{1}\",\"Media\":'{'\"MediaFileUri\":\"{2}\"'}}'", jobName, languageCode, s3UriTranscribeFile)

		URL url;
		try {
			if (region.equals("us-east-1")) {
				url = new URL("https://transcribe."+region+".amazonaws.com");
			} else {
				url = new URL("https://transcribe-" + region + ".amazonaws.com");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Unable to parse transcribe endpoint: " + e.getMessage());
		}

		byte[] contentHash = hash(content);
		String contentHashString = toHex(contentHash);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Amz-Content-Sha256", contentHashString);
		headers.put("Content-Length", content.length().toString());
		headers.put("Content-Type", "application/x-amz-json-1.1")
		headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");
		headers.put("X-Amz-Target", "Transcribe.StartTranscriptionJob")
		String authorization = computeSignature(url, "POST", "transcribe", region, headers, null, contentHashString, accessKey, secretKey);
		headers.put("Authorization", authorization)
		String response;
		try {
			response = invokeHttpRequest(url, "POST", headers, content, 30);
		}catch (Exception e) {
			KeywordUtil.markFailed("Invoke transcribe failed : " + e.printStackTrace())
			return ""
		}

		KeywordUtil.markPassed("Invoke transcribe successful : " + response)
		KeywordUtil.logInfo("Monitor transcription job completion status")

		def transcription = getTranscription(url, jobName, region, accessKey, secretKey, timeOutSeconds)


		return transcription
	}

	def getTranscription(URL url, String jobName, String region, String accessKey, String secretKey, Number timeOut) {
		if (jobName.equals("") || jobName == null) KeywordUtil.markFailed("Transcription failed as there is no jobName to get : " + jobName)
		if (timeOut < 15 || timeOut == null) {
			if (timeOut == 0 || timeOut == null) timeOut=15;
		}
		String content = MessageFormat.format("'{'\"TranscriptionJobName\":\"{0}\"'}'", jobName)
		byte[] contentHash = hash(content);
		String contentHashString = toHex(contentHash);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Amz-Content-Sha256", contentHashString);
		headers.put("Content-Length", content.length().toString());
		headers.put("Content-Type", "application/x-amz-json-1.1")
		headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");
		headers.put("X-Amz-Target", "Transcribe.GetTranscriptionJob")
		String authorization = computeSignature(url, "POST", "transcribe", region, headers, null, contentHashString, accessKey, secretKey);
		headers.put("Authorization", authorization)
		String response;
		int timeElapsed = timeOut/5;
		boolean stop = false;
		String transcriptFileUrl;
		def jsonSlurper = new JsonSlurper()
		def jsonResponse
		while(!(stop || timeElapsed==0)){
			try {
				response = invokeHttpRequest(url, "POST", headers, content, timeOut);
			}catch (Exception e) {
				KeywordUtil.markFailed("Getting job status failed : " + e.printStackTrace())
				return
			}
			jsonResponse = jsonSlurper.parseText(response)
			String status = jsonResponse.TranscriptionJob.TranscriptionJobStatus
			if (status.equals("COMPLETED")) {
				transcriptFileUrl = jsonResponse.TranscriptionJob.Transcript.TranscriptFileUri
				KeywordUtil.logInfo("Transcription job : " + status)
				stop = true
			}
			else {
				Thread.sleep(5000)
				KeywordUtil.logInfo("Transcription job : " + status)
				timeElapsed -= 5
			}
		}
		if(transcriptFileUrl == null) {
			KeywordUtil.markFailed("Getting transcription file url failed")
			return
		}
		else {
			KeywordUtil.markPassed("Transcript file url : " + transcriptFileUrl);
		}
		URL fileUrl = new URL(transcriptFileUrl)
		try {
			response = invokeHttpRequest(fileUrl, "GET", null, null, 30);
		}catch (Exception e) {
			KeywordUtil.markFailed("Getting transcription failed : " + e.printStackTrace());
			return;
		}
		jsonResponse = jsonSlurper.parseText(response.trim())
		def noTrans = jsonResponse.results.transcripts.size()
		String finalTranscription = "";
		for(int i=0;i<noTrans;i++) finalTranscription = finalTranscription + jsonResponse.results.transcripts[i].transcript
		
		return finalTranscription
	}


	def String invokeHttpRequest(URL endpointUrl,
			String httpMethod,
			Map<String, String> headers,
			String requestBody, int timeOut) {
		HttpURLConnection connection = createHttpConnection(endpointUrl, httpMethod, headers, timeOut);
		try {
			if ( requestBody != null ) {
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(requestBody);
				wr.flush();
				wr.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Request failed. " + e.getMessage(), e);
		}
		return executeHttpRequest(connection);
	}

	def String executeHttpRequest(HttpURLConnection connection) {
		try {
			InputStream is;
			try {
				is = connection.getInputStream();
			} catch (IOException e) {
				is = connection.getErrorStream();
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			throw new RuntimeException("Request failed. " + e.getMessage(), e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	def HttpURLConnection createHttpConnection(URL endpointUrl,
			String httpMethod,
			Map<String, String> headers, int timeOut) {
		try {
			HttpURLConnection connection = (HttpURLConnection) endpointUrl.openConnection();
			connection.setRequestMethod(httpMethod);
			connection.setConnectTimeout(timeOut*1000)
			if ( headers != null ) {
				for ( String headerKey : headers.keySet() ) {
					connection.setRequestProperty(headerKey, headers.get(headerKey));
				}
			}

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			return connection;
		} catch (Exception e) {
			throw new RuntimeException("Cannot create connection. " + e.getMessage(), e);
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

		//headers.add(new BasicHeader("X-Amz-Date", dateTimeStamp));
		headers.put("X-Amz-Date", dateTimeStamp);

		String hostHeader = endPointUrl.getHost();
		int port = endPointUrl.getPort();
		if ( port > -1 ) {
			hostHeader.concat(":" + Integer.toString(port));
		}
		//headers.add(new BasicHeader("Host", hostHeader));
		headers.put("Host", hostHeader);

		String canonicalizedHeaderNames = getCanonicalizeHeaderNames(headers);
		String canonicalizedHeaders = getCanonicalizedHeaderString(headers);

		String canonicalizedQueryParameters = getCanonicalizedQueryString(queryParameters);

		String canonicalRequest = getCanonicalRequest(endPointUrl, httpMethod,
				canonicalizedQueryParameters, canonicalizedHeaderNames,
				canonicalizedHeaders, bodyHash);

		String dateStamp = dateStampFormat.format(now);
		String scope =  dateStamp + "/" + regionName + "/" + serviceName + "/" + TERMINATOR;
		String stringToSign = getStringToSign(SCHEME, ALGORITHM, dateTimeStamp, scope, canonicalRequest);

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

		String authorizationHeader = SCHEME + "-" + ALGORITHM + " " + credentialsAuthorizationHeader + ", " + signedHeadersAuthorizationHeader + ", " + signatureAuthorizationHeader;
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
