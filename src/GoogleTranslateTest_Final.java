import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GoogleTranslateTest_Final {

	/** NON POM
	 * @author kenasanion
	 * Say hello to your first scripting exercise.
	 * I scrambled the structure of the code but it should work the same.
	 * Tried and tested this so there should be no problem!
	 * Feel free to do whatever you want as long as it's working.
	 */
	public static void main(String[] args) throws Exception {
		
		// Locate your apk file here
		// Add your apk file here
		String projectRootPath = System.getProperty("user.dir");
		
		String appPath = "/app/Google Translate.apk";
		File file = new File(projectRootPath + appPath);
		
		if (file != null) {
			// Initialize and set our desire capabilities here
			DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
			dc.setCapability("appActivity", "com.google.android.apps.translate.TranslateActivity");
			dc.setCapability("appWaitActivity", "com.google.android.apps.translate.OnboardingActivity");
			// End of initialization
			
			// By default, Adding /wd prefix would cause our webdriver to run with other processes running in this domain
			URL remoteURL = new URL("http://0.0.0.0:4723/wd/hub");
			
			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(remoteURL, dc);

		    driver.findElementByXPath("/hierarchy/android.widget.FrameLayout");
		    driver.findElementById("com.google.android.apps.translate:id/button_done").click();
		    
		    WebDriverWait driverWait = new WebDriverWait(driver, 60);
		    driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.translate:id/design_navigation_view")));
			
			driver.navigate().back();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.findElementById("com.google.android.apps.translate:id/touch_to_type_text").click();
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.findElementById("com.google.android.apps.translate:id/edit_input").sendKeys("Hello");

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.findElementByAccessibilityId("Show details").click();
			

			String withoutParent = driver.findElement(By.xpath("//*[@resource-id='android:id/text1']")).getAttribute("text");
			
			String withParent = driver.findElement(By.id("com.google.android.apps.translate:id/result_container"))
				  .findElement(By.xpath("//*[@resource-id='android:id/text1']")).getAttribute("text");
			
			Assertions.assertEquals("Hola", withParent);
			
			driver.quit();
		}
 	}
}
