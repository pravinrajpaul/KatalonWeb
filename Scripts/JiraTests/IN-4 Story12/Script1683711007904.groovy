import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/area'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_RP-LI-02'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_Sign In_img_cart'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/table_Item IDProduct IDDescriptionIn StockQ_e472a4'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_JPetStore Demo/td_Green Adult   Iguana'), 'Green Adult Iguana')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Return to Main Menu'))

WebUI.closeBrowser()

