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

import java.time.Duration;

public class contactUsTest {
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
    public void contactUs() {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div/select")).click();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        new Select(chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div/select"))).selectByIndex(1);
        chromeDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("deividas@gmail.com");
        WebElement uploadElement = chromeDriver.findElement(By.id("fileUpload"));
        uploadElement.sendKeys("C:\\Users\\deivi\\Documents\\Programų sistemų testavimas\\3uzduotis\\src\\main\\resources\\download.jpg");
        chromeDriver.findElement(By.id("message")).sendKeys("Hello");
        chromeDriver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span")).click();
        WebElement webElement = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        String checkingText = webElement.getText();

        Assert.assertEquals("Your message has been successfully sent to our team.", checkingText);
    }

    @After
    public void close() {
        chromeDriver.quit();
    }
}
