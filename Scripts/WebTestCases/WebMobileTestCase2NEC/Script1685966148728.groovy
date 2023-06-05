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

WebUI.navigateToUrl('https://www.univergeblue.com/')

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/span'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Products'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_Customer experience'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Video. Phone. Messaging. Together Connected/a_EXTENDAPI platform integrating UC  contac_9a8313'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/div_ProductsBackBUSINESS COMMUNICATIONSBack_0cc7a9'), 
    'ProductsBackBUSINESS COMMUNICATIONSBackCONNECTFully integrated all-in-one cloud-based UCMEETVirtual meetings & conferencingSHAREFile sync, share & protectionENGAGEMulti-channel cloud-based contact centerROOMSVideo conference room solutionPHONEBusiness Phone SystemCONNECT BRIDGEExtend on-premises PBX with cloud servicesARCHIVEPreserve, search & retrieve CONNECT communicationsCONNECT + MS TeamsEnterprise-grade cloud PBX integrationSIP TRUNKINGVoIP & streaming media cloud servicesMEET WEBINARLarge-scale virtual webinars wherever business take placeEXTENDAPI platform integrating UC & contact center into everyday business appsCustomer experienceBackENGAGEMulti-channel cloud-based contact center communications & oversightEXTENDAPI platform integrating UC & contact center into everyday business appsWorkspace ManagementBackSMART ACCESSAutomated reservation & touchless check-in solutionsSPACE ManagementOffice occupancy monitoring with mask and occupancy levels detectionMONITORReal-time, cloud-based video monitoring & analyticsINTEGRATION PLATFORMDesign, manage and streamline workflowsSolutionsBackBusiness EssentialsBackHybrid WorkingAll-in-one cloud communications for hybrid & remote productivityVideo ConferencingLarge-scale cloud-based virtual webinars and eventsDynamic DeliveryCloud migration solutions scaled to specific requirementsCustomer ExperienceMulti-channel cloud contact center solutionsMS Teams IntegrationCommunications platform with Microsoft Teams integrationIndustry SolutionsBackEducationConnected & secure learning environments all from within the cloudHealthcareReliable & secure cloud communications & infrastructure servicesGovernmentAdaptive government communications and infrastructure systemsRetailCloud solutions that elevate customer experiencesSmall & Midsize BusinessesCloud communications, data backup and recovery servicesEnterprisesIntegrated cloud communications, collaboration & infrastructure servicesInsightsBackSupportBackPartnersBackBecome a PartnerBackThe Power of ChoiceAs an NEC partner you have the ability to sell cloud, on-premises or a hybrid8 Great reasons to partner with NECYour success is our priority!Success StoriesRead about the successes NEC Channel Partners have had selling UNIVERGE BLUEJoin our partner programBecome a UNIVERGE BLUE Channel PartnerCLOUD CASH CHANNEL PARTNER PROGRAMSell cloud! Get paid like hardware – UPFRONT!Partner ResourcesBackNEC AnytimeOur channel partner portal for program materials, sales tools & informationUNIVERGE BLUE KnowledgebaseA searchable database of detailed information on all UNIVERGE BLUE communications servicesCHANNEL PARTNER SUCCESS KITResources to help partners market & sell UNIVERGE BLUE cloud servicesGet in TouchBackSearch US')

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/a_Accept'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/span_1_2'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE EXTEND/a_Helpdesk'))

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_Zendesk/a_Admin Guide for Zendesk'))

WebUI.switchToWindowTitle('UNIVERGE BLUE® CONNECT Integration for Zendesk (Admin Guide)')

WebUI.click(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/button_Yes'))

WebUI.verifyElementText(findTestObject('Object Repository/NEC Mobile/Page_UNIVERGE BLUE CONNECT Integration for _8e4ce0/div_Thanks for your feedback'), 
    'Thanks for your feedback.')

WebUI.closeBrowser()

