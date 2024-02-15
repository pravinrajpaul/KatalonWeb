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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

/**
Test Steps

Open browser
Maximize browser window
Navigate to google.com
Type "today's news" in the search box
Click the search button
Navigate to the first result
*/

WebUI.openBrowser('')


WebUI.maximizeWindow()


WebUI.navigateToUrl('https://www.google.com')


WebUI.setText(findTestObject('Page_Google/input_q'), 'today\'s news')


WebUI.click(findTestObject('Page_Google/input_btnK'))


WebUI.click(findTestObject('Page_Google/a_firstResult'))
/*
 *  This code opens a web browser, maximizes the window, navigates to Google's homepage,
 *  enters the text "today's news" in the search bar, clicks the search button, and clicks on the first search result.
 *
 *  1. Open a web browser.
 *  2. Maximize the window.
 *  3. Navigate to Google's homepage.
 *  4. Enter the text "today's news" in the search bar.
 *  5. Click the search button.
 *  6. Click on the first search result.
 *
 */

