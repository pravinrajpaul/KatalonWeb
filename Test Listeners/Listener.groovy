import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Paths
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

import org.testng.ITestContext
import org.testng.ITestNGMethod
import org.testng.annotations.BeforeMethod

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Listener {

		@BeforeTestSuite
		def beforeTestSuite(TestSuiteContext testSuiteContext) {
			System.setProperty("webdriver.chrome.driver", "D:\\PortableSoft\\chromedriver.exe")
		}
	
	
//	private static final Logger logger = Logger.getLogger("Listner.class")
//	private static FileHandler fh
//	
//	{
//		logFolder("D:\\KatalonLogs")
//	}
//	
//	/**
//	 * Executes before every test case starts.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@BeforeTestCase
//	def beforeTestCase(TestCaseContext testCaseContext) {
//		println testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseVariables()
//		if (!GlobalVariable.ExecutingSuite.equals(GlobalVariable.Suite)) {
//			GlobalVariable.Suite = GlobalVariable.ExecutingSuite
//			GlobalVariable.CriticalError=0
//		}
//		if (GlobalVariable.CriticalError>0) {
//			testCaseContext.skipThisTestCase()
//			logger.log(Level.INFO, "Hello")
//		}
//	}
//
//	/**
//	 * Executes after every test case ends.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@AfterTestCase
//	def afterTestCase(TestCaseContext testCaseContext) {
//		println testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseStatus()
//		if (testCaseContext.getTestCaseStatus().equals("FAILED")) GlobalVariable.CriticalError=1
//	}
//
//	/**
//	 * Executes before every test suite starts.
//	 * @param testSuiteContext: related information of the executed test suite.
//	 */
//	@BeforeTestSuite
//	def beforeTestSuite(TestSuiteContext testSuiteContext) {
//		println testSuiteContext.getTestSuiteId()
//		GlobalVariable.ExecutingSuite = testSuiteContext.getTestSuiteId()
//		String configFile = "settings/internal/com.kms.katalon.execution.properties"
//		def config = new Properties()
//		config.load(new FileInputStream(configFile))
//		def sendTestSuiteReport = config.getProperty("mailConfig.sendTestSuiteReport")
//		println "Sending email : " + sendTestSuiteReport
//	}
//
//	/**
//	 * Executes after every test suite ends.
//	 * @param testSuiteContext: related information of the executed test suite.
//	 */
//	@AfterTestSuite
//	def afterTestSuite(TestSuiteContext testSuiteContext) {
//		println testSuiteContext.getTestSuiteId()
//		GlobalVariable.Suite = testSuiteContext.getTestSuiteId()
//	}
//
//	def logFolder(String logFolderPath) {
//		try {
//			Files.createDirectories(Paths.get(logFolderPath))
//			logFolderPath += (logFolderPath.endsWith("\\"))?"":"\\"
//			fh = new FileHandler(logFolderPath+"log.log");
//			logger.addHandler(fh);
//			SimpleFormatter formatter = new SimpleFormatter();
//			fh.setFormatter(formatter);
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
}