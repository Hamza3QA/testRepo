package testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.AppTest;
import pages.HomePage;
import pages.ViewsPage;

public class ViewsTestCases extends AppTest{

	HomePage homePage;
	ViewsPage viewsPage;
	
	@Test (priority = 1)
	
	public void openIconGrid () throws MalformedURLException, InterruptedException {
//		driverInitilialization();	
		//2. Click Views button //get element [xpath, id, class, address] to perform action
		homePage = new HomePage (driver);
		WebElement viewsBtn = homePage.getViewsBtn();		
		
		Assert.assertNotNull(viewsBtn);	//element availability [assertNull/assertNotNull]
		
		String viewsBtnText = viewsBtn.getText();
		Assert.assertEquals(viewsBtnText, "Views");
		homePage.click(viewsBtn);
		Thread.sleep(5000);
//		driver.wait(5000);
		//3. click Grid button
		ViewsPage viewsPage = new ViewsPage(driver);
		WebElement gridBtn = viewsPage.getGridBtn("Android");
		gridBtn.click();
		Thread.sleep(5000);
		//4. Click Icon Grid button
		WebElement iconGridBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Icon Grid\"]"));
		iconGridBtn.click();
		Thread.sleep(5000);
		driver.manage().window().getSize();		//to check driver connectivity 'getSize'
	}
}
