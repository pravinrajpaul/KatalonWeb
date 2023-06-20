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

WebUI.navigateToUrl('https://www.wavemakeronline.com/login/login')

WebUI.setText(findTestObject('Object Repository/WaveMaker/Page_WaveMaker/input_Login toWaveMaker_j_username'), 'pravin.raveendran@katalon.com')

WebUI.setEncryptedText(findTestObject('Object Repository/WaveMaker/Page_WaveMaker/input_Login toWaveMaker_j_password'), 
    'fJfSCPMMNStOFxmDHq2mgQ==')

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker/button_Login'))

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker Studio/a_Continue free trial'))

WebUI.click(findTestObject('WaveMaker/Page_WaveMaker Studio/a_SKIP'))

WebUI.waitForElementClickable(findTestObject('WaveMaker/Page_WaveMaker Studio/div_Got it'), 3)

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker Studio/div_Got it'))

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker Studio/div_Got it'))

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker Studio/button_Okay, got it'))

WebUI.mouseOver(findTestObject('WaveMaker/Page_WaveMaker Studio/card_Project'))

WebUI.click(findTestObject('Object Repository/WaveMaker/Page_WaveMaker Studio/a_Sample            Open in Studio (11.3)'))

WebUI.waitForElementClickable(findTestObject('WaveMaker/Page_WaveMaker Studio/div_NEXT_enjoyhint_close_btn'), 3)

WebUI.click(findTestObject('WaveMaker/Page_WaveMaker Studio/div_NEXT_enjoyhint_close_btn'))

WebUI.click(findTestObject('WaveMaker/Page_WaveMaker Studio/Obj_ContectInactive'))

WebUI.scrollToElement(findTestObject('WaveMaker/Page_WaveMaker Studio/li_Button'), 2)

WebUI.mouseOver(findTestObject('WaveMaker/Page_WaveMaker Studio/li_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WaveMaker/Page_WaveMaker Studio/li_Button'))

WebUI.delay(2)

CustomKeywords.'robot.Keywords.dragAndDropToElementWait'([findTestObject('WaveMaker/Page_WaveMaker Studio/li_Button'), findTestObject(
            'WaveMaker/Page_WaveMaker Studio/obj_Content')])

WebUI.delay(5)

WebUI.takeFullPageScreenshot('Drag&Drop')

WebUI.closeBrowser()

