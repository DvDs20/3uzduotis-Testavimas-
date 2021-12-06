import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginTest {
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
    public void LoginTest() {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email")).sendKeys("deividas@gmail.com");
        chromeDriver.findElement(By.id("passwd")).sendKeys("deividas");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"my-account\"]")));
        WebElement webElement = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        String checkingText = webElement.getText();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", checkingText);
    }

    @After
    public void close() {
        chromeDriver.quit();
    }

}
