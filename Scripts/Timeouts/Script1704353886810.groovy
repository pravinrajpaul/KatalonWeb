import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

CustomKeywords.'web.WebAdditives.openChromeBrowserCustomCapabilities'('https://filecr.com/', ['--start-maximized', '--user-data-dir=\'C:\\Users\\pravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\''
        , '--profile-directory=\'Profile 1\''], [:], [:])

WebUI.setText(findTestObject('Object Repository/Timeouts and Security/Page_FileCR - THE BIGGEST SOFTWARE STORE/input_Please enter at least 3 characters_se_f4df24'), 
    'windowmanager')

WebUI.click(findTestObject('Object Repository/Timeouts and Security/Page_FileCR - THE BIGGEST SOFTWARE STORE/svg'))

WebUI.click(findTestObject('Object Repository/Timeouts and Security/Page_You searched for windowmanager  FileCR/a_WindowManager 10.13.4'))

WebUI.click(findTestObject('Object Repository/Timeouts and Security/Page_WindowManager 10.13.4 Free Download - FileCR/button_Direct Download'))

not_run: WebUI.waitForElementVisible(findTestObject('Object Repository/Timeouts and Security/Page_FileCR  Download/li_Click to Download'), 
    10)

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Timeouts and Security/Page_FileCR  Download/a_Click to DownloadGenerating Download Link_632ef4'))

WebUI.delay(15)

WebUI.closeBrowser()

