package mykeywords
import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.Capabilities
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Proxy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.Proxy.ProxyType
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.SmartWaitWebDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




class CustomKeywords {

	Process proc = null;


	@Keyword
	def void openChromeBrowserCustomDriver(String driverPath) {
		WebUI.openBrowser("")
		SmartWaitWebDriver smartWaitDriver = (SmartWaitWebDriver) DriverFactory.getWebDriver()
		if (smartWaitDriver instanceof WebDriver) {
			Capabilities existingCapabilities = smartWaitDriver.getCapabilities()
			WebUI.closeBrowser()
			smartWaitDriver.quit()
			ChromeOptions chromeOptions = new ChromeOptions()
			existingCapabilities.asMap().each { key, value ->
				if (key.equalsIgnoreCase("proxy") && value!=null && (((Proxy)value).getProxyType().equals(ProxyType.UNSPECIFIED))) {}
				else if (key.equalsIgnoreCase("setWindowRect")) chromeOptions.setCapability("windowRect", value)
				else chromeOptions.setCapability(key, value)
			}
			System.setProperty("webdriver.chrome.driver", driverPath)
			def driver = new ChromeDriver(chromeOptions)
			DriverFactory.changeWebDriver(driver)
		}
	}

	@Keyword
	def void openChromeBrowserCustomCapabilities(String url, List<String> args, Map<String, Object> options, Map<String, Object> capabilities) {
		WebUI.openBrowser("")
		def currentDriver = DriverFactory.getWebDriver()
		if (currentDriver instanceof WebDriver) {
			def chromeDriver = (SmartWaitWebDriver) currentDriver
			Capabilities existingCapabilities = chromeDriver.getCapabilities()
			ChromeOptions chromeOptions = new ChromeOptions()
			existingCapabilities.asMap().each { key, value ->
				if (key.equalsIgnoreCase("proxy") && value!=null && (((Proxy)value).getProxyType().equals(ProxyType.UNSPECIFIED))) {}
				else if (key.equalsIgnoreCase("setWindowRect")) chromeOptions.setCapability("windowRect", value)
				else chromeOptions.setCapability(key, value)
			}
			capabilities.each { key, value ->
				chromeOptions.setCapability(key, value)
			}
			chromeOptions.addArguments(args)
			if (options != null && !options.isEmpty())	chromeOptions.setExperimentalOption("prefs", options)
			WebUI.closeBrowser()
			chromeDriver.quit()
			DriverFactory.changeWebDriver(new ChromeDriver(chromeOptions))
		}
		WebUI.navigateToUrl(url)
	}


	@Keyword
	def setScriptTimeouts(long timeoutMinutes) {
		WebDriver driver = DriverFactory.getWebDriver()
		driver.manage().timeouts().setScriptTimeout(timeoutMinutes, TimeUnit.MINUTES)
	}

	@Keyword
	def automateExistingOpenWindow() {

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe")

		ChromeOptions options = new ChromeOptions()
		options.addArguments("remote-debugging-port=9222")
		options.setExperimentalOption("debuggerAddress", "localhost:9222")


		WebDriver driver = new ChromeDriver(options)
		DriverFactory.changeWebDriver(driver)
	}

	@Keyword
	def List<String> selectBoxGetOptionLabels(TestObject to, int timeout) {
		try {
			WebDriver wd = DriverFactory.getWebDriver()
			Select sel = new Select(WebUiCommonHelper.findWebElement(to, timeout))
			List<WebElement> options = sel.getOptions()
			List<String> labels = new ArrayList<>()
			for(WebElement option : options) labels.add(option.getText())
			return labels
		}
		catch(Exception e) {
			KeywordUtil.markFailed("Unable to get labels from the Select box")
		}
	}

	@Keyword
	def List<String> selectBoxGetOptionValues(TestObject to, int timeout) {
		try {
			WebDriver wd = DriverFactory.getWebDriver()
			Select sel = new Select(WebUiCommonHelper.findWebElement(to, timeout))
			List<WebElement> options = sel.getOptions()
			List<String> labels = new ArrayList<>()
			for(WebElement option : options) labels.add(option.getAttribute("value"))
			return labels
		}
		catch(Exception e) {
			KeywordUtil.markFailed("Unable to get values from the Select box")
		}
	}

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

	@Keyword
	def void setTextJavaScript(TestObject tobj, String text) {
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
		js.executeScript("arguments[0].value=arguments[1]", we, text);
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
