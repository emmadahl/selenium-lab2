package com.example.seleniumlab2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumLab2Tests {

    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    void navigate() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.get("https://www.svtplay.se/");

        driver.manage().window().maximize();
    }

    @AfterEach
    void closeBrowser () {
        driver.close();
    }


    @Test
    void checkWebsiteTitle() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        String websiteTitle = driver.getTitle();

        assertEquals("SVT Play", websiteTitle, "Title does not match");
    }

    @Test
    void checkWebsiteLogo() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-31022b15-0")));

        boolean result = driver.findElement(By.className("sc-31022b15-0")).isDisplayed();

        Assertions.assertTrue(result, "Logotype is not visible");
    }

    @Test
    void checkStartLinkName() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ilPmDY")));

        WebElement startLink = driver.findElement(By.className("ilPmDY"));
        String startLinkText = startLink.getText();

        assertEquals("START", startLinkText, "Text does not match");
    }

    @Test
    void checkProgramLinkName() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Program']")));

        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));

        String programLinkText = programLink.getText();

        assertEquals("PROGRAM", programLinkText, "Text does not match");
    }

    @Test
    void checkChanelLinkName() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Kanaler']")));

        WebElement chanelLink = driver.findElement(By.xpath("//a[text() = 'Kanaler']"));
        String chanelLinkText = chanelLink.getText();

        assertEquals("KANALER", chanelLinkText, "Text does not match");
    }

    @Test
    void checkIfLinkIsDisplayed(){

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)")));

        WebElement availability = driver.findElement(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)"));

        boolean availabilityText = availability.isDisplayed();

        assertTrue(availabilityText, "Text is not visible");
    }

    @Test
    void verifyLinkText() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)")));

        WebElement availability = driver.findElement(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)"));

        String availabilityText = availability.getText();

        assertEquals("Tillgänglighet i SVT Play", availabilityText, "Link text does not match");
    }

    @Test
    void followLinkCheckHeading() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")));

        WebElement availabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        availabilityLink.click();

        String headingText = driver.findElement(By.xpath("//h1[text() = 'Så arbetar SVT med tillgänglighet']")).getText();

        assertEquals("Så arbetar SVT med tillgänglighet", headingText,"Heading does not match");
    }

    @Test
    void checkCategories() throws InterruptedException {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        Thread.sleep(5000);

        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));

        programLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-a9073dc0-0")));

        List<WebElement> categoryItems = driver.findElements(By.className("sc-a9073dc0-0"));

        assertEquals(17, categoryItems.size(), "The number of categories does not match");
    }

    //Test, Navigera in till sidan "Kanaler", kontrollera att texten "På SVT just nu" stämmer.
    @Test
    void checkChanelHeading() throws InterruptedException {
        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        Thread.sleep(5000);

        WebElement chanelLink = driver.findElement(By.xpath("//a[text() = 'Kanaler']"));

        chanelLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-c358b5df-0")));

        WebElement chanelHeading = driver.findElement(By.className("sc-c358b5df-0"));

        String chanelHeadingText = chanelHeading.getText();

        assertEquals("På SVT just nu", chanelHeadingText, "Heading text does not match");
    }

    //Kontrollera att länktexten "Nyhetsbrev" stämmer
    @Test
    void checkNewsletterLinkText (){

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        String newsLetterText = newsLetter.getText();

        assertEquals( "Nyhetsbrev", newsLetterText,"The link text does not match");
    }

    // Kontrollera att logotypen är synlig på sidan "Nyhetsbrev"
    @Test
    void checkLogoOnNewsletterPage() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        newsLetter.click();

        boolean logotype = driver.findElement(By.id("logo")).isDisplayed();

        Assertions.assertTrue(logotype, "Logotype is not visible");
    }

    //Navigerar till nyhetsbrev, validerar felmeddelande när felaktig e-post fylls i
    @Test
    void checkErrorMessage() {

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        newsLetter.click();

        WebElement emailInput = driver.findElement(By.id("email"));

        emailInput.sendKeys("emma");
        emailInput.sendKeys(Keys.ENTER);

        WebElement errorMessage = driver.findElement(By.cssSelector("#error-messages > p:nth-child(1)"));

        String errorMessageText = errorMessage.getText();

        assertEquals("Du måste ange en giltig e-postaddress!",errorMessageText,"Error message is not correct");
    }

    //Kontrollerar att villkors-boxen för nyhetsbrev inte är markerad.
    @Test
    void verifyElementSelection(){

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Acceptera alla']"));
        acceptCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        newsLetter.click();

        WebElement terms = driver.findElement(By.id("terms"));

        Assertions.assertFalse(terms.isSelected());
    }

    @AfterAll
    static void teardown() {driver.quit();
    }
}

