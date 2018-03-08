package com.pearl.auto.android.page;

import static com.pearl.auto.android.utils.Helpers.find;
import static com.pearl.auto.android.utils.Helpers.findElements;
import static com.pearl.auto.android.utils.Helpers.findByText;

import java.time.Duration;
import java.util.List;

import static com.pearl.auto.android.utils.Helpers.driver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SettingsPage {
	
	public void clickMenu(String menuName) {
		findByText(menuName).click();
	}
	
	public void scrollMenu() throws InterruptedException {
		MobileElement content = find(By.id("android:id/list"));
		
		int x = content.getRect().width;
		int y = content.getRect().height;
		int scrollX = x / 2;
		int scrollY = y / 2;
		
		System.out.println(String.format("Scrolling in %d and %d: X: %d, Y: %d", x, y, scrollX, scrollY));
		
		new TouchAction<>(driver)
			.press(PointOption.point(scrollX, scrollY))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(0, 30))
			.release()
			.perform();
	}

	public void selectWallpaper(int i) {
		List<MobileElement> wallpapers = findElements(By.xpath("//*[@resource-id='com.google.android.googlequicksearchbox:id/wallpaper_image']"));
		
		wallpapers.get(i).click();
	}
}
