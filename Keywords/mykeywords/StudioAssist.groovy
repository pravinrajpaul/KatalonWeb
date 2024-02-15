package mykeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class StudioAssist {

	/*Generate a Katalon keyword to connect to a sqlserver database then query with sql query and finally return the first row as a map object*/

	/*Genarate a Katalon keyword using apache poi to fetch data from specified cell in a xlsx file*/

	/*Genarate a Katalon keyword for javascript way to set text to input field in katalon object repository*/

	/*Generate a Katalon keyword to transform an json node element to another and return the json object*/

	/*Generate a Katalon keyword to extract specific data from pdf file using pdfbox apache library*/

	/*Generate a katalon keyword to upload a image file to webportal*/

	/*Generate 2 Katalon keywords, one that saves cookies from existing browser session before close browser and second keyword that subsequently uses the saved cookie in the test case*/
	/*
	 *  This keyword saves the cookies from the existing browser session before closing the browser.
	 *
	 *  @param driver The WebDriver instance
	 *  @param cookiesVariable The name of the variable to store the cookies
	 */
	// Save cookies from existing browser session
	@Keyword
	def saveCookies() {
		// Get the cookies from the browser session
		WebDriver driver = DriverFactory.getWebDriver()
		GlobalVariable.cookiesVariable = DriverFactory.getWebDriver().manage().getCookies()
	}

	/*
	 *  This keyword uses the saved cookies in the test case.
	 *
	 *  @param driver The WebDriver instance
	 *  @param cookiesVariable The name of the variable that stores the cookies
	 */
	// Use saved cookies in a test case
	@Keyword
	def useSavedCookies() {
		WebDriver driver = DriverFactory.getWebDriver()
		// Set the saved cookies in the browser session
		driver.manage().deleteAllCookies()
		driver.manage().addCookie(GlobalVariable.cookiesVariable)
	}
}