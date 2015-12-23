package com.nexo.sourcing.SourcingAutomationNexo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Logger;

import javax.management.MBeanException;
import javax.xml.xpath.XPathExpressionException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

public class SourcingLogin implements SourcingInterface {

	private String url;
	String username;
	String password;

	public SourcingLogin(String url) {
		this.url = url;

	}

	public void test(String url, WebDriver driver) throws Exception {
		System.out.println("Running");
	}

	public void setLoginCredentials(String newUsername, String newPassword) {
		this.username = newUsername;
		this.password = newPassword;
	}

	public void getSourcing(String username, String password, WebDriver driver) {
		WebElement foundUsername = driver.findElement(By.id("sap-user"));
		foundUsername.click();
		foundUsername.sendKeys(username);
		WebElement foundPassword = driver.findElement(By.id("sap-password"));
		foundPassword.click();
		foundPassword.clear();
		foundPassword.sendKeys(password); // used sendkeys("greenpeace")
		return;
	}

	public void continueButton(WebDriver driver) {

		WebElement button = driver.findElement(By.id("LOGON_BUTTON"));
		button.click();
		try {
			// pushing Logon button
			WebElement continueButton = driver.findElement(By.id("SESSION_QUERY_CONTINUE_BUTTON"));
			if (continueButton != null) {
				continueButton.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			clickOnResourcePlanningButton(driver);
		}

	}
	// driver.get(System.getProperty("login.url"));

	public void clickOnResourcePlanningButton(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement resourcePlanningButton = driver.findElement(By.cssSelector("#ul_nav_1 li:nth-child(4) a"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			resourcePlanningButton.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		} catch (Exception e) {
			WebElement resourcePlanningButton = driver.findElement(By.xpath("//span[text()='Resourceplanning']"));
			resourcePlanningButton.isDisplayed();
			resourcePlanningButton.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			System.out.println("exception");
		}
	}

	public void clickOnCreateFSRequest(WebDriver driver) {
		// webdriver pushing button CreateFSRequest
		WebElement CreateFSRequest = driver.findElement(By.id("WD51"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CreateFSRequest.click();
	}

	// code ex code van raoul combineren
	/*
	 * public static void mulptiTransfer(WebDriver driver, By dropdownID, String
	 * text, By to) { String valuetext = dropdownID; WebElement element =
	 * findElements(driver, dropdownID); Select select = new Select(element);
	 * List<WebElement> options = element.findElements(By.tagName("option"));
	 * for (WebElement value: options) { valuetext = value.getText(); if
	 * (valuetext.equalsIgnoreCase(text)) { try {
	 * select.selectByVisibleText(valuetext); locateElement(driver, to,
	 * 5).click(); break; } catch (Exception e) { System.out.println(valuetext +
	 * "Value not found in Dropdown to Select"); } } } }
	 */

	public void detailRequest(WebDriver driver) {
		WebElement entryTest = driver.findElement(By.id("WD01D4"));
		entryTest.clear();
		entryTest.click();
		entryTest.sendKeys("Naam order");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click checkbox "Registratieve aanvr." + check if it is not selected
		// already
		if (!driver.findElement(By.id("WD023B-img")).isSelected()) {
			driver.findElement(By.id("WD023B-img")).click();
		}
	}

	public void clientDetails(WebDriver driver)
			throws SAXException, IOException, XPathExpressionException, MBeanException {

		try {

			// loading data from XML
			XmlUtils.readXmlData();
			{
				WebElement customerName = driver.findElement(By.id("WD025E"));
				customerName.click();
				customerName.sendKeys("Naam van klant");
				customerName.sendKeys("" + XmlUtils.retrieveElementByXMLtag("//newUsername//newPassword"));

				// WebElement responsible =
				// driver.findElement(By.xpath(".//*[@id='WD0279' and
				// contains(@title,
				// 'Inzetverantwoordelijke')]"));
				WebElement responsible = driver.findElement(By.id("WD0279")); // id
																				// of
																				// input
																				// field
																				// "Inzetverantwoordelijke:"
				responsible.click();
				// !! doesn't always insert a String in the input field
				responsible.sendKeys("verantwoordelijke");

				// CS (klantorder/interneorder/kostenplaats)
				// WebElement cs =
				// driver.findElement(By.xpath(".//*[@id='WD0280-img']"));
				WebElement cs = driver.findElement(By.id("WD0280-img")); // select
																			// radio(img)
																			// button
																			// "CS"
				// !!!!! Check if the img is already selected. I am not sure if
				// this
				// works as it should!
				if (!cs.isSelected()) {
					cs.click();
				}
				WebElement cs2 = driver.findElement(By.id("WD0285")); // id of
																		// input
																		// field
																		// "Inzetverantwoordelijke:"
				cs2.click();
				cs2.sendKeys("734-10"); // mantelcontract // nummer moet bestaan
										// kan
										// geen dummy tekst doen.
				WebElement rol = driver.findElement(By.id("WD035A")); // click
																		// tab
																		// "Rollen"
			}
		} catch (Exception e2) {

			System.out.println("ClientDetials Failed to Run");
		}
	}

	public void clickOnRolTab(WebDriver driver) {
		WebElement rol = driver.findElement(By.id("WD035A")); // click tab
																// "Rollen"
		rol.click();
	}

	public void rolDetails(WebDriver driver) {
		// "Omschrijving rol:"
		WebElement rolDescription = driver.findElement(By.id("WD0444")); // id
																			// of
																			// input
																			// field
																			// "Omschrijving
																			// rol:"
		rolDescription.click();
		rolDescription.sendKeys("Dit is een omschrijving van de rol");

		// "Rolstandplaats:"
		WebElement rolPlace = driver.findElement(By.id("WD0453")); // id of
																	// input
																	// field
																	// "Rolstandplaats:"
		rolPlace.click();
		rolPlace.sendKeys("standplaats");

		// "AI-rolnaam:"
		WebElement rolNameAI = driver.findElement(By.id("WD0511")); // id of
																	// input
																	// field
																	// "AI-rolnaam:"
		rolNameAI.click();
		rolNameAI.sendKeys("rolnaam fieldmanager");
	}

	public void timeRules(WebDriver driver) {
		// Add new "Tijdregels"
		// click button "Nieuw"
		WebElement addNewTimeRule = driver.findElement(By.id("WD0536"));
		addNewTimeRule.click();

		// Begindatum regel1
		WebElement startDate = driver.findElement(By.id("WD07BC"));
		startDate.click();
		startDate.sendKeys("02.12.2015");

		// Einddatum regel1
		WebElement endDate = driver.findElement(By.id("WD07BE"));
		endDate.click();
		endDate.sendKeys("03.12.2015");

		// check if hours are correct
		WebElement checkHour = driver.findElement(By.id("WD07C1"));
		String checkHourStr = checkHour.getAttribute("value");
		// Assert.assertEquals("8,00", checkHourStr);
	}

	public void requiredCompetences(WebDriver driver) {
		// Find + clear + "Talen" and insert skill
		WebElement skill = driver.findElement(By.id("WD0639"));
		skill.click();
		skill.clear();
		skill.sendKeys("Nederlands");
		/*
		 * Still needs to be added: DROPDOWN "Jobtekst:" input field id = WD063F
		 * (for button WD063F-btn)
		 */

		// Missing the dropdown to be able to save
		// Send rol (click button)
		WebElement sendRol = driver.findElement(By.id("WD03AE"));
		sendRol.click();
	}

	public void clickOnCandidatesTab(WebDriver driver) {
		try {
			WebElement candidate = driver.findElement(By.id("WD0794")); // click
																		// tab
																		// "Kandidaten"
			candidate.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//

			System.out.println("Candidate selected");
		} catch (Exception e) {
			System.out.println("Candidate NOT Selected");
		}
	}

	public void addCandidates(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//
		try {
			WebElement addEmployee = driver.findElement(By.id("WD0794")); // click
																			// "Toevoegen"
			addEmployee.click();
		} catch (Exception e) {
			WebElement adddEmployee = driver.findElement(By.id("WD0794-focus")); // click
																					// "Toevoegen"
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement addDetailsEmp = driver.findElement(By.id("WD0806"));
			addDetailsEmp.click();
			addDetailsEmp.sendKeys("Naam"); // zie orderlijst????

		}
		// !!!! Let op: mits de aangeboden kandidaat een externe kandidaat is,
		// moet je tevens bij het veld BU t.b.v.
		// !!!! inzetcontract de correcte Business Unit selecteren

		// Insert details
		// WD0879 //WD0892 WD0892 //WD0894
		// WebElement addDetailsEmp =
		// driver.findElement(By.xpath(".//*[@id='WD0879']/span/input"));

		// mist dropdowns om te saven
		// Save

		WebElement saveRol = driver.findElement(By.id("WD0151"));
		saveRol.click();
	}

	public String getUrl() {
		return url;
	}

}
/*
 * 
 * 
 *
 * driver.findElement(By.cssSelector(
 * "input[type=�password�][name=�sap-password�]")).sendKeys("Greenpeace_1985");
 * //driver.findElement(By.cssSelector(
 * "input#sap-password.urEdf2TxRadius.urEdf2TxtEnbl.urBorderBox")).sendKeys(
 * "Greenpeace_1985"); //
 * driver.findElement(By.className("urEdf2Whl")).sendKeys("Greenpeace_1985");
 * 
 * 
 * 
 * 
 * 
 * 
 * WebElement element2 = driver.findElement(By.cssSelector(
 * "#ul_nav_1 li:nth-child(4) a")); element2.click();
 * 
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
 * 
 * // webdriver pushing button CreateFSRequest WebElement CreateFSRequest=
 * driver.findElement(By.id("WD51")); CreateFSRequest.click(); WebElement
 * entryTest = driver.findElement(By.id("WD01D1")); entryTest.clear();
 * entryTest.click(); entryTest.sendKeys("Invoer gegevens");
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * System.out.println("Page title is: " + driver.getTitle());
 * Thread.sleep(10000); driver.quit();
 * 
 * 
 * 
 */
