package com.pearl.auto.android.tests;

import static com.pearl.auto.android.utils.Helpers.goToHome;
import static com.pearl.auto.android.utils.Helpers.scroll;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.pearl.auto.android.main.AppiumBaseTest;
import com.pearl.auto.android.page.SettingsPage;
import com.pearl.auto.enums.ScrollDirection;

public class SettingsTest extends AppiumBaseTest<SettingsPage> {

	@Override
	public void init() {
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");
		
		page = new SettingsPage();
	}

	@Test
	public void ScrollTest() throws Exception {
    		scroll(0, 0, 0, 10);
    		scroll(0, 0, 0, 10);
    		
    		page.clickMenu("About phone");
    		String buildNumber = page.getAboutValue("Model number");
    		
    		System.out.println(buildNumber);
    		//Assertions.assertEquals("4.4.2", androidVersion);
	}
	
	public void ChangeWallpaperTest() throws Exception {
    		page.clickMenu("Display");
    		page.clickMenu("Wallpaper");
    		page.clickMenu("Wallpapers");
    		
    		page.selectWallpaper(2);
    		
    		page.clickMenu("Set wallpaper");
    		
    		goToHome();
	}
}
