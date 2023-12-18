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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Set your test data
def _xrmUri = "your_xrm_uri"
def _username = "your_username"
def _password = "your_password"

// Open a new browser
WebUI.openBrowser('')

// Navigate to the login page
WebUI.navigateToUrl(_xrmUri)

// Login to the application
WebUI.setText(findTestObject('LoginPage/UsernameInput'), _username)
WebUI.setEncryptedText(findTestObject('LoginPage/PasswordInput'), _password)
WebUI.click(findTestObject('LoginPage/LoginButton'))

// Close Guided Help if present
WebUI.waitForElementPresent(findTestObject('GuidedHelp/CloseButton'), 5)
WebUI.click(findTestObject('GuidedHelp/CloseButton'))

// Navigate to the "Cases" sub-area
WebUI.click(findTestObject('Navigation/ServiceSubArea'))
WebUI.click(findTestObject('Navigation/CasesLink'))

// Switch to the "All Cases" view
WebUI.click(findTestObject('Grid/SwitchViewButton'))
WebUI.click(findTestObject('Grid/AllCasesView'))

// Open the first record
WebUI.click(findTestObject('Grid/OpenRecordButton'))

// Click the "Delete" button from the command bar
WebUI.click(findTestObject('CommandBar/DeleteButton'))

// Click the "Delete" button on the dialog
WebUI.click(findTestObject('Dialog/DeleteButton'))

// Add a wait time if needed
WebUI.delay(3)

// Close the browser
WebUI.closeBrowser()

