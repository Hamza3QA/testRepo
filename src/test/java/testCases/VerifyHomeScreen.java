package testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.AppTest;
import pages.HomePage;
import pages.ViewsPage;

public class VerifyHomeScreen extends AppTest{
	
	@Test (priority = 0)
	public void verifyHomeScreen () throws MalformedURLException, InterruptedException {
//		driverInitilialization();
		homePage = new HomePage (driver);
		
		WebElement verifyDemoScreen = homePage.getHomePageTitle();
		Assert.assertNotNull(verifyDemoScreen);
		
		//Access'ibility button
		WebElement accessBtn = homePage.getAccessBtn();
		String accessBtnText = accessBtn.getText();
		Assert.assertEquals(accessBtnText, "Access'ibility");
		
		//Accessibility button
		WebElement accessibilityBtn = homePage.getAccessibilityBtn();
		String accessbilityBtnText = accessibilityBtn.getText();
		Assert.assertEquals(accessbilityBtnText, "Accessibility");
		
		//Animation button
		WebElement animationBtn = homePage.getAnimationBtn();
		String animationBtnText = animationBtn.getText();
		Assert.assertEquals(animationBtnText, "Animation");
		
		//App button
		WebElement appBtn = homePage.getAppBtn();
		String appBtnText = appBtn.getText();
		Assert.assertEquals(appBtnText, "App");
		
		//Content button
		WebElement contentBtn = homePage.getContentBtn();
		String contentBtnText = contentBtn.getText();
		Assert.assertEquals(contentBtnText, "Content");
		
		//Graphics button
		WebElement graphicsBtn = homePage.getGraphicsBtn();
		String graphicsBtnText = graphicsBtn.getText();
		Assert.assertEquals(graphicsBtnText, "Graphics");
		
		//Media button
		WebElement mediaBtn = homePage.getMediaBtn();
		String mediaBtnText = mediaBtn.getText();
		Assert.assertEquals(mediaBtnText, "Media");
		
		//NFC button
		WebElement nfcBtn = homePage.getNFCBtn();
		String nfcBtnText = nfcBtn.getText();
		Assert.assertEquals(nfcBtnText, "NFC");
		
		//OS button
		WebElement osBtn = homePage.getOSBtn();
		String osBtnText = osBtn.getText();
		Assert.assertEquals(osBtnText, "OS");
		
		//Preference button
		WebElement prefBtn = homePage.getPreferenceBtn();
		String prefBtnText = prefBtn.getText();
		Assert.assertEquals(prefBtnText, "Preference");
		
		//Text button
		WebElement textBtn = homePage.getTextBtn();
		String textBtnText = textBtn.getText();
		Assert.assertEquals(textBtnText, "Text");
		
		//Views button
		WebElement viewsBtn = homePage.getViewsBtn();
		String viewsBtnText = viewsBtn.getText();
		Assert.assertEquals(viewsBtnText, "Views");
		
	}
}
