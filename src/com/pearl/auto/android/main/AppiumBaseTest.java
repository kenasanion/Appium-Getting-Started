package com.pearl.auto.android.main;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static com.pearl.auto.android.utils.Helpers.driver;
import static com.pearl.auto.android.utils.Helpers.driverWait;
 
/**
 * @author kenasanion
 * This code is based on src/test/java/appium/tutorial/android/util/AppiumTest.java
 * which are part of https://github.com/appium/tutorial/blob/master/projects.
 * SauceLabs dependencies were removed from this base class.
 */

public abstract class AppiumBaseTest<T> implements IBaseTest {
	
    protected T page;
    protected String userDir;
    protected String localApp;
    
    protected DesiredCapabilities capabilities;
    
    /** Run before each test **/
    @Before
    public void setUp() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME , "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        
        init();

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        
        if (userDir != null && localApp != null) {
        		String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        		capabilities.setCapability(MobileCapabilityType.APP, appPath);
         
            driver = new AndroidDriver<MobileElement>(serverAddress, capabilities);
            driverWait = new WebDriverWait(driver, 60);
        } else {
        	
        		// Assume all capabilities are properly set.
        		driver = new AndroidDriver<MobileElement>(serverAddress, capabilities);
            driverWait = new WebDriverWait(driver, 60);
        }
    }
 
    /** Run after each test **/
    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }
}