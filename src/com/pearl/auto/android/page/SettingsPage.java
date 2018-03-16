package com.pearl.auto.android.page;

import static com.pearl.auto.android.utils.Helpers.find;
import static com.pearl.auto.android.utils.Helpers.findByText;
import static com.pearl.auto.android.utils.Helpers.findElements;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class SettingsPage {
	
	public void clickMenu(String menuName) {
		findByText(menuName).click();
	}

	public void selectWallpaper(int i) {
		List<MobileElement> wallpapers = findElements(By.xpath("//*[@resource-id='com.google.android.googlequicksearchbox:id/wallpaper_image']"));
		
		wallpapers.get(i).click();
	}
	
	public String getAboutValue(String title) {
		// System.out.println(find(By.xpath("//*[@text=\'" + title + "\']/following-sibling::android.widget.TextView")).getText());
		
		return find(By.xpath("//*[@text=\'" + title + "\']/following-sibling::android.widget.TextView")).getText();
	}
}
