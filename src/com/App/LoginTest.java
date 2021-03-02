package com.App;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTest {
	
	static AndroidDriver<WebElement> driver;

	static File app=new File("F:\\Android Test Automation\\carcon-20200513-dev.apk");

	
	public static void main(String[] args) throws InterruptedException {
		
	
			DesiredCapabilities caps=new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

			caps.setCapability("noReset", "true");
			caps.setCapability("deviceName", "Samsung Galaxy M01");
			caps.setCapability("udid", "R8KN40091ZJ");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "10");
			caps.setCapability("appPackage", "com.chokuapp.dev");
			caps.setCapability("appActivity", "com.chokuapp.ui.splash.SplashActivity");

			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);

			try {
				driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * com.chokuapp.dev:id/edt_email
			 * com.chokuapp.dev:id/edt_password
			 * com.chokuapp.dev:id/button
			 */

		
			Thread.sleep(10000);	

			//Login
			MobileElement Email=(MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/edt_email"));
			MobileElement Password=(MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/edt_password"));
			MobileElement LoginBtn=(MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/button"));
			
			Email.sendKeys("mail@mail.com");
			Thread.sleep(3000);		
			System.out.println("Email Type success");
			
			Password.sendKeys("12333444");
			Thread.sleep(3000);
			System.out.println("Password Type success");
			
			LoginBtn.click();
			System.out.println("Login click success");
			
			driver.closeApp();
		}
		
}
			
	

	
	



