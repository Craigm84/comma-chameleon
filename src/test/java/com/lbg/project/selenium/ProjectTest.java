package com.lbg.project.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
//@Sql(scripts = { "classpath:frontend-schema.sql",
//		"classpath:frontend-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

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

	@Test
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
				.findElement(By.cssSelector("#root > div > div > div.col-4 > div > div > div > p.col"));
		Assertions.assertEquals("Lucy Yates", created.getText());

	}

}
