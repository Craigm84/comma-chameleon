package com.lbg.project.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:frontend-schema.sql",
		"classpath:frontend-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class ProjectTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

//create buyer
	@Test
	@Order(1)
	void testCreateBuyer() {
		this.driver.get("http://localhost:" + this.port);

		WebElement clickBuyer = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(3) > button"));
		clickBuyer.click();

		WebElement fName = this.driver.findElement(By.cssSelector("#firstName"));
		fName.sendKeys("Lucy");

		WebElement sName = this.driver.findElement(By.cssSelector("#lastName"));
		sName.sendKeys("Yates");

		WebElement register = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > div > button"));
		register.click();

		WebElement created = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p.col"));
		Assertions.assertEquals("Lucy Yates", created.getText());

		WebElement Delete = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p:nth-child(2) > button"));
		Delete.click();
//
//		this code failed due to no function in react...
//
	}

//
	@Test
	@Order(2)
	void testCreateSeller() {
		this.driver.get("http://localhost:" + this.port);

		WebElement clickSeller = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(4) > button"));
		clickSeller.click();

		WebElement fNames = this.driver.findElement(By.cssSelector("#firstName"));
		fNames.sendKeys("Craig");

		WebElement sNames = this.driver.findElement(By.cssSelector("#lastName"));
		sNames.sendKeys("Morris");

		WebElement registers = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > div > button"));
		registers.click();

		WebElement createdSeller = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p.col"));
		Assertions.assertEquals("Craig Morris", createdSeller.getText());

		WebElement Deletes = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p:nth-child(2) > button"));
		Deletes.click();

//		this code failed due to no function in react...

	}
//

	@Test
	@Order(3)
	void testAddPropety() {
		this.driver.get("http://localhost:" + this.port);
		WebElement clickAddProperty = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(6) > button"));
		clickAddProperty.click();

		WebElement addAddress = this.driver.findElement(By.cssSelector("#address"));
		addAddress.sendKeys("1 main street");

		WebElement addCity = this.driver.findElement(By.cssSelector("#city"));
		addCity.sendKeys("London");

		WebElement clickAddType = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(1) > div:nth-child(3) > select > option:nth-child(1)"));
		clickAddType.click();

		WebElement clickSelectFlat = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(1) > div:nth-child(3) > select > option:nth-child(6)"));
		clickSelectFlat.click();

		WebElement addPrice = this.driver.findElement(By.cssSelector("#price"));
		addPrice.sendKeys("250000");

		WebElement clickAddBedroom = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(2) > select > option:nth-child(1)"));
		clickAddBedroom.click();

		WebElement clickSelect4 = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(2) > select > option:nth-child(5)"));
		clickSelect4.click();

		WebElement clickAddBathroom = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(3) > select > option:nth-child(1)"));
		clickAddBathroom.click();

		WebElement clickSelect2 = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(3) > select > option:nth-child(3)"));
		clickSelect2.click();

		WebElement clickAddGarden = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(1) > select > option:nth-child(1)"));
		clickAddGarden.click();

		WebElement clickSelectNo = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(1) > select > option:nth-child(3)"));
		clickSelectNo.click();

		WebElement clickAddStatus = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(2) > select > option:nth-child(1)"));
		clickAddStatus.click();

		WebElement clickSelectForSale = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(2) > select > option:nth-child(2)"));
		clickSelectForSale.click();

		WebElement addImage = this.driver.findElement(By.cssSelector("#image"));
		addImage.sendKeys("house");

		WebElement clickSubmit = this.driver
				.findElement(By.cssSelector("#root > div > div > form > div.mt-2 > button"));
		clickSubmit.click();

		WebElement clickSold = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div > div:nth-child(2) > div > div > div > div > button.btn.btn-warning"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", clickSold);
		clickSold.click();

		WebElement clickWithdraw = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > button.btn.btn-danger"));
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", clickWithdraw);
		clickWithdraw.click();

		WebElement clickForSale = this.driver.findElement(By
				.cssSelector("#root > div > div > div > div > div > div > div > div > div > button.btn.btn-secondary"));
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", clickForSale);
		clickForSale.click();
	}
}
