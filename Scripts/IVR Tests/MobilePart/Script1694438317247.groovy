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

Mobile.startExistingApplication('com.android.dialer')

Mobile.tap(findTestObject('Object Repository/IVR/android.widget.ImageView (3)'), 0)

Mobile.setText(findTestObject('Object Repository/IVR/android.widget.EditText (1)'), '1800 202 6161', 0)

Mobile.tap(findTestObject('Object Repository/IVR/android.widget.ImageView (2)'), 0)

Thread.sleep(6000)

Mobile.tap(findTestObject('Object Repository/IVR/android.view.View'), 0)

Thread.sleep(9000)

Mobile.tap(findTestObject('Object Repository/IVR/android.widget.FrameLayout'), 0)

Thread.sleep(18000)

Mobile.tap(findTestObject('Object Repository/IVR/android.widget.LinearLayout'), 0)

Thread.sleep(18000)

Mobile.tap(findTestObject('Object Repository/IVR/android.widget.LinearLayout (1)'), 0)

Thread.sleep(25000)

CustomKeywords.'mobile.mobilekeywords.downloadFileToLocal'('/storage/emulated/0/Record/PhoneRecord/+9118002026161/18002026161-20230911201956.aac', 
    'C:\\Users\\pravi\\tmp\\test.aac')

Mobile.closeApplication()

