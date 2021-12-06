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


public class addToCartTest {
    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;
    loginTest loginTest = new loginTest();

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        this.chromeDriver = new ChromeDriver();
        this.chromeDriver.manage().window().maximize();
        int timeForWaiting = 15;
        webDriverWait = new WebDriverWait(chromeDriver, timeForWaiting);
    }

    @Test
    public void AddToCartWithoutLogin() {

        chromeDriver.get("http://automationpractice.com/index.php");
        Actions action = new Actions(chromeDriver);

        //Product without discount
        WebElement webElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div"));
        action.moveToElement(webElement).moveToElement(chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"))).click().build().perform();
        WebElement firstProduct = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a"));
        String firstProductTitle = firstProduct.getText();
        WebElement firstProductPriceByElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/div[2]/span"));
        String firstProductPrice = firstProductPriceByElement.getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]")));
        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();

        //Product with discount
        WebElement webElement1 = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div"));
        action.moveToElement(webElement1).moveToElement(chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]"))).click().build().perform();
        WebElement secondProduct = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/h5/a"));
        String secondProductTitle = secondProduct.getText();
        WebElement secondProductPriceByElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/div[2]/span[1]"));
        String secondProductPrice = secondProductPriceByElement.getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]")));
        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();


        WebElement firstProductTitleInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/p/a"));
        String firstProductTitleInCart = firstProductTitleInCartByElement.getText();
        WebElement secondProductTitleInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_5_19_0_0\"]/td[2]/p/a"));
        String secondProductTitleInCart = secondProductTitleInCartByElement.getText();

        WebElement firstProductPriceInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"total_product_price_1_1_0\"]"));
        String firstProductPriceInCart = firstProductPriceInCartByElement.getText();
        WebElement secondProductPriceInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"total_product_price_5_19_0\"]"));
        String secondProductPriceInCart = secondProductPriceInCartByElement.getText();

        Assert.assertEquals(firstProductTitle, firstProductTitleInCart);
        Assert.assertEquals(firstProductPrice, firstProductPriceInCart);
        Assert.assertEquals(secondProductTitle, secondProductTitleInCart);
        Assert.assertEquals(secondProductPrice, secondProductPriceInCart);
    }

    @Test
    public void AddToCartWithLogin() {

        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.linkText("Sign in")).click();
        chromeDriver.findElement(By.id("email")).sendKeys("deividas@gmail.com");
        chromeDriver.findElement(By.id("passwd")).sendKeys("deividas");
        chromeDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).click();

        Actions action = new Actions(chromeDriver);

        //Product without discount
        WebElement webElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div"));
        action.moveToElement(webElement).moveToElement(chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"))).click().build().perform();
        WebElement firstProduct = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a"));
        String firstProductTitle = firstProduct.getText();
        WebElement firstProductPriceByElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/div[2]/span"));
        String firstProductPrice = firstProductPriceByElement.getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]")));
        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();

        //Product with discount
        WebElement webElement1 = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div"));
        action.moveToElement(webElement1).moveToElement(chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]"))).click().build().perform();
        WebElement secondProduct = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/h5/a"));
        String secondProductTitle = secondProduct.getText();
        WebElement secondProductPriceByElement = chromeDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/div[2]/span[1]"));
        String secondProductPrice = secondProductPriceByElement.getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]")));
        chromeDriver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();


        WebElement firstProductTitleInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_1_1_0_610239\"]/td[2]/p/a"));
        String firstProductTitleInCart = firstProductTitleInCartByElement.getText();
        WebElement secondProductTitleInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_5_19_0_610239\"]/td[2]/p/a"));
        String secondProductTitleInCart = secondProductTitleInCartByElement.getText();

        WebElement firstProductPriceInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_price_1_1_610239\"]/span"));
        String firstProductPriceInCart = firstProductPriceInCartByElement.getText();
        WebElement secondProductPriceInCartByElement = chromeDriver.findElement(By.xpath("//*[@id=\"product_price_5_19_610239\"]/span[1]"));
        String secondProductPriceInCart = secondProductPriceInCartByElement.getText();

        Assert.assertEquals(firstProductTitle, firstProductTitleInCart);
        Assert.assertEquals(firstProductPrice, firstProductPriceInCart);
        Assert.assertEquals(secondProductTitle, secondProductTitleInCart);
        Assert.assertEquals(secondProductPrice, secondProductPriceInCart);
    }


    @After
    public void close() {
        chromeDriver.quit();
    }
}
