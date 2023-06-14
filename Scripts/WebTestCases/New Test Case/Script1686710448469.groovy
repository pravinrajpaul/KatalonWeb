import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://blueimp.github.io/jQuery-File-Upload/')

WebUI.click(findTestObject('Object Repository/FileUpload/Page_jQuery File Upload Demo/span_Start upload'))

WebUI.verifyElementText(findTestObject('Object Repository/FileUpload/Page_jQuery File Upload Demo/p_File Upload widget with multiple file sel_d79188'), 
    'File Upload widget with multiple file selection, drag&drop\n support, progress bars, validation and preview images, audio and video\n for jQuery.\n Supports cross-domain, chunked and resumable file uploads and\n client-side image resizing.\n Works with any server-side platform (PHP, Python, Ruby on Rails, Java,\n Node.js, Go etc.) that supports standard HTML form file uploads.')

WebUI.closeBrowser()

