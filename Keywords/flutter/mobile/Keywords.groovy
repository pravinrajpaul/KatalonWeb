package flutter.mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.annotation.internal.Action
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.internal.SupportLevel
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.transform.CompileStatic
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.github.ashwith.flutter.FlutterElement
import io.github.ashwith.flutter.FlutterFinder

//@Action("setText")
public class Keywords {


	//	@CompileStatic
	//	@Override
	//	public SupportLevel getSupportLevel(Object ...params) {
	//		return super.getSupportLevel(params)
	//	}
	//
	//	@CompileStatic
	//	@Override
	//	public Object execute(Object ...params) {
	//		TestObject to = getTestObject(params[0])
	//		String text = (String) params[1]
	//		int timeout = (int) params[2]
	//		FailureHandling flowControl = (FailureHandling)(params.length > 3 && params[3] instanceof FailureHandling ? params[3] : RunConfiguration.getDefaultFailureHandling())
	//		setText(to,text,timeout,flowControl)
	//	}

	/**
	 * Keyword to get text
	 * @param mo
	 * @return
	 */
	@Keyword
	def String getText1(TestObject mo) {
		def locSt = ""
		try {
			locSt = ((MobileTestObject) mo).getMobileLocatorStrategy().locatorStrategy
			if (!locSt.equals("Custom")) throw new Exception("Mobile Object : Locator Strategy not 'CUSTOM'")
		}
		catch (Exception e) {
			KeywordUtil.markErrorAndStop("Test object is not a mobile locator or Test Object doesn't have a Custom Locator Strategy 'flutterKey'")
		}

		def flKey = ((MobileTestObject) mo).getMobileLocator()
		try {
			if (!flKey.startsWith("flutterKey:")) throw new Exception("Mobile Object : Locator does not start with 'flutterKey:'")
		}
		catch (Exception e) {
			KeywordUtil.markErrorAndStop("Mobile Object Locator does not start with 'flutterKey:'")
		}
		def fKey = ""
		try {
			fKey = flKey.split("flutterKey:")[1].trim()
			if (fKey == null || fKey.equals("")) throw new Exception()
		}
		catch (Exception e) {
			KeywordUtil.markErrorAndStop("Probably there is no flutterKey specified or its null : " + e.getMessage())
		}

		AppiumDriver ad = MobileDriverFactory.getDriver()
		FlutterFinder finder = new FlutterFinder(ad)
		FlutterElement element = finder.byValueKey(fKey)



		return element.getText()
	}
}
