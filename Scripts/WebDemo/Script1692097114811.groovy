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

WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_K9-BD-01'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_EST-6'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))

WebUI.rightClick(findTestObject('Object Repository/Page_JPetStore Demo/div_Please enter your username and password_a3c923'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_JPetStore Demo/div_Please enter your username and password_a3c923'), 
    'Please enter your username and password.\n\tUsername:setTimeout(function(){try{var z=document.getElementById(\'stripes-1933500542\');z.focus();z.select();}catch(e){}},1); \n\tPassword:\n\t\n\n Need a user name and password? Register Now!')

WebUI.closeBrowser()

