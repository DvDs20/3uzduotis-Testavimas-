import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class deletionFunctionTest {
    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        this.chromeDriver = new ChromeDriver();
        this.chromeDriver.manage().window().maximize();
        int timeForWaiting = 15;
        webDriverWait = new WebDriverWait(chromeDriver, timeForWaiting);
    }

    @Test
    public void DeleteWishlistTest() {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email")).sendKeys("deividas@gmail.com");
        chromeDriver.findElement(By.id("passwd")).sendKeys("deividas");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("test");
        chromeDriver.findElement(By.xpath("//*[@id=\"submitWishlist\"]")).click();
        chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[6]/a")).click();
        Alert alert = chromeDriver.switchTo().alert();
        alert.accept();
        boolean tableElementIsDisplayed;
        tableElementIsDisplayed = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]")).isDisplayed();
        Assert.assertTrue(tableElementIsDisplayed);
    }

    @After
    public void close() {
        chromeDriver.quit();
    }
}
