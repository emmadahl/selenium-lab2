package com.example.seleniumlab2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    static WebDriver driver;
    @Given("SVT Play is available")
    public void svt_play_is_available() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.get("https://www.svtplay.se/");

    }
    @When("User visits SVT Play")
    public void user_visits_svt_play() {
        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

    }
    @Then("Title should be {string}")
    public void title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle, "Title does not match");
    }

    @Then("Logotype should be visible")
    public void logotype_should_be_visible() {

        boolean result = driver.findElement(By.className("sc-31022b15-0")).isDisplayed();

        Assertions.assertTrue(result, "Logotype is not visible");
    }

    @Then("Start menu text should be {string}")
    public void start_menu_text_should_be(String start) {

        WebElement startLink = driver.findElement(By.className("ilPmDY"));
        String startLinkText = startLink.getText();

        assertEquals("START", startLinkText, "Text does not match");
    }

    @Then("Program menu text should be {string}")
    public void program_menu_text_should_be(String program) {
        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));
        String programLinkText = programLink.getText();

        assertEquals(program, programLinkText, "Text does not match");
    }

    @Then("Chanel menu text should be {string}")
    public void chanel_menu_text_should_be(String kanaler) {
        WebElement chanelLink = driver.findElement(By.xpath("//a[text() = 'Kanaler']"));
        String chanelLinkText = chanelLink.getText();

        assertEquals(kanaler, chanelLinkText, "Text does not match");
    }

    @Then("Availability link text should be {string}")
    public void availability_link_text_should_be(String expectedText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)")));

        WebElement availability = driver.findElement(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)"));

        String availabilityText = availability.getText();

        assertEquals(expectedText, availabilityText, "Text does not match");
    }

    @When("User clicks on availability link")
    public void user_clicks_on_availability_link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")));

        WebElement availabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        availabilityLink.click();
    }

    @Then("Heading should be {string}")
    public void heading_should_be(String quoteText) {
        String headingText = driver.findElement(By.xpath("//h1[text() = 'Så arbetar SVT med tillgänglighet']")).getText();

        assertEquals(quoteText, headingText,"Heading does not match");
    }

    @When("User clicks on program link")
    public void user_clicks_on_program_link() throws InterruptedException {
        Thread.sleep(5000);

        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));

        programLink.click();
    }

    @Then("Number of categories should be correct")
    public void number_of_categories_should_be_correct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-a9073dc0-0")));

        List<WebElement> categoryItems = driver.findElements(By.className("sc-a9073dc0-0"));

        assertEquals(17, categoryItems.size(), "The number of categories does not match");
    }




}
