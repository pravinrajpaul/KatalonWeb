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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://t30707-s51297.stg1.mozu.com/')

WebUI.click(findTestObject('Object Repository/Proactive/Page_For All Skin Types  Acne  Skincare Tre_32c762/a_get started'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/small_Hydrating'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/small_Hydrating'), 
    'Hydrating')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Hydrating_check svelte-1v1prx2'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/p_next'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_For best results_check svelte-1e5f376'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Great for teens_svelte-18nliqd multi-check'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Great for teens_svelte-18nliqd multi-check_1'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Improves skin tone_svelte-18nliqd multi-check'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Improves skin tone_svelte-18nliqd multi-check_1'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_More details_check svelte-17ky98e'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Your subscription Renews every 90 days _0667a0'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/span_24.95'), 
    '$24.95')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/span_10.00'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/span_10.00'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/span_10.00'), 
    '+$10.00')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Your subscription Renews every 90 days _0667a0_1'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/p_46.75 0.00'), 
    '$46.75 $0.00')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Your subscription Renews every 90 days _0667a0'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/p_Free'), 
    'Free')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_Your subscription Renews every 90 days _0667a0'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/p_34.95'), 
    '$34.95')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Buy the Proactiv that is Right for you/div_46.75_w20 text-right align-self-middle _29eaaa'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/div_Preparing your items for checkout, please wait'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Preparing your items for checkout, please wait'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Preparing your items for checkout, please wait'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Preparing your items for checkout, please wait'))

WebUI.verifyElementNotVisible(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Preparing your items for checkout, please wait'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_90'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_90'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_90'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Proactiv Mark and Scar Duo  - 90 Day'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/strong_Proactiv Mark and Scar Duo  - 90 Day'), 
    'Proactiv+® Mark and Scar Duo - 90 Day')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_90'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_90'), 
    '90')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Quantity 1'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Quantity 1'), 
    'Quantity: 1')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Unit price                               _3f1bcd'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Unit price                               _3f1bcd'), 
    'Unit price:\n $34.95')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Pore Cleansing Brush'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Pore Cleansing Brush'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/strong_Pore Cleansing Brush'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/strong_Pore Cleansing Brush'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Pore Cleansing Brush'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/strong_Pore Cleansing Brush'), 
    'Pore Cleansing Brush')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Unit price                               _031899'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Unit price                               _031899'), 
    'Unit price:\n $46.75 $0.00')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_All orders are backed by our 60-day money_ea3a6e'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_All orders are backed by our 60-day money_ea3a6e'), 
    'All orders are backed by our 60-day money back guarantee.')

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Credit card_email'), 
    'testnewtooldemo1@yopmail.com')

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Email_phone'), 
    '3106337951')

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Phone_billingFirstName'), 
    '')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Phone_billingFirstName'))

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Phone_billingFirstName'), 
    'test')

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_First name_billingLastName'), 
    'test')

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Last name_billingAddress1'), 
    '120 Broadway')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Apartment, suite, unit (optional)_bil_b6bd4c'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/div_Continue with   Continue with  Continue_5f4926'))

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Apartment, suite, unit (optional)_bil_b6bd4c'), 
    'Santa Monica')

WebUI.selectOptionByValue(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/select_State                               _46cb8f'), 
    'CA', true)

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_City_billingZipCode'))

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_City_billingZipCode'), 
    '90401')

WebUI.verifyElementPresent(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_Zip code_check-mark svelte-1l2t73t'), 
    0)

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Zip code_card'))

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Zip code_card'), 
    '4111 1111 1111 1111')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_Expiration date (MMYY)'))

WebUI.setText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input_Card number_cardExpiration'), 
    '12/23')

WebUI.setEncryptedText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input__cardCvv'), 
    'tzH6RvlfSTg=')

WebUI.setEncryptedText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/input__password'), 
    'iyczyVKWjcnuD8uZDbKhEg==')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_Zip code_check-mark svelte-1l2t73t'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/div_Buy Now'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/div_Please wait while we complete your requ_7f1816'))

WebUI.verifyElementNotVisible(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Do not refresh this page or use the back button'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Your order is being processed, you will r_413a2d'))

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_Your order is being processed, you will r_413a2d'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_testnewtooldemo1yopmail.com'), 
    'testnewtooldemo1@yopmail.com')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_2267164'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/span_2267164'), 
    '2267164')

WebUI.click(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/div_Subtotal 34.95'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_34.95'))

WebUI.rightClick(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_34.95'))

WebUI.verifyElementText(findTestObject('Object Repository/Proactive/Page_Proactiv Products  Order Proactiv Onli_9d9d36/p_34.95'), 
    '$34.95')

WebUI.closeBrowser()

