package testCases;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import base.AppTest;
import pages.HomePage;
import pages.RotatingButtonPage;
import pages.ViewsPage;

public class VerifySliderX extends AppTest{
	HomePage homePage;
	ViewsPage viewsPage;
	RotatingButtonPage rotatingButtonPage;
	
	@Test
	public void verifySlider () throws InterruptedException {
		homePage = new HomePage(driver);
		viewsPage = new ViewsPage(driver);
		rotatingButtonPage = new RotatingButtonPage(driver);
		
		homePage.click(homePage.getViewsBtn());
		viewsPage.scrollUp();
		viewsPage.click(viewsPage.getRotatingElement());
		Point elementLocation = rotatingButtonPage.getElementLocation(rotatingButtonPage.getSliderX());
		Dimension elementSize = rotatingButtonPage.getElementSize(rotatingButtonPage.getSliderX());
		
		Dimension screenSize = rotatingButtonPage.getScreenSize();
		Point startPoint = new Point((int) ((elementLocation.getX()+ elementSize.getWidth())*0.10), (int)((elementLocation.getY()+ elementSize.getHeight()) * 0.5));
		Point endPoint = new Point((int) ((elementLocation.getX()+ elementSize.getWidth())*0.90), (int)((elementLocation.getY()+ elementSize.getHeight()) * 0.5));
		
		rotatingButtonPage.swipeTo(startPoint, endPoint, Duration.ofMillis(5000));
		Thread.sleep(5000);
	}
}
