package com.nexo.sourcing.SourcingAutomationNexo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoucingRequestInsertion implements SourcingInterface {
	Logger logger = LoggerFactory.getLogger(SoucingRequestInsertion.class);

	private String url;

	public SoucingRequestInsertion(String url) {
		this.url = url;
	}

	public void test(String url, WebDriver driver) throws Exception {

		WebElement element2 = driver.findElement(By.cssSelector("#ul_nav_1 li:nth-child(4) a"));
		element2.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		logger.getName();
	}


	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}
	// select box entry by value (select input)

}
