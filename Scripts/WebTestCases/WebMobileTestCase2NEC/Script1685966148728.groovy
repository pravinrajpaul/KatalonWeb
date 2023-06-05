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

WebUI.navigateToUrl('https://www.univergeblue.com/')

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Accept'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Accept_1'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/button_Products_toggle-navigation open'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Products'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Customer experience'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_EXTENDAPI platform integrating UC  contac_9a8313'))

WebUI.scrollToElement(findTestObject('NEC Mobile/Page_UNIVERGE BLUE EXTEND/contactus'), 5)

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/button_US_toggle-navigation float-right'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/a_Helpdesk'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Zendesk/a_Admin Guide for Zendesk'))

WebUI.switchToWindowTitle('UNIVERGE BLUE® CONNECT Integration for Zendesk (Admin Guide)')

WebUI.verifyElementText(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/h3_UNIVERGE BLUE CONNECT'), 
    'UNIVERGE BLUE® CONNECT Integration for Zendesk (Admin Guide)')

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/button_Yes'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/div_Thanks for your feedback'), 
    'Thanks for your feedback.')

WebUI.closeBrowser()

