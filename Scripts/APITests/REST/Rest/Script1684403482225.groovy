import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDateTime as LocalDateTime
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//id = CustomKeywords.'mykeywords.CustomKeywords.randomNumber'(6)
time = LocalDateTime.now()

response = WS.sendRequest(findTestObject('API/Rest/CreaterUser', [('name') : name, ('id') : id, ('time') : time]))

outname = WS.getElementPropertyValue(this.response, 'name')

jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())

id = jsonResponse.id

//assert name == outname
//
//outname = '123'
//
//error = 0
//
//if (!name.equals(outname)) {
//	error += 1
//	KeywordUtil.markWarning("Mismatch")
//}
//RequestObject request = findTestObject('API/Rest/ListUsers')
//List<TestObjectProperty> topl = request.getRestParameters().
//println(topl.size())
//for (TestObjectProperty top : topl) {
//	println(top.getName() +":"+ top.getValue())
//}
//def response = WS.sendRequest(request)
RequestObject listUser = findTestObject('API/Rest/ListUsers', [('id') : id])

listUser.setConnectionTimeout(30000)

ResponseObject response1 = WS.sendRequest(listUser)

//jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())
//field = jsonResponse.name
println(response1.getResponseBodyContent())

