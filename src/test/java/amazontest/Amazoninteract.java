package amazontest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Amazoninteract extends baseclass  {
	@Test(priority=0)
	public void testApp1() throws Exception{		    
	        System.out.println("App launched");
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
	        Thread.sleep(10000);
	        //Searching for 64-inch tv
	        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("65-inch tv");
	        driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action","Go"));
	        WebElement el =  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)\"));"));
	        el.click();
	        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);;
	        //Verify the onscreen text
	       Boolean iselementpresent =  driver.findElementsByClassName("android.view.View").size()!=0;
	        Assert.assertTrue(iselementpresent, "Targeted element Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black) is not present on screen");
	        System.out.println("Target elememt Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)is present on screen");
	        WebElement el1 = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Add to Cart\"));"));
	        //Click on Add to Cart
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	        driver.findElement(By.className("android.widget.Button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.className("android.widget.Button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.className("android.widget.Button")).click();
		
	       
	}
	@Test(priority=1)	
	 public void login() throws InterruptedException {
	 driver.findElement(By.className("android.widget.EditText")).sendKeys("7012691029");
   Thread.sleep(10000);
   driver.findElement(By.className("android.widget.Button")).click();
   Thread.sleep(10000);
   driver.findElement(By.className("android.widget.EditText")).sendKeys("@Dec1986");
   driver.findElement(By.className("android.widget.Button")).click();
	}
}
