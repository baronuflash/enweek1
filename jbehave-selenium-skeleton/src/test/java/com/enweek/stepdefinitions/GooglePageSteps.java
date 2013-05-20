package com.enweek.stepdefinitions;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

public class GooglePageSteps extends BaseSteps {

	@Given("the user goes to the Google website")
	public void visitTheHomePage() {
		driver.get("https://www.google.ro/");
	}

	@When("the user search the word $word")
	public void submitTheForm(String word) {
		driver.findElement(By.id("gbqfq")).sendKeys(word);
	}

	@When("the user click on search button")
	public void clickOnSearch() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("gbqfb")).click();
	}

	@Then("the user should see on the page the $word")
	public void verifyPage(String word) {
		Assert.assertEquals(driver.getPageSource().contains(word), false);
	}
}