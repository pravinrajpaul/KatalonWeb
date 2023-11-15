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

WebUI.navigateToUrl('https://orgdc85b499.crm8.dynamics.com/main.aspx?appid=79496bbe-d159-ee11-8df0-000d3af0631f&pagetype=entityrecord&etn=sample_teamproject&id=e2ea80eb-db68-ee11-9ae7-6045bdad1da3')

WebUI.setText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Sign in_loginfmt'), 'gokul@gokulsystems.co.site')

WebUI.delay(2)

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.setEncryptedText(findTestObject('Object Repository/Powerapps/Page_Sign in to your account/input_Enter password_passwd'), 
    'fJfSCPMMNStOFxmDHq2mgQ==')

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_concat_Stay signed in'))

WebUI.click(findTestObject('Powerapps/Page_Sign in to your account/input_You have 14 days Ask Later'))

CustomKeywords.'powerapps.keywords.verifyLookUpTextBoxMandatory'('Project lead', 0)

CustomKeywords.'powerapps.keywords.verifyLookUpTextBoxNotMandatory'('Project lead', 0)

lookup = CustomKeywords.'powerapps.keywords.getValueLookUpTextBox'('Project lead', 0)

println(lookup)

CustomKeywords.'powerapps.keywords.setValueLookUpTextBox'('Project lead', '# BizQA', 0)

biz = CustomKeywords.'powerapps.keywords.getValueLookUpTextBox'('Project lead', 0)

println(biz)

CustomKeywords.'powerapps.keywords.setValueSelectBox'('Project Type', 'Manager driven', 0)

select = CustomKeywords.'powerapps.keywords.getSelectedSelectBox'('Project Type', 0)

println(select)

select = CustomKeywords.'powerapps.keywords.verifySelectBoxMandatory'('Project Type', 0)

CustomKeywords.'powerapps.keywords.assignOwner'('# CDSFileStorage', 0)

WebUI.delay(5)

WebUI.closeBrowser()

