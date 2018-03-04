package com.pearl.auto.android.page;

import static com.pearl.auto.android.utils.Helpers.driver;
import static com.pearl.auto.android.utils.Helpers.driverWait;
import static com.pearl.auto.android.utils.Helpers.find;
import static com.pearl.auto.android.utils.Helpers.pressBack;
import static com.pearl.auto.android.utils.Helpers.implicitWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.functions.ExpectedCondition;

public class GoogleTranslatePage {

	public void clickDone() {
	    find(By.xpath(("/hierarchy/android.widget.FrameLayout")));
	    find(By.id("com.google.android.apps.translate:id/button_done")).click();

		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.translate:id/design_navigation_view")));
		pressBack();
	}
	
	public String translate(String words) {
		implicitWait(5);
		find(By.id("com.google.android.apps.translate:id/touch_to_type_text")).click();
		implicitWait(5);
		find(By.id("com.google.android.apps.translate:id/edit_input")).sendKeys(words);
		implicitWait(10);
		find(By.id("Show details")).click();
		
		implicitWait(10);
		
		return driver.findElement(By.id("result_container"))
					 .findElement(By.xpath("//*[@resource-id='android:id/text1']")).getAttribute("text");
	}
}
