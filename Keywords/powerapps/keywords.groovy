package powerapps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class keywords {

	@Keyword
	def setTextTextBox(String label, String text, Number xTimeOutSeconds) {

		WebDriver webDriver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)

		def inputX = "//input[@aria-label='"+label+"']"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
		WebElement input = webDriver.findElement(By.xpath(inputX))
		input.sendKeys(text)
	}

	@Keyword
	def setTextRichTextBox(String label, String text, Number xTimeOutSeconds) {

		WebDriver webDriver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)

		def oframeX = "div:has(span[title='"+label+"'])+div iframe,div:has( span[aria-label='"+label+"'])+div iframe"
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(oframeX)))
		def tframeX = "iframe[title='"+label+" rich text editor'],iframe[aria-label='"+label+" rich text editor']"
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(tframeX)))
		def rtBody = "//body[@data-msdyn-rteplaceholder='Enter text...']"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rtBody)))
		WebElement rtBodyElement = webDriver.findElement(By.xpath(rtBody))
		rtBodyElement.click()
		rtBodyElement.sendKeys(text)
		webDriver.switchTo().defaultContent()
	}
}