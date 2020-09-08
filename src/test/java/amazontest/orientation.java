package amazontest;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class orientation extends Amazoninteract {
	//public static AndroidDriver driver = null;
	
	String nodePath = "C:/Progra~1/Appium/node.exe";
	// Set path of your appium.js file. Set your path.
	String appiumJSPath = "C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/appium.js";
	
	 // This method Is responsible for starting appium server.
	@Test(priority=1)	
	 public void appiumStart() throws IOException, InterruptedException {
	  // Created object of apache CommandLine class.
	  // It will start command prompt In background.
		String nodePath = "C:/Progra~1/Appium/node.exe";
		 // Set path of your appium.js file. Set your path.
		String appiumJSPath = "C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/appium.js";
		
	  CommandLine command = new CommandLine("cmd");
	  // Add different arguments In command line which requires to start appium server.
	  command.addArgument("/c");
	  command.addArgument(nodePath);
	  command.addArgument(appiumJSPath);
	  // Set Server address
	  command.addArgument("--address");
	  command.addArgument("127.0.0.1");
	  // Set Port
	  command.addArgument("--port");
	  command.addArgument("4723");
	  command.addArgument("--no-reset");
	  command.addArgument("--log");
	  // Execute command line arguments to start appium server.
	  DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	  DefaultExecutor executor = new DefaultExecutor();
	  executor.setExitValue(1);
	  executor.execute(command, resultHandler);
	  // Wait for 15 minutes so that appium server can start properly before going for test execution.
	  // Increase this time If face any error.
	  Thread.sleep(15000);
	 }

	 // This method Is responsible for stopping appium server.
	 public static void appiumStop() throws IOException {
	  // Add different arguments In command line which requires to stop appium server.
	  CommandLine command = new CommandLine("cmd");
	  command.addArgument("/c");
	  command.addArgument("taskkill");
	  command.addArgument("/F");
	  command.addArgument("/IM");
	  command.addArgument("node.exe");
	  // Execute command line arguments to stop appium server.
	  DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	  DefaultExecutor executor = new DefaultExecutor();
	  executor.setExitValue(1);
	  executor.execute(command, resultHandler);
	 }
	 @Test(priority=2)	
	 public void performOrientation() throws InterruptedException {
		 //Get and print current screen orientation.
		 System.out.println("*--*--*-- Current screen orientation Is : " + driver.getOrientation());
		 System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		 //Changing screen Orientation to LANDSCAPE.
		 driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		 //Get and print screen orientation after changing It.
		 System.out.println("*--*--*-- Now screen orientation Is : "+ driver.getOrientation());
		 Thread.sleep(5000);
		 System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		 //Changing screen Orientation to PORTRAIT.
		 driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		 //Get and print screen orientation after changing It.
		 System.out.println("*--*--*-- Now screen orientation Is : "+ driver.getOrientation());
		 Thread.sleep(5000);
	 }
		 
}
