import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import org.openqa.selenium.Capabilities
import com.kms.katalon.core.appium.driver.AppiumDriverManager as AppiumDriverManager
import com.kms.katalon.core.mobile.driver.MobileDriverType as MobileDriverType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.configuration.RunConfiguration

String kobitonServerUrl = 'https://appium-hub.mozark.ai/3201160a4d0e6605'
DesiredCapabilities capabilities = new DesiredCapabilities()
capabilities.setCapability('sessionName', 'Automation test session')
capabilities.setCapability('device', 'Samsung M20')
capabilities.setCapability('os_version', '9.0')
capabilities.setCapability('project', 'Cogmento Project')
capabilities.setCapability('build', 'Java Android')
capabilities.setCapability('name', 'first_test')
capabilities.setCapability('sessionDescription', '')
capabilities.setCapability('appPackage', 'com.icicibank.sesone')
capabilities.setCapability('appActivity', 'com.icicibank.sesone.MainActivity')
capabilities.setCapability('automationName', 'UiAutomator2')
capabilities.setCapability('noReset', true)
capabilities.setCapability('platformName', 'Android')
AppiumDriver<?> driver = AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, capabilities, new URL(kobitonServerUrl))
//AppiumDriver<?> driver = MobileDriverFactory.getDriver()
Capabilities cap = driver.getCapabilities()
Set<String> set = driver.getCapabilities().capabilityNames
for (String s: set) {
	println(s + " : " + cap.getCapability(s))
}
//RunConfiguration.setMobileDriverPreferencesProperty('remoteServerUrl', kobitonServerUrl)
//RunConfiguration.setMobileDriverPreferencesProperty('desiredCapabilities', capabilities)
//Mobile.startApplication('com.csam.icici.bank.imobileuat',false)
//Mobile.startExistingApplication('com.android.chrome')
Thread.sleep(2000)
Mobile.takeScreenshot('C:\\Users\\pravi\\Katalon Studio\\OctoperfInt\\1.png')
Mobile.closeNotifications()
Mobile.takeScreenshot('C:\\Users\\pravi\\Katalon Studio\\OctoperfInt\\2.png')
Mobile.checkElement('Object Repository/MaybankTrade/Page_Maybank IB Trading Portal/button_Ok', 2)
Mobile.closeApplication()