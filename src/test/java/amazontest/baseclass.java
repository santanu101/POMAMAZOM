package amazontest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseclass 
{
	 static AndroidDriver driver ;
	@BeforeTest
	public void testApp() throws Exception{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"jitun");
		dc.setCapability("appPackage","com.amazon.mShop.android.shopping");
		dc.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
		dc.setCapability(MobileCapabilityType.APP,"E:\\Eclipse Kepler WorkSpace\\RandomWork\\Santanuapk\\apps\\Amazon_shopping.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
	    driver = new AndroidDriver(url,dc);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 300);
        driver.context("NATIVE_APP"); 
        
     }
	
	@AfterTest
	public void tearDown() {
		System.out.println("testing completed"); 
		}
	

}
