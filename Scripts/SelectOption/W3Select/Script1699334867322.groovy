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

WebUI.disableSmartWait()

WebUI.openBrowser('https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple')

WebUI.maximizeWindow()

WebUI.executeJavaScript('document.body.style.zoom="50%"', [])

WebUI.selectOptionByLabel(findTestObject('MultipleSelect/Page_W3Schools Tryit Editor/select_Volvo    Saab    Opel    Audi'), 
    'Opel', false)

WebUI.switchToFrame(findTestObject('MultipleSelect/Page_W3Schools Tryit Editor/iframe__iframeResult'), 0)

labels = CustomKeywords.'mykeywords.CustomKeywords.selectBoxGetOptionLabels'(findTestObject('MultipleSelect/Page_W3Schools Tryit Editor/select_Volvo    Saab    Opel    Audi'), 
    0)

values = CustomKeywords.'mykeywords.CustomKeywords.selectBoxGetOptionValues'(findTestObject('MultipleSelect/Page_W3Schools Tryit Editor/select_Volvo    Saab    Opel    Audi'), 
    0)

for (String label : labels) {
    println(label)
}

for (String value : values) {
    println(value)
}

WebUI.delay(5)

WebUI.closeBrowser()

