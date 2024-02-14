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

}
