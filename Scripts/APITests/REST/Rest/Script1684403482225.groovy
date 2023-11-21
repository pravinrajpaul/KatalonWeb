import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

//id = CustomKeywords.'mykeywords.CustomKeywords.randomNumber'(6)
time = LocalDateTime.now()

response = WS.sendRequest(findTestObject('API/Rest/CreaterUser', [('name') : name, ('id') : id, ('time') : time]))


outname = WS.getElementPropertyValue(this.response, 'name')

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

ResponseObject response1 = WS.sendRequestAndVerify(listUser)

//jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())
//field = jsonResponse.name

println(response1.getResponseBodyContent())