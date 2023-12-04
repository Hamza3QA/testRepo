package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import pages.HomePage;
import pages.ViewsPage;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static Properties properties;
	public HomePage homePage;
	public ViewsPage viewsPage;
	String homeDirectory = System.getProperty("user.home");		// returns home Dir which in my case is=C:\\Users\\TK-LPT-125\\
	String userDirectory = System.getProperty("user.dir");		// returns users current Dir which in my case is=C:\\Users\\TK-LPT-125\\eclipse-workspace\\mobileTraining
	
	public void getProperties() throws IOException{
		properties = new Properties();
		FileInputStream configFile = new FileInputStream(userDirectory + "\\config.properties");
		properties.load(configFile);
	}
	
	public void startServer() {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		
		serviceBuilder.withIPAddress(properties.getProperty("appiumServerUrl"))
		.usingPort(Integer.parseInt(properties.getProperty("appiumServerPort")))
		.withTimeout(Duration.ofSeconds(60))		//
		.withArgument(GeneralServerFlag.SESSION_OVERRIDE)		//terminate previous session and start a new session
//		.usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"))		//
		.withAppiumJS(new File(properties.getProperty("appiumJSFileLocation")));
		
		service = AppiumDriverLocalService.buildService(serviceBuilder);
		
		service.start();
	}
	
	public void driverInitilialization () throws MalformedURLException {
		//set capabilities/options
		UiAutomator2Options capabilities = new UiAutomator2Options();
		capabilities.setPlatformName(properties.getProperty("platformName"));
//		capabilities.setAppPackage(properties.getProperty("appPackage"));
//		capabilities.setAppActivity(properties.getProperty("appActivity"));
		capabilities.setApp(userDirectory + properties.getProperty("setAppCapability"));
//		capabilities.setUdid("067952518B105038");
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4724");
		
		driver = new AndroidDriver(url,capabilities);
	}
	
	@BeforeClass
	public void startUp() throws IOException {
		getProperties();
		startServer();
		driverInitilialization();
	}
	
	@BeforeMethod
	public void restartApp() throws InterruptedException{
		String packageName = driver.getCurrentPackage();
		driver.terminateApp(packageName);					//only with Android Driver, not with Appium driver
		driver.activateApp(packageName);					//
		Thread.sleep(4000);
	}	
	
	
	@Test (priority = 2)
	public void readContent () throws MalformedURLException, InterruptedException {
//		driverInitilialization();
		//2. Click Views button //get element [xpath, id, class, address] to perform action
		WebElement contentBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Content']"));
		contentBtn.click();
		Thread.sleep(2000);
//		driver.wait(5000);
		//3. click Grid button
		WebElement assetBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Assets']"));		
		assetBtn.click();
		Thread.sleep(2000);
		//4. Click Icon Grid button
		WebElement readAssetBtn = driver.findElement(By.id("android:id/text1"));
		readAssetBtn.click();
		Thread.sleep(2000);
	}
		
	@AfterClass
	public void tearUp() {
		driver.terminateApp("io.appium.android.apis");
		driver.quit();
		service.stop();
	}
}
