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
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.TimeoutException

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

	//	@Keyword
	//	def loginToApp(String url, String userName, String password, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def user = "//*[@type = 'email' and @name = 'loginfmt' and @placeholder = 'Email, phone, or Skype']"
	//		def pass = "//*[@name = 'passwd' and @type = 'password' and @placeholder = 'Password']"
	//		def signin = "//*[@type = 'submit']"
	//		def askLater = "//*[@type = 'button']"
	//
	//
	//		webDriver.navigate().to(url)
	//
	//		WebElement userO
	//		WebElement passwordO
	//		WebElement signinO
	//		WebElement askLaterO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(user)))
	//			userO = webDriver.findElement(By.xpath(user))
	//			signinO = webDriver.findElement(By.xpath(signin))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("User field not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("User field not found")
	//			return
	//		}
	//		userO.sendKeys(userName)
	//		signinO.click()
	//		WebUI.delay(2)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pass)))
	//			passwordO = webDriver.findElement(By.xpath(pass))
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(signin)))
	//			signinO = webDriver.findElement(By.xpath(signin))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Password field not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Password field not found")
	//			return
	//		}
	//		passwordO.sendKeys(password)
	//		signinO.click()
	//
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(askLater)))
	//			askLaterO = webDriver.findElement(By.xpath(askLater))
	//			askLaterO.click()
	//		}
	//		catch (NoSuchElementException e) {
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			return
	//		}
	//	}
	//
	//	//Left Navigation Bar
	//	@Keyword
	//	def leftNavigationNavigateToLink(String sectionHeading, String linkText, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		if (!sectionHeading.equalsIgnoreCase('') || sectionHeading != null) {
	//			def section = "//li/h3[@role='heading'][text()='"+sectionHeading+"']"
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(section)))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Left navigation bar section "+sectionHeading+" not found")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Left navigation bar section "+sectionHeading+" not found")
	//				return
	//			}
	//		}
	//
	//
	//		def link = "//h3[@role='heading'][text()='"+sectionHeading+"']/parent::li/ul/li//span[text()='"+linkText+"']"
	//		WebElement linkO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(link)))
	//			linkO = webDriver.findElement(By.xpath(link))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Left navigation bar link "+linkText+" not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Left navigation bar link "+linkText+" not found")
	//			return
	//		}
	//		linkO.click()
	//	}
	//
	//
	//	//Worklist top bar actions
	//	@Keyword
	//	def worklistCreateNewRecord(Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "button[aria-label='New'][role='menuitem']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("New button not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("New button not found on the UI")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistDeleteSelectedRecords(Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "li[aria-label='Delete'][role='menuitem']>ul>button[title^='Delete']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Delete button not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Delete button not found on the UI")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistRefreshWorkListPage(Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "button[aria-label='Refresh'][role='menuitem']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Refresh button not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Refresh button not found on the UI")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//
	//	//Worklist page actions
	//	def worklistSelectWorklistView(String viewName, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def listDrop = "h1>button[id^='ViewSelector'] i"
	//		WebElement listDropO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(listDrop)))
	//			listDropO = webDriver.findElement(By.cssSelector(listDrop))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("View selector dropdown not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("View selector dropdown not found on the UI")
	//			return
	//		}
	//		listDropO.click()
	//
	//		def dropViewSelected = "//li/button//label[text()='"+viewName+"']/preceding-sibling::i[@data-icon-name='CheckMark']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropViewSelected)))
	//			KeywordUtil.markPassed("View selector dropdown view "+viewName+" is already selected")
	//			listDropO.click()
	//			return
	//		}
	//		catch (NoSuchElementException e) {
	//		}
	//		catch (TimeoutException e) {
	//		}
	//
	//		def dropView = "//li/button//label[text()='"+viewName+"']"
	//		WebElement dropViewO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropView)))
	//			dropViewO = webDriver.findElement(By.xpath(dropView))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("View selector dropdown view "+viewName+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("View selector dropdown view "+viewName+" not found on the UI")
	//			return
	//		}
	//		dropViewO.click()
	//	}
	//
	//	@Keyword
	//	def worklistKeywordFilter(String filterText, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def input = $/input[id^='quickFind'][aria-label$$='Filter by keyword']/$
	//		WebElement inputO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(input)))
	//			inputO = webDriver.findElement(By.cssSelector(input))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Filter keyword input field not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Filter keyword input field not found on the UI")
	//			return
	//		}
	//		inputO.sendKeys(filterText)
	//
	//		def button = "button[id^='quickFind_arrow'][aria-label='Start search']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Filter keyword input field search button not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Filter keyword input field search button not found on the UI")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistCancelKeywordFilter(Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "button[id^='quickFind_clear'][aria-label='Clear search']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Filter keyword input field cancel button not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Filter keyword input field cancel button not found on the UI")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistNavigateToFirstRecord(Number linkColIndex, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def link = "div[aria-colindex='"+linkColIndex+"'] a[role='link'].ms-Link"
	//		WebElement linkO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(link)))
	//			linkO = webDriver.findElement(By.cssSelector(link))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to navigate to the first record")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to navigate to the first record")
	//			return
	//		}
	//		linkO.click()
	//	}
	//
	//	@Keyword
	//	def worklistFilterTextColumn(String columnName, String filterType, String filterValue, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def filterChevron = "//div[text()='"+columnName+"']//parent::label//ancestor::div[@data-testid='columnHeader'][@aria-haspopup='menu']//i[@data-icon-name='ChevronDownSmall'][starts-with(@class, 'chevronIcon')]"
	//		WebElement filterChevronO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterChevron)))
	//			filterChevronO = webDriver.findElement(By.xpath(filterChevron))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		filterChevronO.click()
	//
	//		def button = "button[name='Filter by']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		buttonO.click()
	//
	//		def select = "div[aria-label='Filter by operator'] span"
	//		WebElement selectO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(select)))
	//			selectO = webDriver.findElement(By.cssSelector(select))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		String selectedFilterType = selectO.getText()
	//
	//		if (!selectedFilterType.equalsIgnoreCase(filterType)) {
	//
	//			selectO.click()
	//			def filterTypeOption = "//button//span[text()='"+filterType+"']"
	//			WebElement filterTypeOptionO
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterTypeOption)))
	//				filterTypeOptionO = webDriver.findElement(By.xpath(filterTypeOption))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			filterTypeOptionO.click()
	//		}
	//
	//
	//		if (!(filterType.equalsIgnoreCase("Equals") || filterType.equalsIgnoreCase("Does not equal"))) {
	//			def text = "input[aria-label='Filter by value']"
	//			WebElement textO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text)))
	//				textO = webDriver.findElement(By.cssSelector(text))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			textO.sendKeys(filterValue)
	//			textO.click()
	//
	//
	//			def selectD = "button[aria-label='"+filterValue+"']"
	//			WebElement selectDO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectD)))
	//				selectDO = webDriver.findElement(By.cssSelector(selectD))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find filter option "+filterValue)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find filter option "+filterValue)
	//				return
	//			}
	//			selectDO.click()
	//		}
	//
	//
	//		if (!(filterType.equalsIgnoreCase("Contains data") || filterType.equalsIgnoreCase("Does not contain data"))) {
	//			def text = "input[aria-label='Filter by value']"
	//			WebElement textO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text)))
	//				textO = webDriver.findElement(By.cssSelector(text))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			textO.sendKeys(filterValue)
	//
	//			def heading = "//h3[text()='Filter By']"
	//			WebElement headingO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(heading)))
	//				headingO = webDriver.findElement(By.xpath(heading))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			headingO.click()
	//		}
	//
	//		def filterButton = "button[type='submit']>span"
	//		WebElement filterButtonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(filterButton)))
	//			filterButtonO = webDriver.findElement(By.cssSelector(filterButton))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		filterButtonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistFilterNumberColumn(String columnName, String filterType, String filterValue, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def filterChevron = "//div[text()='"+columnName+"']//parent::label//ancestor::div[@data-testid='columnHeader'][@aria-haspopup='menu']//i[@data-icon-name='ChevronDownSmall'][starts-with(@class, 'chevronIcon')]"
	//		WebElement filterChevronO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterChevron)))
	//			filterChevronO = webDriver.findElement(By.xpath(filterChevron))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		filterChevronO.click()
	//
	//		def button = "button[name='Filter by']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		buttonO.click()
	//
	//		def select = "div[aria-label='Filter by operator'] span"
	//		WebElement selectO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(select)))
	//			selectO = webDriver.findElement(By.cssSelector(select))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		String selectedFilterType = selectO.getText()
	//
	//		if (!selectedFilterType.equalsIgnoreCase(filterType)) {
	//
	//			selectO.click()
	//			def filterTypeOption = "//button//span[text()='"+filterType+"']"
	//			WebElement filterTypeOptionO
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterTypeOption)))
	//				filterTypeOptionO = webDriver.findElement(By.xpath(filterTypeOption))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			filterTypeOptionO.click()
	//		}
	//
	//		if (!(filterType.equalsIgnoreCase("Contains data") || filterType.equalsIgnoreCase("Does not contain data"))) {
	//			def text = "input[aria-label='Filter by value']"
	//			WebElement textO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text)))
	//				textO = webDriver.findElement(By.cssSelector(text))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			textO.sendKeys(filterValue)
	//
	//			def heading = "//h3[text()='Filter By']"
	//			WebElement headingO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(heading)))
	//				headingO = webDriver.findElement(By.xpath(heading))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			headingO.click()
	//		}
	//
	//		def filterButton = "button[type='submit']>span"
	//		WebElement filterButtonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(filterButton)))
	//			filterButtonO = webDriver.findElement(By.cssSelector(filterButton))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		filterButtonO.click()
	//	}
	//
	//	@Keyword
	//	def worklistFilterOptionsColumn(String columnName, String filterType, List<String> filterValues, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def filterChevron = "//div[text()='"+columnName+"']//parent::label//ancestor::div[@data-testid='columnHeader'][@aria-haspopup='menu']//i[@data-icon-name='ChevronDownSmall'][starts-with(@class, 'chevronIcon')]"
	//		WebElement filterChevronO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterChevron)))
	//			filterChevronO = webDriver.findElement(By.xpath(filterChevron))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		filterChevronO.click()
	//
	//		def button = "button[name='Filter by']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter by element for column "+ columnName)
	//			return
	//		}
	//		buttonO.click()
	//
	//		def select = "div[aria-label='Filter by operator'] span"
	//		WebElement selectO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(select)))
	//			selectO = webDriver.findElement(By.cssSelector(select))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//			return
	//		}
	//		String selectedFilterType = selectO.getText()
	//
	//		if (!selectedFilterType.equalsIgnoreCase(filterType)) {
	//
	//			selectO.click()
	//			def filterTypeOption = "//button//span[text()='"+filterType+"']"
	//			WebElement filterTypeOptionO
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterTypeOption)))
	//				filterTypeOptionO = webDriver.findElement(By.xpath(filterTypeOption))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter type "+filterType+" for column "+ columnName)
	//				return
	//			}
	//			filterTypeOptionO.click()
	//		}
	//
	//		if (!(filterType.equalsIgnoreCase("Contains data") || filterType.equalsIgnoreCase("Does not contain data") || filterType.equalsIgnoreCase("Equals") ||  filterType.equalsIgnoreCase("Does not equal"))) {
	//			def text = "input[aria-label='Filter by value']"
	//			WebElement textO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text)))
	//				textO = webDriver.findElement(By.cssSelector(text))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			textO.sendKeys(filterValues[0])
	//
	//			def heading = "//h3[text()='Filter By']"
	//			WebElement headingO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(heading)))
	//				headingO = webDriver.findElement(By.xpath(heading))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			headingO.click()
	//		}
	//		else if (filterType.equalsIgnoreCase("Equals") ||  filterType.equalsIgnoreCase("Does not equal")) {
	//			def option = "div[aria-label='Filter by value']>span"
	//			WebElement optionO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(option)))
	//				optionO = webDriver.findElement(By.cssSelector(option))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//				return
	//			}
	//			optionO.click()
	//
	//			for (String optItem: filterValues) {
	//				def optionItem = "//label[contains(@class, 'ms-Checkbox-label')]//span[text()='"+optItem+"']"
	//				WebElement optionItemO
	//
	//				try {
	//					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(optionItem)))
	//					optionItemO = webDriver.findElement(By.xpath(optionItem))
	//				}
	//				catch (NoSuchElementException e) {
	//					KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//					return
	//				}
	//				catch (TimeoutException e) {
	//					KeywordUtil.markFailed("Unable to find the filter drop down for column "+ columnName)
	//					return
	//				}
	//				optionItemO.click()
	//			}
	//
	//			def heading = "//h3[text()='Filter By']"
	//			WebElement headingO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(heading)))
	//				headingO = webDriver.findElement(By.xpath(heading))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Unable to come out of focus for filter text")
	//				return
	//			}
	//			headingO.click()
	//		}
	//
	//		def filterButton = "button[type='submit']>span"
	//		WebElement filterButtonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(filterButton)))
	//			filterButtonO = webDriver.findElement(By.cssSelector(filterButton))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find filter button")
	//			return
	//		}
	//		filterButtonO.click()
	//	}
	//
	//	@Keyword
	//	def workListSelectAllRecords(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def option = "//input[@aria-label='Toggle selection of all rows']/following-sibling::label//i"
	//		WebElement optionO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(option)))
	//			optionO = webDriver.findElement(By.xpath(option))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Select all records is not present on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Select all records is not present on the UI")
	//			return
	//		}
	//		optionO.click()
	//	}
	//
	//	@Keyword
	//	def workListSelectFirstRecord(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def option = "div[aria-label='Press SPACE to select this row.'][row-index='0'] input[aria-label='Select or deselect the row']"
	//		WebElement optionO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(option)))
	//			optionO = webDriver.findElement(By.cssSelector(option))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Select first record is not present on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Select first record is not present on the UI")
	//			return
	//		}
	//		optionO.click()
	//	}
	//
	//	@Keyword
	//	def workListSelectNthRecords(List<Integer> nthRecords, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		for (Integer i: nthRecords) {
	//			def option = "div[aria-label='Press SPACE to select this row.'][row-index='"+(i-1)+"'] input[aria-label='Select or deselect the row']"
	//			WebElement optionO
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(option)))
	//				optionO = webDriver.findElement(By.cssSelector(option))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Selecting "+i+" record failed")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Selecting "+i+" record failed")
	//				return
	//			}
	//			optionO.click()
	//		}
	//	}
	//
	//	@Keyword
	//	def Number workListGetTotalRecords(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def label = "//div[starts-with(@class,'pagingContainer')]/span"
	//		WebElement labelO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(label)))
	//			labelO = webDriver.findElement(By.xpath(label))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Total records in the worklist - not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Total records in the worklist - not found")
	//			return
	//		}
	//		def text = labelO.getText()
	//		def count = text.split('of ')
	//		return Long.parseLong(count[count.length-1].trim())
	//	}
	//
	//	@Keyword
	//	def Number workListGetRecordsOnPage(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def label = "//div[starts-with(@class,'pagingContainer')]/span"
	//		WebElement labelO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(label)))
	//			labelO = webDriver.findElement(By.xpath(label))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Total records in the worklist - not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Total records in the worklist - not found")
	//			return
	//		}
	//		def text = labelO.getText()
	//		return Long.parseLong(text.split('of ')[0].split(' - ')[1].trim())
	//	}
	//
	//	@Keyword
	//	def worklistAssignOwner(List<Integer> nthRecords, String owner, Number xTimeOutSeconds) {
	//
	//		workListSelectNthRecords(nthRecords, xTimeOutSeconds)
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "li>button[aria-label='Assign']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//
	//		if (owner.equalsIgnoreCase("me")) setValueSelectBox("Assign to", "Me", xTimeOutSeconds)
	//		else {
	//			setValueSelectBox("Assign to", "User or team", xTimeOutSeconds)
	//			setValueLookUpTextBox("User or team", owner, xTimeOutSeconds)
	//		}
	//
	//		button = "div>button[aria-label='Assign']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	//Details Top Bar
	//	@Keyword
	//	def clickSaveAndClose(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "button[aria-label='Save & Close']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Save and Close button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Save and Close button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def clickSave(Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "button[aria-label='Save (CTRL+S)']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Save button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Save button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//	@Keyword
	//	def assignOwner(String owner, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def button = "li>button[aria-label='Assign']"
	//		WebElement buttonO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//
	//		if (owner.equalsIgnoreCase("me")) setValueSelectBox("Assign to", "Me", xTimeOutSeconds)
	//		else {
	//			setValueSelectBox("Assign to", "User or team", xTimeOutSeconds)
	//			setValueLookUpTextBox("User or team", owner, xTimeOutSeconds)
	//		}
	//
	//		button = "div>button[aria-label='Assign']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(button)))
	//			buttonO = webDriver.findElement(By.cssSelector(button))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Assign button not available on the page")
	//			return
	//		}
	//		buttonO.click()
	//	}
	//
	//
	//	//Text box
	//	@Keyword
	//	def clickTextBox(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//			input = webDriver.findElement(By.xpath(inputX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		input.click()
	//	}
	//
	//	@Keyword
	//	def focusOutTextBox(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def labelX = "//label[text()='"+label+"']"
	//		WebElement labelO
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(labelX)))
	//			labelO = webDriver.findElement(By.xpath(labelX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		labelO.click()
	//	}
	//
	//	@Keyword
	//	def String getTextTextBox(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//			input = webDriver.findElement(By.xpath(inputX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		return input.getAttribute("value")
	//	}
	//
	//	@Keyword
	//	def setTextTextBox(String label, String textValue, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//			input = webDriver.findElement(By.xpath(inputX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		input.sendKeys(textValue)
	//	}
	//
	//	@Keyword
	//	def verifyTextBoxReadOnly(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//
	//		def iconX = "div[aria-label='Locked "+label+"']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Textbox "+label+" is not read only")
	//		}
	//		KeywordUtil.markPassed("Textbox "+label+" is read only")
	//	}
	//
	//	@Keyword
	//	def verifyTextBoxMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Textbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markPassed("Textbox "+label+" is mandatory")
	//	}
	//
	//	@Keyword
	//	def verifyTextBoxNotMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markPassed("Textbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markFailed("Textbox "+label+" is mandatory")
	//	}
	//
	//	@Keyword
	//	def clearTextBoxContent(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "input[aria-label='"+label+"']"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputX)))
	//			input = webDriver.findElement(By.cssSelector(inputX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		while(!input.getAttribute("value").equals("")) input.sendKeys(Keys.BACK_SPACE)
	//	}
	//
	//	@Keyword
	//	def verifyTextBoxErrorText(String label, String errorText, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//input[@aria-label='"+label+"']/parent::div/parent::div/following-sibling::div/span[contains(@id,'error-message')]"
	//		WebElement input
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//			input = webDriver.findElement(By.xpath(inputX))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found on the UI")
	//			return
	//		}
	//		String inputText = input.getText()
	//		if (inputText.equals(errorText)||inputText.trim().equals(errorText)) {
	//			KeywordUtil.markPassed("Textbox "+label+" error text matched")
	//		}
	//		else if (inputText.startsWith(errorText)) {
	//			KeywordUtil.markWarning("Textbox "+label+" error text starts with "+errorText)
	//		}
	//		else {
	//			KeywordUtil.markFailed("Textbox "+label+" error text mis match; Actual text:" + inputText)
	//		}
	//	}
	//
	//
	//	//Option Box
	//	@Keyword
	//	def setValueSelectBox(String label, String value, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def select = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//select | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//select"
	//		Select selectO
	//
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(select)))
	//			def we = webDriver.findElement(By.xpath(select))
	//			selectO = new Select(we)
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found - timeout")
	//			return
	//		}
	//		selectO.selectByVisibleText(value)
	//	}
	//
	//	@Keyword
	//	def String getSelectedSelectBox(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def select = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//select | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//select"
	//		Select selectO
	//
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(select)))
	//			def we = webDriver.findElement(By.xpath(select))
	//			selectO = new Select(we)
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found")
	//			return
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found - timeout")
	//			return
	//		}
	//		return selectO.getFirstSelectedOption().text
	//	}
	//
	//
	//	@Keyword
	//	def verifySelectBoxMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def select = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//select | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//select"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(select)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found")
	//			return
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("RichTextbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markPassed("RichTextbox "+label+" is mandatory")
	//	}
	//
	//
	//	//Rich Text Box
	//	@Keyword
	//	def setTextRichTextBox(String label, String text, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def oframeX = "div:has(span[title='"+label+"'])+div iframe,div:has( span[aria-label='"+label+"'])+div iframe"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(oframeX)))
	//		def tframeX = "iframe[title='"+label+" rich text editor'],iframe[aria-label='"+label+" rich text editor']"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(tframeX)))
	//		def rtBody = "//body"
	//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rtBody)))
	//		WebElement rtBodyElement = webDriver.findElement(By.xpath(rtBody))
	//		rtBodyElement.click()
	//		rtBodyElement.sendKeys(text)
	//		webDriver.switchTo().defaultContent()
	//	}
	//
	//	@Keyword
	//	def clearTextRichTextBox(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def oframeX = "div:has(span[title='"+label+"'])+div iframe,div:has( span[aria-label='"+label+"'])+div iframe"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(oframeX)))
	//		def tframeX = "iframe[title='"+label+" rich text editor'],iframe[aria-label='"+label+" rich text editor']"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(tframeX)))
	//		def rtBody = "//body"
	//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rtBody)))
	//		WebElement rtBodyElement = webDriver.findElement(By.xpath(rtBody))
	//		rtBodyElement.click()
	//		while(!rtBodyElement.getAttribute('textContent').equals("")) rtBodyElement.sendKeys(Keys.BACK_SPACE)
	//		webDriver.switchTo().defaultContent()
	//	}
	//
	//	@Keyword
	//	def verifyRichTextBoxMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def oframeX = "div:has(span[title='"+label+"'])+div iframe,div:has( span[aria-label='"+label+"'])+div iframe"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(oframeX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found")
	//			return
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("RichTextbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markPassed("RichTextbox "+label+" is mandatory")
	//	}
	//
	//
	//	@Keyword
	//	def String getTextRichTextBox(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def oframeX = "div:has(span[title='"+label+"'])+div iframe,div:has( span[aria-label='"+label+"'])+div iframe"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(oframeX)))
	//		def tframeX = "iframe[title='"+label+" rich text editor'],iframe[aria-label='"+label+" rich text editor']"
	//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(tframeX)))
	//		def rtBody = "//body"
	//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rtBody)))
	//		WebElement rtBodyElement = webDriver.findElement(By.xpath(rtBody))
	//		String text = rtBodyElement.getAttribute('textContent')
	//		webDriver.switchTo().defaultContent()
	//		return text
	//	}
	//
	//
	//	//Single Option Lookup
	//	@Keyword
	//	def setValueLookUpTextBox(String label, String value, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def dataid = label.replaceAll(" ", "").toLowerCase()
	//
	//		def lookupInput = "ul[title^='"+label+"'], input[aria-label^='"+label+"'], input[aria-label^='Look for "+label+"'], input[data-id^='"+dataid+"']"
	//		def lookupText = "ul[title^='"+label+"']>li>div, input[aria-label^='Look for "+label+"']>li>div, input[data-id^='"+dataid+"']>li>div"
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(lookupInput)))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		WebElement lookupTextO
	//		String currentText = null
	//
	//		try {
	//			lookupTextO = webDriver.findElement(By.cssSelector(lookupText))
	//			currentText = lookupTextO.getAttribute("value")
	//			if (currentText==null) currentText = lookupTextO.getText()
	//			if (currentText.equalsIgnoreCase(value)) return
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (Exception e) {
	//			KeywordUtil.markFailed("Exception : Unable to get current look up text")
	//		}
	//
	//		if (currentText==null || currentText.equals("---") || !currentText.equalsIgnoreCase(value)) {
	//
	//			if (!currentText.equals("---") && !currentText.equalsIgnoreCase(value)) {
	//
	//				Actions action = new Actions(webDriver)
	//				action.moveToElement(lookupTextO).build().perform()
	//
	//				def clear = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//ul/li/div/following-sibling::button"
	//				WebElement clearO
	//
	//				try {
	//					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clear)))
	//					clearO = webDriver.findElement(By.xpath(clear))
	//				}
	//				catch (NoSuchElementException e) {
	//					KeywordUtil.markFailed("Unable to clear "+ label)
	//					return
	//				}
	//				catch (TimeoutException e) {
	//					KeywordUtil.markFailed("Unable to clear "+ label)
	//					return
	//				}
	//				clearO.click()
	//			}
	//
	//
	//			def search = "button[aria-label='Search records for "+label+", Lookup field']"
	//			WebElement searchO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(search)))
	//				searchO = webDriver.findElement(By.cssSelector(search))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Lookup field search button not found")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Lookup field search button not found")
	//				return
	//			}
	//			searchO.click()
	//
	//
	//			def scrollContainer = "div[aria-label='Dropdown panel'] ul[aria-label='Lookup results']"
	//			WebElement scrollContainerO
	//
	//			try {
	//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(scrollContainer)))
	//				scrollContainerO = webDriver.findElement(By.cssSelector(scrollContainer))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Lookup field drop down not found")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Lookup field drop down not found")
	//				return
	//			}
	//
	//			def valueElement = "//ul[@aria-label='Lookup results']/li//div/span[text()='"+value+"']"
	//			WebElement valueElementO
	//
	//			wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//			def js = '''valueO=document.evaluate(arguments[0], document.body, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
	//						scrollO=document.querySelector(arguments[1]);
	//						scrollO.scrollTo({top: valueO.offsetTop, behavior: 'smooth'})'''
	//
	//			JavascriptExecutor jse = (JavascriptExecutor) webDriver
	//			try {
	//				jse.executeScript(js, valueElement, scrollContainer)
	//			}
	//			catch (Exception e) {
	//				KeywordUtil.markFailed("Unable to scroll to "+ value)
	//				return
	//			}
	//
	//			try {
	//				valueElementO = webDriver.findElement(By.xpath(valueElement))
	//			}
	//			catch (NoSuchElementException e) {
	//				KeywordUtil.markFailed("Lookup field drop down value not found")
	//				return
	//			}
	//			catch (TimeoutException e) {
	//				KeywordUtil.markFailed("Lookup field drop down value not found")
	//				return
	//			}
	//			valueElementO.click()
	//		}
	//	}
	//
	//	@Keyword
	//	def String getValueLookUpTextBox(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def dataid = label.replaceAll(" ", "").toLowerCase()
	//
	//		def lookupInput = "ul[title^='"+label+"'], input[aria-label^='"+label+"'], input[aria-label^='Look for "+label+"'], input[data-id^='"+dataid+"']"
	//		def lookupText = "ul[title^='"+label+"']>li>div, input[aria-label^='Look for "+label+"']>li>div, input[data-id^='"+dataid+"']>li>div"
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(lookupInput)))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		WebElement lookupTextO
	//		String currentText
	//
	//		try {
	//			lookupTextO = webDriver.findElement(By.cssSelector(lookupText))
	//			currentText = lookupTextO.getText()
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (Exception e) {
	//			KeywordUtil.markFailed("Exception : Unable to get current look up text")
	//		}
	//		return currentText
	//	}
	//
	//	@Keyword
	//	def verifyLookUpTextBoxMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Lookup Textbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markPassed("Lookup Textbox "+label+" is mandatory")
	//	}
	//
	//	@Keyword
	//	def verifyLookUpTextBoxNotMandatory(String label, Number xTimeOutSeconds) {
	//
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def lookupInput = "ul[title^='"+label+"']"
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(lookupInput)))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find look up "+ label)
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find look up "+ label)
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markPassed("Lookup Textbox "+label+" is not mandatory")
	//			return
	//		}
	//		KeywordUtil.markFailed("Lookup Textbox "+label+" is mandatory")
	//	}
	//
	//	//Date Box
	//	@Keyword
	//	def String getDateDateBox(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def date = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')]"
	//		WebElement dateO
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date)))
	//			dateO = webDriver.findElement(By.xpath(date))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		return dateO.getAttribute("value")
	//	}
	//
	//	@Keyword
	//	def String getDateDateBoxFormatted(String label, String format, Number xTimeOutSeconds) {
	//	}
	//
	//	@Keyword
	//	def setDateDateBox(String label, String ddmmyyyy, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def date = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')]"
	//		WebElement dateO
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date)))
	//			dateO = webDriver.findElement(By.xpath(date))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to get current look up text")
	//		}
	//		return dateO.sendKeys(ddmmyyyy)
	//	}
	//
	//	@Keyword
	//	def setDateDateBoxFormatted(String label, String ddmmyyyy, String format, Number xTimeOutSeconds) {
	//	}
	//
	//	@Keyword
	//	def verifyDateBoxMandatory(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Lookup Textbox "+label+" is not mandatory")
	//		}
	//		KeywordUtil.markPassed("Lookup Textbox "+label+" is mandatory")
	//	}
	//
	//	@Keyword
	//	def verifyDateBoxNotMandatory(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def date = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')]"
	//
	//		try {
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date)))
	//		}
	//		catch (NoSuchElementException e) {
	//			KeywordUtil.markFailed("Unable to find date box "+ label)
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Unable to find date box "+ label)
	//		}
	//
	//		def iconX = "//label[text()='"+label+"']/parent::span/following-sibling::div/div[text()='*'] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div/div[text()='*']"
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markPassed("Lookup Textbox "+label+" is not mandatory")
	//			return
	//		}
	//		KeywordUtil.markFailed("Lookup Textbox "+label+" is mandatory")
	//	}
	//
	//	@Keyword
	//	def verifyDateBoxReadOnly(String label, Number xTimeOutSeconds) {
	//		WebDriver webDriver = DriverFactory.getWebDriver()
	//		if (xTimeOutSeconds <= 0||xTimeOutSeconds == null) xTimeOutSeconds = 30
	//		WebDriverWait wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//
	//		def inputX = "//label[text()='"+label+"']/parent::span/parent::div/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')] | //label[text()='"+label+"']/parent::span/parent::div/following-sibling::div//input[starts-with(@id, 'DatePicker')]"
	//		WebElement input;
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Element with label "+label+" not found")
	//			return
	//		}
	//
	//		def iconX = "div[aria-label='Locked "+label+"']"
	//		wait = new WebDriverWait(webDriver, xTimeOutSeconds)
	//		try {
	//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(iconX)))
	//		}
	//		catch (TimeoutException e) {
	//			KeywordUtil.markFailed("Date box "+label+" is not read only")
	//		}
	//		KeywordUtil.markPassed("Date box "+label+" is read only")
	//	}
}