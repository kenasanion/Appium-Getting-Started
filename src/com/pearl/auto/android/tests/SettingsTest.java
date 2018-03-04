package com.pearl.auto.android.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pearl.auto.android.main.AppiumBaseTest;

public class SettingsTest extends AppiumBaseTest {

	@Override
	public void init() {
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");
	}

    @org.junit.Test
	public void Sample_Test() throws Exception {
    		
	}
}
