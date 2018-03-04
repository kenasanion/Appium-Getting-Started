

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SampleTest {
	
	
	
	public static void main(String[] args) throws Exception {
		
		// Initializes desired capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		
		// Set our desired capabilities with the minimum required properties
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME , "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		
		// Locate our apk file
		String projectRootPath = System.getProperty("user.dir");
		File file = new File(projectRootPath + "/app/ContactManager.apk");
		
		if (file != null) {
			dc.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
			
			// By default, Adding /wd prefix would cause our webdriver to run with other processes running in this domain
			URL remoteURL = new URL("http://0.0.0.0:4723/wd/hub");
			
			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(remoteURL, dc);
			
			// Do some simple actions
			driver.findElementByAccessibilityId("Add Contact").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Home\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Mobile\")").click();
			
			// Navigate back to home. We assume that there are two fragments to go to home.
			// This action is somehow hardcoded.
			driver.navigate().back();
			driver.navigate().back();
			
			MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Add Contact");
			el1.click();
		} else {
			System.err.println("Error: No file found!");
		}
	}
}
