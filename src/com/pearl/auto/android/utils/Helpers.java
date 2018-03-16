package com.pearl.auto.android.utils;

import java.awt.Point;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pearl.auto.enums.ScrollDirection;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Helpers {

	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait driverWait;
	
	public static MobileElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<MobileElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static MobileElement findByText(String text) {
		return driver.findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text));
	}
	
	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public static void pressBack() {
		driver.navigate().back();
	}
	
	public static void goToHome() {
		driver.pressKeyCode(AndroidKeyCode.HOME);
	}
	
	public static void scroll(int startX, int endX, int startY, int endY) throws InterruptedException {
		MobileElement content = find(By.id("android:id/list"));
		
		// We tell the compiler to ignore the Generic for now using this annotation
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction<>(driver)
			.press(PointOption.point(startX, startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(endX, endY))
			.release();
		
		action.perform();
	}
	
	private static Point findCenter(MobileElement e) {
		int scrollX = e.getRect().width / 2;
		int scrollY = e.getRect().height / 2;

		System.out.println(String.format("%d %d", e.getRect().width, e.getRect().height));
		System.out.println(String.format("%d %d", scrollX, scrollY));
		
		return new Point(scrollX, scrollY);
	}
}