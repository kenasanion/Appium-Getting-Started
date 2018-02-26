import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GoogleTranslateTest {

	/**
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
		
		String appPath = "/app/ContactManager.apk";
		File file = new File(projectRootPath + appPath);
		
		if (file != null) {
			// Initialize and set our desire capabilities here
			DesiredCapabilities dc = new DesiredCapabilities();

			// Do not remove. Will explain in the next session
			dc.setCapability("appActivity", "com.google.android.apps.translate.TranslateActivity");
			dc.setCapability("appWaitActivity", "com.google.android.apps.translate.OnboardingActivity");
			// End of initialization
			
			// By default, Adding /wd prefix would cause our webdriver to run with other processes running in this domain
			URL remoteURL = new URL("http://0.0.0.0:4723/wd/hub");
			
			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(remoteURL, dc);

			// Here's a bonus, just supply it with ids and xpath
			// This will handle the setup dialog box.
			
		    // driver.findElementByXPath("");
		    // driver.findElementById("").click();
			
			// Do steps 2 onwards below...
			
			// Uncomment this line after completing your automation
			// driver.quit();
		}
 	}
}
