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

Mobile.startApplication('C:\\Users\\pravi\\Downloads\\ibizzuat_automation_22nd_aug.apk', true)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.TextView - I am an ICICI Bank account holder'), 
    0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.TextView - User ID  Password'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Button - Verify Mobile Number'), 0)

Mobile.setText(findTestObject('Object Repository/ICICI Mobile/android.widget.EditText (3)'), 'INSTABIZDEV83.user1', 0)

Mobile.setText(findTestObject('Object Repository/ICICI Mobile/android.widget.EditText (4)'), 'Uat#123456', 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Button'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Button - Login (1)'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Image - search'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Image - moreicon (1)'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Image - open-fd (1)'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.TextView - Select your debit account'), 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.TextView - 004605002470'), 0)

Mobile.clearText(findTestObject('Object Repository/ICICI Mobile/android.widget.EditText - 1000 (1)'), 0)

Mobile.setText(findTestObject('Object Repository/ICICI Mobile/android.widget.EditText (5)'), '12000', 0)

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Button - 5 years (1)'), 0)

Mobile.scrollToText('On Maturity')

Mobile.tap(findTestObject('Object Repository/ICICI Mobile/android.widget.Button - Open FD (1)'), 0)

Mobile.tap(findTestObject('ICICI Mobile/android.widget.Button - Confirm Details'), 0)

thread.sleep(10000)

Mobile.takeScreenshot('C:\\Users\\pravi\\Downloads\\Finalpage.png', FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

