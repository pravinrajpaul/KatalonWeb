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

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/NEC/Page_Video. Phone. Messaging. Together Connected/a_Accept'))

WebUI.click(findTestObject('Object Repository/NEC/Page_Video. Phone. Messaging. Together Connected/a_Accept_1'))

WebUI.click(findTestObject('Object Repository/NEC/Page_Video. Phone. Messaging. Together Connected/a_Products'))

WebUI.click(findTestObject('Object Repository/NEC/Page_Video. Phone. Messaging. Together Connected/span_EXTEND'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC/Page_UNIVERGE BLUE EXTEND/h2_EVERYTHING YOUR ORGANIZATIONNEEDS TO STA_713fc0'), 
    'EVERYTHING YOUR ORGANIZATION\nNEEDS TO STAY PRODUCTIVE')

WebUI.click(findTestObject('Object Repository/NEC/Page_UNIVERGE BLUE EXTEND/a_Helpdesk'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC/Page_Zendesk/strong_UNIVERGE BLUE Extend'), 'UNIVERGE BLUE® EXTEND')

WebUI.click(findTestObject('Object Repository/NEC/Page_Zendesk/a_Admin Guide for Zendesk'))

WebUI.switchToWindowTitle('UNIVERGE BLUE® CONNECT Integration for Zendesk (Admin Guide)')

WebUI.click(findTestObject('Object Repository/NEC/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/button_Yes'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/div_Thanks for your feedback'), 
    'Thanks for your feedback.')

WebUI.takeFullPageScreenshotAsCheckpoint('HelpdeskPage')

WebUI.closeBrowser()

