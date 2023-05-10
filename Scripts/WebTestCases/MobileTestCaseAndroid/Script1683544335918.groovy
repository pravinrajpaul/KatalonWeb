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

Mobile.startApplication('Resources/Mobile/Apk/Telegram.apk', true)

Mobile.tap(findTestObject('Object Repository/Mobile/android.widget.TextView - Start Messaging (4)'), 0)

Mobile.tapAndHold(findTestObject('Object Repository/Mobile/android.widget.ImageView (1)'), 0, 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.widget.TextView'), 0)

Mobile.scrollToText('India')

Mobile.tap(findTestObject('Object Repository/Mobile/android.widget.TextView -  India (2)'), 0)

Mobile.tap(findTestObject('Mobile/android.view.View (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (2)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (3)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (4)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (5)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (6)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (7)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (8)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (9)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (10)'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/android.view.View (11)'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Mobile/android.widget.TextView - Invalid phone number. Please check the number and try again (1)'), 
    'Invalid phone number. Please check the number and try again.')

Mobile.tap(findTestObject('Object Repository/Mobile/android.widget.TextView - OK (1)'), 0)

Mobile.closeApplication()

