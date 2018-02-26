import java.io.File;
import java.net.URL;

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
			
			// End of initialization
			
			// By default, Adding /wd prefix would cause our webdriver to run with other processes running in this domain
			URL remoteURL = new URL("http://0.0.0.0:4723/wd/hub");
			
			// AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(remoteURL, dc);
			
			// Add automation code below...
		}
 	}
}
