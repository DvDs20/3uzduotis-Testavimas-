import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class filteringTest {
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
    public void Filtering() throws Exception {
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_1\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_15\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]")).click();

        WebElement firstCheckbox = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/form/div/div[2]/ul/li[1]/div/span/input"));
        WebElement secondCheckbox = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/form/div/div[3]/ul/li[6]/input"));
        WebElement slider = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/form/div/div[10]/ul/div/div/a[2]"));

        boolean firstCheckboxBool = false;
        boolean secondCheckboxBool = false;
        boolean sliderBool = false;

        if (firstCheckbox.isSelected()) {
            firstCheckboxBool = true;
        }
        else {
            throw new Exception("Size is not selected");
        }

        if (secondCheckbox.isSelected()) {
            secondCheckboxBool = true;
        }
        else {
            throw new Exception("Color is not selected");
        }

        if (slider.isSelected()) {
            sliderBool = true;
        }
        else {
            throw new Exception("Price is not selected");
        }


        Assert.assertTrue(firstCheckboxBool);
        Assert.assertTrue(secondCheckboxBool);
        Assert.assertTrue(sliderBool);
    }

    @After
    public void close() {
        chromeDriver.quit();
    }
}
