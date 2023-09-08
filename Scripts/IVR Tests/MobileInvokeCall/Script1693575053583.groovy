import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.google.common.collect.ImmutableMap as ImmutableMap
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.startExistingApplication('com.android.dialer')

CustomKeywords.'mobile.mobilekeywords.deleteFilesInFolder'('/storage/emulated/0/Record/PhoneRecord/+918754450054')

//CustomKeywords.'mobile.mobilekeywords.downloadFileToLocal'('/storage/emulated/0/Record/PhoneRecord/+918754450054/918754450054-20230904210725.aac', 'C:\\Users\\pravi\\tmp\\sound.aac')
//CustomKeywords.'mobile.mobilekeywords.convertAudio'('C:\\Users\\pravi\\tmp\\record.m4a', 'C:\\Users\\pravi\\tmp\\record.wav')
//CustomKeywords.'mobile.mobilekeywords.convertToWAV'('C:\\Users\\pravi\\tmp\\sound.aac', 'C:\\Users\\pravi\\tmp\\sound.wav')	
//CustomKeywords.'mobile.mobilekeywords.transcribeWavFile'('C:\\Users\\pravi\\tmp\\sound.wav')
//Mobile.tap(findTestObject('Object Repository/IVR/android.widget.ImageView'), 0)
//
//Mobile.setText(findTestObject('Object Repository/IVR/android.widget.EditText'), '8754450054', 0)
//
//Mobile.tap(findTestObject('Object Repository/IVR/android.widget.ImageView (1)'), 0)
//
//Thread.sleep(30000)
//
//Mobile.tap(findTestObject('Object Repository/IVR/android.widget.ImageButton'), 0)
//List<String> removePicsArgs = Arrays.asList(
//	"-rf",
//	"/mnt/sdcard/Pictures/*.*"
//);
//Map<String, Object> removePicsCmd = ImmutableMap.of(
//	"command", "rm",
//	"args", removePicsArgs
//);
//driver.executeScript("mobile: shell", removePicsCmd);
Mobile.closeApplication()