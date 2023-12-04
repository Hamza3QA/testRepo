package pages;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageBase {		 //all actions and initialization of pages
	AndroidDriver driverForPageBase;
	
	//Initialization
	public PageBase (AndroidDriver appiumDriverFromTestBase) {
		driverForPageBase = appiumDriverFromTestBase;
		PageFactory.initElements(new AppiumFieldDecorator(driverForPageBase), this);
	}
	
	//Action to click
	public void click (WebElement element) {
		element.click();
	}
	
	//Action to get string
	public String getText (WebElement element) {
		return element.getText();
	}
	
	//Action to pass a string
	public void sendKeys (WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
	public Dimension getScreenSize() {
		Dimension size = driverForPageBase.manage().window().getSize();
		return size;
	}
	
	public Point getScreenMidPoint () {
		Dimension screenSize = this.getScreenSize();
		Point centerPoint = new Point((int)(screenSize.width*0.5), (int)(screenSize.height*0.5));
//		centerPoint.x = screenSize.getWidth()/2;
//		centerPoint.y = screenSize.getHeight()/2;		
		return centerPoint;
	}
	
	//scroll action
	public void scrollUp() {
		Dimension screenSize = this.getScreenSize();
		Point centerPoint = new Point((int)(screenSize.width*0.5), (int)(screenSize.height*0.5));
//		centerPoint.x = screenSize.getWidth()/2;
//		centerPoint.y = screenSize.getHeight()/2;
		int bottom = (int) (centerPoint.y + (centerPoint.y * 0.75));
		int top = (int) (centerPoint.y - centerPoint.y * 0.75);
		Point start = new Point(centerPoint.x, bottom);		//bottom to top scroll
		Point end = new Point(centerPoint.x, top);
		swipeTo(start, end, Duration.ofMillis(1000));
	}
	
	//swipe action
	public void swipeTo(Point start, Point end, Duration duration) {
		PointerInput indexFinger = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
		Sequence swipe = new Sequence(indexFinger, 1);
		//
		swipe.addAction(indexFinger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));	//viewPort - actual view of the screen
		swipe.addAction(indexFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		//
		swipe.addAction(indexFinger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));	//viewPort - actual view of the screen
		swipe.addAction(indexFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));	//release mouse button
		
		driverForPageBase.perform(Collections.singleton(swipe));
	}
	
	public Point getElementLocation (WebElement element) {
		Point elementPoint = element.getLocation();
		return elementPoint;
	}
	
	public Dimension getElementSize (WebElement element) {
		Dimension elementpoint = element.getSize();
		return elementpoint;
	}
	
	//Touch Action
	public void tap (WebElement element) {
		//crate finger
		PointerInput indexFinger = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
		Point elementLocation = this.getElementLocation(element);
		Sequence tap = new Sequence(indexFinger, 1);
		tap.addAction(indexFinger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), elementLocation));
		tap.addAction(indexFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(new Pause(indexFinger, Duration.ofMillis(250)));
		tap.addAction(indexFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	}
	
	//swipe action
	public void swipe (WebElement element) {
		PointerInput indexFinger = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
		Point elementLocation = this.getElementLocation(element);
		Dimension elementDimension = this.getElementSize(element);
		Point startPoint = new Point((int) (elementDimension.getWidth()*0.10), elementDimension.getHeight());
		Point endPoint = new Point((int) (elementDimension.getWidth()*0.90), elementDimension.getHeight());
		
		Sequence tap = new Sequence(indexFinger, 1);
		tap.addAction(indexFinger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), startPoint));
		tap.addAction(indexFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(indexFinger.createPointerMove(Duration.ofMillis(150), PointerInput.Origin.viewport(), endPoint));
		tap.addAction(indexFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	}
	
	//get screen Top
	public Point getScreenTop() {
		Dimension screenSize = this.getScreenSize();
		Point top = new Point((int)(screenSize.width * 0.5), (int)(screenSize.height* 0.1));
		return top;
	}
	
	//get screen Left
	public Point getScreenLeft() {
		Dimension screenSize = this.getScreenSize();
		Point left = new Point((int)(screenSize.width * 0.5), (int)(screenSize.height * 0.1));
		return left;
	}
	
	//get screen Bottom
	public Point getScreenBottom() {
		Dimension screenSize = this.getScreenSize();
		Point bottom = new Point((int)(screenSize.width * 0.9), (int)(screenSize.height * 0.5));
		return bottom;
	}
	
	//get screen right
	public Point getScreenRight() {
		Dimension screenSize = this.getScreenSize();
		Point right = new Point((int)(screenSize.width * 0.5), (int)(screenSize.height * 0.9));
		return right;
	}
	
	//get screen center
	public Point getScreenCenter() {
		Dimension screenSize = this.getScreenSize();
		Point center = new Point((int)(screenSize.width * 0.5), (int)(screenSize.height * 0.5));
		return center;
	}
	
	//get screen custom point
	public Point getScreenCustomPoint(Float xOFFSet, Float yOFFSet) {
		Dimension screenSize = this.getScreenSize();
		Point customPoint = new Point((int)(screenSize.width * xOFFSet), (int)(screenSize.height * yOFFSet));
		return customPoint;
	}
}
