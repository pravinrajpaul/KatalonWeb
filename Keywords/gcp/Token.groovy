package gcp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Token {

	@Keyword
	def String startTranscribe(String inputAudioFile, String languageCode, String googleProjectID, String jsonServiceAccountKeyPath) {
		setGCPProject(googleProjectID)
		activateGCPServiceAccount(jsonServiceAccountKeyPath)
		getToken()
	}

	def setGCPProject(String googleProjectID) {
		String cmdStr = "cmd /c gcloud auth application-default set-quota-project " + googleProjectID
		try {
			Process proc = cmdStr.execute()
			proc.waitFor()
		}
		catch (Exception e) {
			KeywordUtil.markWarning("Unable to set coloud quota project to : " + googleProjectID)
		}
	}


	def activateGCPServiceAccount(String jsonKeyPath) {
		String cmdStr = "cmd /c gcloud auth activate-service-account --key-file= \"" + jsonKeyPath + "\""
		try {
			Process proc = cmdStr.execute()
			proc.waitFor()
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Unable to set Account Key")
		}
	}

	def String getToken() {
		String cmdStr = "cmd /c gcloud auth application-default print-access-token"
		try {
			Process proc = cmdStr.execute()
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()))
			String lines = ""
			String line = ""
			def loop = 0
			while ((line = reader.readLine()) != null) {
				if (loop==0) lines += line
				else lines += (line+"\n")
				loop++
			}
			reader.close();
			int exitValue = proc.waitFor();
			if (exitValue != 0) {
				KeywordUtil.markFailed("Abnormal process termination");
				return ""
			}
			return lines
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Unable to get token for GCP default project iam : " + e.printStackTrace())
		}
	}
}