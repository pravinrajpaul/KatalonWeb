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
import org.apache.commons.lang3.RandomStringUtils as Random

/**
1. Open the webportal

2. Enter valid username and password

3. Click on the login button
*/
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/area'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_RP-SN-01'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Register Now'))

n = Random.randomAlphanumeric(6)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_User ID_username'), (name + ' ') + n)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_New password_password'), (name + '@') + n)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Repeat password_repeatedPassword'), (name + '@') + 
    n)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_First name_account.firstName'), name)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Last name_account.lastName'), n)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Email_account.email'), (((name + n) + '@') + name) + 
    '.com')

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Phone_account.phone'), phone)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Address 1_account.address1'), addressline1)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Address 2_account.address2'), addressline2)

Mobile.checkElement(findTestObject(null), 0)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_City_account.city'), city)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_State_account.state'), state)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Zip_account.zip'), postcode)

WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Country_account.country'), country)

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Enable MyList_account.listOption'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/td'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Enable MyBanner_account.bannerOption'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Enable MyBanner_newAccount'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_Sign In_img_cart'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Ship to different address_newOrder'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Confirm'))

WebUI.takeScreenshotAsCheckpoint('Visual_test2')

WebUI.closeBrowser()

