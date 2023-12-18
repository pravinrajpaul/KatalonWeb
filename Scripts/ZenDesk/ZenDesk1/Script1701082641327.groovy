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

WebUI.navigateToUrl('https://katalon9086.zendesk.com/auth/v2/login/signin?return_to=https%3A%2F%2Fkatalon9086.zendesk.com%2Fagent%2Ffilters%2F15083514922013&theme=hc&locale=1&brand_id=15083540415901&auth_origin=15083540415901%2Cfalse%2Ctrue&role=agent')

WebUI.setText(findTestObject('Object Repository/Zendesk/Page_Zendesk Auth/input_useremail'), 'pravin.raveendran@katalon.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Zendesk/Page_Zendesk Auth/input_userpassword'), 'Nq6YlkHfJnqN7/p0T14fMvcoLMO4Lj+I')

WebUI.click(findTestObject('Object Repository/Zendesk/Page_Zendesk Auth/button_Sign in'))

WebUI.mouseOver(findTestObject('Object Repository/Zendesk/Page_View Your unsolved tickets  Katalon  Zendesk/button_add'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Zendesk/Page_View Your unsolved tickets  Katalon  Zendesk/li_Ticket'))

WebUI.waitForElementPresent(findTestObject('Zendesk/Page_New ticket  Katalon  Zendesk/input131val-field_2.1.0--input'), 
    5)

WebUI.setText(findTestObject('Zendesk/Page_New ticket  Katalon  Zendesk/input131val-field_2.1.0--input'), 'Subject Text')

WebUI.click(findTestObject('Object Repository/Zendesk/Page_Ticket Subject Text  Katalon  Zendesk/div_sc-q5rfsr-0 hxDCzu'))

WebUI.sendKeys(findTestObject('Object Repository/Zendesk/Page_Ticket Subject Text  Katalon  Zendesk/div_sc-q5rfsr-0 hxDCzu'), 
    'Description Text\'')

WebUI.click(findTestObject('Object Repository/Zendesk/Page_Ticket Subject Text  Katalon  Zendesk/button_Submit as New'))

WebUI.waitForElementPresent(findTestObject('Zendesk/Page_View Your unsolved tickets  Katalon  Zendesk/noOfTickets'), 5)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Zendesk/Page_View Your unsolved tickets  Katalon  Zendesk/a_1stTicket'), 
    'Subject Text')

WebUI.closeBrowser()

