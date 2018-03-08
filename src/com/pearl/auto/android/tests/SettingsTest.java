package com.pearl.auto.android.tests;

import org.junit.Test;
import static com.pearl.auto.android.utils.Helpers.goToHome;

import com.pearl.auto.android.main.AppiumBaseTest;
import com.pearl.auto.android.page.SettingsPage;

public class SettingsTest extends AppiumBaseTest<SettingsPage> {

	@Override
	public void init() {
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");
		
		page = new SettingsPage();
	}

	@Test
	public void ScrollTest() throws Exception {
    		page.scrollMenu();
	}
	
	@Test
	public void ChangeWallpaperTest() throws Exception {
    		page.clickMenu("Display");
    		page.clickMenu("Wallpaper");
    		page.clickMenu("Wallpapers");
    		
    		page.selectWallpaper(2);
    		
    		page.clickMenu("Set Wallpaper");
    		
    		goToHome();
	}
}
