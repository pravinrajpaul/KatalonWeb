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
import javax.mail.internet.MimeMultipart as MimeMultipart

Map email = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getLatestGmail'(GlobalVariable.gmail, GlobalVariable.gmailPass, 
    GlobalVariable.gmailFolder)

println(email.subject)

println(email.body)

email = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getNthGmail'(GlobalVariable.gmail, GlobalVariable.gmailPass, 
    GlobalVariable.gmailFolder, 3)

println(email.subject)

println(email.body)

int count = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getMailCountGmail'(GlobalVariable.gmail, 
    GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

println(count)

CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.deleteLatestGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

count = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getMailCountGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

println(count)

CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.deleteNthGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder, 2)

email = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getNthGmail'(GlobalVariable.gmail, GlobalVariable.gmailPass,
	GlobalVariable.gmailFolder, 2)

println(email.subject)

println(email.body)

count = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getMailCountGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

println(count)

CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.deleteAllGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

count = CustomKeywords.'com.katalon.plugin.keyword.email.EmailAccessKeywords.getMailCountGmail'(GlobalVariable.gmail,
	GlobalVariable.gmailPass, GlobalVariable.gmailFolder)

println(count)