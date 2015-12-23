package com.nexo.sourcing.SourcingAutomationNexo;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.apache.http.MessageConstraintException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class ExcelToXml {
	Logger logger = LoggerFactory.getLogger(ExcelToXml.class);

	public void startTestScript(WebDriver driver)
			throws SAXException, IOException, XPathExpressionException, MessageConstraintException {

		try {

			// loading data from XML
			XmlUtils.readXmlData();
			logger.info(" *** PASS - Starting test script *** ");
			driver.findElement(By.name("login_username")).clear();
			driver.findElement(By.name("login_username"))
					.sendKeys("" + XmlUtils.retrieveElementByXMLtag("//userlogin//username"));
			driver.findElement(By.name("secretkey")).clear();
			driver.findElement(By.name("secretkey"))
					.sendKeys("" + XmlUtils.retrieveElementByXMLtag("//userlogin//password"));
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
		}
	}
}
/*
 * // taking screendump to see what page is displayed new
 * DumpUtils().TakeScreendump();
 * 
 * // send mail //new SendLeafMail().SendOutMail(); logger.info(
 * " *** PASS - End test script *** ");
 * 
 * } catch (NoSuchElementException nse) { nse.printStackTrace(); } } }
 */
