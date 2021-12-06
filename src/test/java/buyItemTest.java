import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buyItemTest {
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
    public void BuyItem() {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email")).sendKeys("deividas@gmail.com");
        chromeDriver.findElement(By.id("passwd")).sendKeys("deividas");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        chromeDriver.get("http://automationpractice.com/index.php");
        Actions action = new Actions(chromeDriver);
        WebElement webElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div"));
        action.moveToElement(webElement).moveToElement(chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"))).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]")));
//        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        WebElement webElement1 = chromeDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
        String checkingText = webElement1.getText();
        Assert.assertEquals("Your order on My Store is complete.", checkingText);
    }

    @After
    public void close() {
        chromeDriver.quit();
    }
}
