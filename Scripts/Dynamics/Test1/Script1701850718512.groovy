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

WebUI.maximizeWindow()

CustomKeywords.'powerapps.Actions.loginToApp'('https://org5b593713.crm.dynamics.com/main.aspx?appid=b683736a-1091-ee11-be37-000d3a9ac3d5', 
    'pravinr@katalon203.onmicrosoft.com', 'Jbjbjatwowf@8081', 0)

//WebUI.navigateToUrl('https://org5b593713.crm.dynamics.com/main.aspx?appid=b683736a-1091-ee11-be37-000d3a9ac3d5')
//
//WebUI.setText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Sign in_loginfmt'), 'pravinr@katalon203.onmicrosoft.com')
//
//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))
//
//WebUI.delay(2)
//
//WebUI.setEncryptedText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Enter password_passwd'), 
//    'Nq6YlkHfJnqN7/p0T14fMvcoLMO4Lj+I')
//
//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))
//
//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_You have 14 days Ask Later'))
CustomKeywords.'powerapps.Actions.leftNavigationNavigateToLink'('Customers', 'Accounts', 0)

tr = CustomKeywords.'powerapps.Actions.workListGetTotalRecords'(0)

println(tr)

r = CustomKeywords.'powerapps.Actions.workListGetRecordsOnPage'(0)

println(r)

CustomKeywords.'powerapps.Actions.worklistFilterOptionsColumn'('Address 1: City', 'Contains', ['Redmond'], 0)

WebUI.delay(5)

CustomKeywords.'powerapps.Actions.worklistNavigateToFirstRecord'(3, 0)

//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_Do this to reduce the number of times_edee07'))
//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))
CustomKeywords.'powerapps.Actions.verifyTextBoxMandatory'('Account Name', 0)

name = CustomKeywords.'powerapps.Actions.getTextTextBox'('Account Name', 0)

println(name)

CustomKeywords.'powerapps.Actions.clearTextBoxContent'('Account Name', 0)

CustomKeywords.'powerapps.Actions.clickTextBox'('Account Name', 0)

CustomKeywords.'powerapps.Actions.focusOutTextBox'('Account Name', 0)

CustomKeywords.'powerapps.Actions.verifyTextBoxErrorText'('Account Name', 'Account Name: Required fields must be filled in.', 
    0)

CustomKeywords.'powerapps.Actions.setTextTextBox'('Account Name', 'New Account Name', 0)

currentPA = CustomKeywords.'powerapps.Actions.getValueLookUpTextBox'('Parent Account', 0)

println(currentPA)

CustomKeywords.'powerapps.Actions.setValueLookUpTextBox'('Parent Account', 'Alpine Ski House', 0)

WebUI.delay(5)

CustomKeywords.'powerapps.Actions.clickSaveAndClose'(0)

WebUI.closeBrowser()

