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

WebUI.navigateToUrl('https://eportalqa.oc.holcim.net/#/login')

WebUI.setText(findTestObject('Object Repository/Holcim/Page_CustomerPortal/inputmat-input-0'), 'TestYellow')

WebUI.setEncryptedText(findTestObject('Object Repository/Holcim/Page_CustomerPortal/inputmat-input-1'), 'fHMRYnCsaka/yZs9rBxMZA==')

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/login_button'))

WebUI.waitForElementPresent(findTestObject('Holcim/Page_CustomerPortal/deliveries'), 30)

CustomKeywords.'mykeywords.CustomKeywords.clickJavaScript'(findTestObject('Holcim/Page_CustomerPortal/deliveries'))

//WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/deliveries'))

WebUI.click(findTestObject('Holcim/Page_CustomerPortal/calendar_from'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/calendar_month_year'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/calendar_year'), [('calendaryear') : calendaryear])

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/calendar_month', [('calendarmonth') : calendarmonth]))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/calendar_date_from', [('calendardatefrom') : calendardatefrom]))

WebUI.delay(2)

WebUI.click(findTestObject('Holcim/Page_CustomerPortal/calendar_to'))

WebUI.delay(2)

WebUI.click(findTestObject('Holcim/Page_CustomerPortal/calendar_month_year'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/calendar_year', [('calendaryear') : calendaryear]))

WebUI.delay(2)

WebUI.click(findTestObject('Holcim/Page_CustomerPortal/calendar_month', [('calendarmonth') : calendarmonth]))

WebUI.delay(2)

WebUI.click(findTestObject('Holcim/Page_CustomerPortal/calendar_date_from', [('calendardatefrom') : calendardatefrom]))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/product_type'))

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/div_Only Aggregates'))

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/span_Search'))

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/inputag-136-input'))

WebUI.click(findTestObject('Object Repository/Holcim/Page_CustomerPortal/img_custom-icon ng-star-inserted'))

