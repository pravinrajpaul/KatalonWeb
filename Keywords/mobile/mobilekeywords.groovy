package mobile
import javax.sound.sampled.AudioFileFormat
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

import com.google.common.collect.ImmutableMap
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.result.WordResult
import io.appium.java_client.AppiumDriver
import net.sourceforge.jaad.aac.Decoder
import net.sourceforge.jaad.aac.SampleBuffer

class mobilekeywords {
	/**
	 */
	@Keyword
	def downloadFileToLocal(String fromFilePath, String toFilePath){
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		byte[] fileArr = driver.pullFile(fromFilePath)
		byteArrayToFile(fileArr, toFilePath)
	}


	@Keyword
	def deleteFilesInFolder(String folderPath){
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		if (!folderPath.endsWith("/")) folderPath = folderPath + "/"
		List<String> removeFilesArgs = Arrays.asList(
				"-rf",
				folderPath + "*.*"
				);
		Map<String, Object> removeFilesCmd = ImmutableMap.of(
				"command", "rm",
				"args", removeFilesArgs
				);
		driver.executeScript("mobile: shell", removeFilesCmd);
	}


	@Keyword
	def transcribeWavFile(String wavFilePath) {
		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

		StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
		InputStream stream = new FileInputStream(new File(wavFilePath));

		recognizer.startRecognition(stream);
		SpeechResult result;
		while ((result = recognizer.getResult()) != null) {
			System.out.format("Hypothesis: %s\n", result.getHypothesis());
			System.out.println("List of recognized words and their times:");
			for (WordResult r : result.getWords()) {
				System.out.println(r);
			}
		}

		recognizer.stopRecognition();
	}

	@Keyword
	def convertAudio(String fromFilePath, String toFilePath) {
		String cmdStr = "cmd /c ffmpeg -y -i \""+fromFilePath +"\" \"" + toFilePath + "\""
		println(cmdStr)
		try {
			Process proc = cmdStr.execute()
			proc.waitFor()
		}
		catch (Exception e) {
			KeywordUtil.markWarning("Some issue while converting file ")
		}
	}

	def byte[] aacToWav() {
		Decoder dec = new Decoder(decoderSpecificinfo);
		SampleBuffer buf = new SampleBuffer();
		dec.decodeFrame(aacFrame, buf);
		byte[] audio = buf.getData();
	}

	def byteArrayToFile(byte[] bytes, String filePath) {
		File file = new File(filePath);
		try {
			OutputStream os = new FileOutputStream(file);
			os.write(bytes);
			os.close();
		}
		catch (Exception e) {
			KeywordUtil.markWarning("Some issue with the file path " + filePath)
		}
	}

	def byte[] fileToByteArray(String filePath) {
		File file = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] byteArray = new byte[(int)file.length()];
			fis.read(byteArray);
			fis.close();
			return byteArray
		} catch (Exception e) {
			KeywordUtil.markWarning("Some issue with the file path " + filePath)
		}
	}


	def byte[] formatAACToWav() {
		Decoder dec = new Decoder(decoderSpecificinfo);
		SampleBuffer buf = new SampleBuffer();
		dec.decodeFrame(aacFrame, buf);
		byte[] audio = buf.getData();
	}

	def byte[] formatAudioToWav(byte[] audioFileContent, AudioFormat audioFormat) {
		final AudioInputStream originalAudioStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(audioFileContent));
		final AudioInputStream formattedAudioStream = AudioSystem.getAudioInputStream(audioFormat, originalAudioStream);
		final AudioInputStream lengthAddedAudioStream = new AudioInputStream(formattedAudioStream, audioFormat, audioFileContent.length);
		final ByteArrayOutputStream convertedOutputStream = new ByteArrayOutputStream()
		try {
			AudioSystem.write(lengthAddedAudioStream, AudioFileFormat.Type.WAVE, convertedOutputStream);
			originalAudioStream.close()
			formattedAudioStream.close()
			lengthAddedAudioStream.close()
			convertedOutputStream.close()
			return convertedOutputStream.toByteArray();
		}
		catch(Exception e) {
			KeywordUtil.markWarning("Some issue with audio file conversion")
		}
	}
}