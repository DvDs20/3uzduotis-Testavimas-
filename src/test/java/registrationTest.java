import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class registrationTest {
    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;
    Random rand = new Random();

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        this.chromeDriver = new ChromeDriver();
        int timeForWaiting = 15;
        webDriverWait = new WebDriverWait(chromeDriver, timeForWaiting);
    }

    @Test
    public void RegisterTest() {
        int randomNumber = rand.nextInt((1000 - 1) + 1) + 1;
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email_create")).sendKeys("deividas"+randomNumber+"@gmail.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-creation_form")));
        chromeDriver.findElement(By.id("id_gender1")).click();
        chromeDriver.findElement(By.id("customer_firstname")).sendKeys("Deividas");
        chromeDriver.findElement(By.id("customer_lastname")).sendKeys("Kvietkauskas");
        chromeDriver.findElement(By.id("passwd")).sendKeys("deividas");
        chromeDriver.findElement(By.id("days")).click();
        new Select(chromeDriver.findElement(By.id("days"))).selectByIndex(17);
        chromeDriver.findElement(By.id("months")).click();
        new Select(chromeDriver.findElement(By.id("months"))).selectByIndex(1);
        chromeDriver.findElement(By.id("years")).click();
        new Select(chromeDriver.findElement(By.id("years"))).selectByIndex(22);
        chromeDriver.findElement(By.id("address1")).sendKeys("Gražuolių g. 8");
        chromeDriver.findElement(By.id("city")).sendKeys("Vilnius");
        chromeDriver.findElement(By.id("id_state")).click();
        new Select(chromeDriver.findElement(By.id("id_state"))).selectByIndex(14);
        chromeDriver.findElement(By.id("postcode")).sendKeys("32514");
        chromeDriver.findElement(By.id("id_country")).click();
        new Select(chromeDriver.findElement(By.id("id_country"))).selectByIndex(1);
        chromeDriver.findElement(By.id("phone_mobile")).sendKeys("+37061648265");
        chromeDriver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"my-account\"]")));
        WebElement webElement = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        String checkingText = webElement.getText();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", checkingText);
    }

    @Test
    public void RegistrationWithBadCredentials() {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email_create")).sendKeys("deividasgmail.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]")));
        WebElement expectedErrorElement = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li"));
        String expectedErrorText = expectedErrorElement.getText();
        Assert.assertEquals("Invalid email address.", expectedErrorText);
    }

    @After
    public void Close() {
        chromeDriver.quit();
    }
}
