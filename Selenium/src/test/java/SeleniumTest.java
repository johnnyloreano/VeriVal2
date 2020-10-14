import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {


    WebDriver driver;

            @BeforeEach
            void setup(){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\John Peter\\Desktop\\VeriVal2\\Selenium\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                String baseUrl = "http://google.com.br";
                driver.get(baseUrl);
                driver.findElement(By.name("q")).sendKeys("calculadora");
                driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
                WebDriverWait wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwmcwd")));
            }
    @Test
    public void Test1() throws InterruptedException {
        driver.findElement(By.xpath( "//div[text() = '(']")).click();
        driver.findElement(By.xpath( "//div[text() = '5']")).click();
        driver.findElement(By.xpath( "//div[text() = '×']")).click();
        driver.findElement(By.xpath( "//div[text() = '3']")).click();
        driver.findElement(By.xpath( "//div[text() = ')']")).click();
        driver.findElement(By.xpath( "//div[text() = '+']")).click();
        driver.findElement(By.xpath( "//div[text() = '√ ']")).click();
        driver.findElement(By.xpath( "//div[text() = '3']")).click();
        driver.findElement(By.xpath( "//div[text() = '6']")).click();
        driver.findElement(By.xpath( "//div[text() = ')']")).click();
        driver.findElement(By.xpath( "//div[text() = '=']")).click();
        String result = driver.findElement(By.id( "cwos")).getText();
        Thread.sleep(6000);
        assertEquals("21",result);

        driver.quit();
    }
    @Test
    public void Test2() throws InterruptedException {
        driver.findElement(By.xpath( "//div[text() = 'log']")).click();
        driver.findElement(By.xpath( "//div[text() = '−']")).click();
        driver.findElement(By.xpath( "//div[text() = '2']")).click();
        driver.findElement(By.xpath( "//div[text() = '=']")).click();
        String result = driver.findElement(By.id( "cwos")).getText();
        Thread.sleep(6000);
        assertEquals("Error",result);

        driver.quit();
    }
}
