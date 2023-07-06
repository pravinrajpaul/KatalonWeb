package mykeywords
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

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver.TargetLocator
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.TestObjectXpath
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.TestObjectXpath
class CustomKeywords {

	def proc = null;

	@Keyword
	def List<String> addToList(String tobeadded, List<String> list) {
		list.add(tobeadded)
		return list;
	}

	@Keyword
	def Long randomNumber(int digits) {
		return Math.random() * (10)**digits;
	}

	@Keyword
	def void clickJavaScript(TestObject tobj) {
		WebDriver wd = DriverFactory.getWebDriver()
		WebUiCommonHelper.switchToParentFrame(tobj)
		String method = tobj.getSelectorMethod()
		String selector = tobj.getSelectorCollection().get(tobj.getSelectorMethod()) //.getXpaths()
		println(selector)
		WebElement we = null
		switch (method) {
			case 'CSS':
				we = wd.findElement(By.cssSelector(selector))
				break
			case 'XPATH':
				we = wd.findElement(By.xpath(selector))
				break
		}
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click()", we);
		wd.switchTo().defaultContent()
	}


	/**
	 * Win app driver set installation path
	 *
	 */
	@Keyword
	def startWinAppDriver(String path) {
	}


	/**
	 * Win app driver default installation
	 *
	 */
	@Keyword
	def startDefaultWinAppDriver() {
		def thread = Thread.start {
			proc = "cmd /k \"C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver\"".execute();
			proc.waitForProcessOutput(System.out, System.err);
		}
	}

	/**
	 * Win app driver default installation
	 *
	 */
	@Keyword
	def exitWinAppDriver() {
		proc.destroy()
	}
}