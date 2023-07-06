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

WebUI.navigateToUrl('https://onlinetradeb1na.powerbroking2u.com.my/webcms/')

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank Investment Bank/Trade Now'))

WebUI.setText(findTestObject('Object Repository/MaybankTrade/Page_Maybank Investment Bank/input_Username_ctl00cphContenttxtUsrID'), 
    'fit001')

WebUI.setEncryptedText(findTestObject('Object Repository/MaybankTrade/Page_Maybank Investment Bank/input_Password_ctl00cphContenttxtUsrPwd'), 
    '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank Investment Bank/img_1'))

WebUI.waitForElementClickable(findTestObject('MaybankTrade/Page_Maybank IB Trading Portal/span_Most Active (Volume)'), 3)

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_Most Active (Volume)'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('MaybankTrade/Page_Maybank IB Trading Portal/li_All StocksCtrlZ'))

WebUI.delay(3)

WebUI.doubleClick(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/td_0012'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_Total 0 order_ui-om_buy_oths'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_Normal Order'))

WebUI.click(findTestObject('MaybankTrade/Page_Maybank IB Trading Portal/div_OrderEntry'))

CustomKeywords.'mykeywords.CustomKeywords.clickJavaScript'(findTestObject('MaybankTrade/Page_Maybank IB Trading Portal/div_Account_acct'))

WebUI.delay(1)

WebUI.click(findTestObject('MaybankTrade/Page_Maybank IB Trading Portal/div_ADD00044- HEE LEE CHAN'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_Qty x100_txtQty'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_5'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_Price MYR_txtPx'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_9.150'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_Breakeven_btnSub'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_Always ask for trading pin_rbTrdgPpt'))

WebUI.setEncryptedText(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_Trading Pin_txtPwd'), 
    '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/input_minute(s)_btnOK'))

expectedTxt = 'Server rejected the order for the following reason(s):\n\nYour trading pin has been blocked. Please contact helpdesk.\n\nPlease Call Helpdesk.'

WebUI.verifyElementText(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/div_Server rejected the order for the follo_5a5865'), 
    expectedTxt, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/button_Ok'))

WebUI.click(findTestObject('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/span_X'))

WebUI.closeBrowser()

