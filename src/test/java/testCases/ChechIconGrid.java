package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.AppTest;
import pages.HomePage;
import pages.ViewsPage;

public class ChechIconGrid extends AppTest{
	HomePage homePage;
	ViewsPage viewsPage;
	
	@Test
	public void openViewsPage() {
		HomePage homePage = new HomePage(driver);
		WebElement viewsBtn = homePage.getViewsBtn();
		Assert.assertNotNull(viewsBtn);
		homePage.click(homePage.getViewsBtn());
	}
	
	@Test
	public void verifyViewsPage () {
		ViewsPage viewsPage = new ViewsPage(driver);
		WebElement gridBtn = viewsPage.getGridBtn("Android");
		Assert.assertNotNull(gridBtn);
	}
}
