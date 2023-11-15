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

encryptedPassword = CustomKeywords.'synapxe.cyberark.Integration.getEncryptedSecret'('https://hispimvsweb01.hcloud.healthgrp.com.sg/AIMWebService/api/Accounts', 
    'APP_TEST1', 'HDC1-HCLD-LADM-WIN-STG', 'healthgrp-svchissant02', 0)
//encryptedPassword = CustomKeywords.'synapxe.cyberark.Integration.encryptSecret'('admin123')

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_OrangeHRM/input_Username_username'), 'Admin')

CustomKeywords.'synapxe.cyberark.Integration.setEncryptedPassword'(findTestObject('Page_OrangeHRM/input_Password_password'), 
    encryptedPassword, 0)

WebUI.click(findTestObject('Page_OrangeHRM/button_Login'))

WebUI.delay(5)

WebUI.closeBrowser()

