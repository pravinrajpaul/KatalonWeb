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

WebUI.navigateToUrl('https://orgdc85b499.crm8.dynamics.com/main.aspx?appid=79496bbe-d159-ee11-8df0-000d3af0631f&pagetype=entityrecord&etn=sample_teamproject&id=cd9596ae-5118-e811-a832-000d3a37c848')

WebUI.setText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Sign in_loginfmt'), 'gokul@gokulsystems.co.site')

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.setEncryptedText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Enter password_passwd'), 
    'fJfSCPMMNStOFxmDHq2mgQ==')

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_You have 14 days Ask Later'))

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_Do this to reduce the number of times_edee07'))

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

CustomKeywords.'com.katalon.plugin.keyword.powerapps.ObjectInteractions.setTextTextBox'('Name', 'Hi!!!', 10)

CustomKeywords.'com.katalon.plugin.keyword.powerapps.ObjectInteractions.setTextRichTextBox'('Description', 'Hello', 10)

CustomKeywords.'com.katalon.plugin.keyword.powerapps.ObjectInteractions.setTextTextBox'('Name', 'Hi!!!', 10)

//WebUI.click(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Do this to reduce the number of times_edee07'))
//WebUI.click(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Sign in_idSIButton9'))
//WebUI.click(findTestObject('Object Repository/Powerapps/Page_Team Project Information Cloud Computing -/html_Description rich text editor'))
//WebUI.setText(findTestObject('Object Repository/Powerapps/Page_Team Project Information Cloud Computing -/div'), 'Hello')
//CustomKeywords.'powerapps.keywords.setTextRichTextBox'('Hello', findTestObject('Powerapps/Page_Team Project Information Cloud Computing -/div'))
Thread.sleep(10000)

WebUI.closeBrowser()

