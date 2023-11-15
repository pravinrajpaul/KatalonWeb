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

WebUI.navigateToUrl('https://orgdc85b499.crm8.dynamics.com/main.aspx?appid=79496bbe-d159-ee11-8df0-000d3af0631f&pagetype=entitylist&etn=sample_teamproject&viewid=29eda4a4-3759-4621-a265-f51241a1ad3c&viewType=1039')

WebUI.setText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Sign in_loginfmt'), 'gokul@gokulsystems.co.site')

WebUI.delay(2)

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.setEncryptedText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Enter password_passwd'), 
    'fJfSCPMMNStOFxmDHq2mgQ==')

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_You have 14 days Ask Later'))

CustomKeywords.'powerapps.keywords.leftNavigationNavigateToLink'('Innovation', 'Team Projects', 0)

tr = CustomKeywords.'powerapps.keywords.workListGetTotalRecords'(0)

println(tr)

r = CustomKeywords.'powerapps.keywords.workListGetRecordsOnPage'(0)

println(r)

CustomKeywords.'powerapps.keywords.worklistFilterOptionsColumn'('Budget status', 'Contains data', ['On'], 0)

WebUI.delay(5)

CustomKeywords.'powerapps.keywords.worklistNavigateToFirstRecord'(0)

//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_Do this to reduce the number of times_edee07'))
//WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))
CustomKeywords.'powerapps.keywords.verifyTextBoxMandatory'('Name', 0)

name = CustomKeywords.'powerapps.keywords.getTextTextBox'('Name', 0)

println(name)

CustomKeywords.'powerapps.keywords.clearTextBoxContent'('Name', 0)

CustomKeywords.'powerapps.keywords.clickTextBox'('Name', 0)

CustomKeywords.'powerapps.keywords.focusOutTextBox'('Name', 0)

CustomKeywords.'powerapps.keywords.verifyTextBoxErrorText'('Name', 'Name: Required fields must be filled in.', 0)

CustomKeywords.'powerapps.keywords.setTextTextBox'('Name', 'Hi', 0)

CustomKeywords.'powerapps.keywords.setTextRichTextBox'('Description', 'Hello', 10)

txt = CustomKeywords.'powerapps.keywords.getTextRichTextBox'('Description', 10)

println(txt)

CustomKeywords.'powerapps.keywords.clearTextRichTextBox'('Description', 0)

CustomKeywords.'powerapps.keywords.verifyRichTextBoxMandatory'('Description', 0)

CustomKeywords.'powerapps.keywords.getValueLookUpTextBox'('Project lead', 0)

CustomKeywords.'powerapps.keywords.setValueLookUpTextBox'('Project lead', 'Gokul S', 0)

CustomKeywords.'powerapps.keywords.setValueLookUpTextBox'('Project lead', '# BizQA', 0)

CustomKeywords.'powerapps.keywords.clearTextRichTextBox'('Project lead', 0)

CustomKeywords.'powerapps.keywords.setValueLookUpTextBox'('Project lead', '# BizQA', 0)

WebUI.delay(5)

WebUI.closeBrowser()

