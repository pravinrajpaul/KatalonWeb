import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('Resources\\Mobile\\Apk\\Expense_Flutter_5.apk', true)

title = CustomKeywords.'flutter.Keywords.getText1'(findTestObject(null))

println(title)

not_run: Mobile.tap(findTestObject('Object Repository/Flutter Expense/android.widget.Button'), 0)

not_run: Mobile.setText(findTestObject('Object Repository/Flutter Expense/android.widget.EditText'), 'My Expense', 0)

not_run: Mobile.setText(findTestObject('Object Repository/Flutter Expense/android.widget.EditText (1)'), '1', 0)

not_run: Mobile.tap(findTestObject('Object Repository/Flutter Expense/android.widget.Button'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Flutter Expense/android.view.View'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Flutter Expense/android.widget.Button (1)'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Flutter Expense/android.widget.Button (2)'), 0)

Mobile.closeApplication()

