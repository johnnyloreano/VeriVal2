import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    WebDriver driver;

            @BeforeEach
            void setup(){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\John Peter\\Desktop\\VeriVal2\\Selenium\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                String baseUrl = "http://ec2-52-207-241-162.compute-1.amazonaws.com:8080";
                driver.get(baseUrl);
            }
    @Test
    public void CadastroAndLogin() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath( "//button[text() = 'Cadastrar']")).click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        By byValue;
        WebElement we;
        Thread.sleep(1000);
        byValue = By.id("name");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("João Pedro Laureano");
        byValue = By.id("email");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("laureano.pedrojoao@gmail.com");
        byValue = By.id("password");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("123456");
        driver.findElement(By.xpath( "//button[text() = 'Cadastrar' and @type = 'submit']")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        driver.close();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,60);

        String baseUrl = "http://ec2-52-207-241-162.compute-1.amazonaws.com:8080";
        driver.get(baseUrl);

        Thread.sleep(3000);

        byValue = By.id("ask-anchor");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).click();
        Thread.sleep(3000);

        byValue = By.id("email");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("laureano.pedrojoao@gmail.com");
        byValue = By.id("password");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("123456");

        driver.findElement(By.xpath( "//button[text() = 'Entrar' and @type = 'submit']")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        byValue = By.id("profile-anchor");
        we = driver.findElement(byValue);
        (new Actions(driver)).moveToElement(we).build().perform();

        byValue = By.xpath("//a[text() = 'Ver Perfil']");
        we = driver.findElement(byValue);
        (new Actions(driver)).moveToElement(we).perform();
        (new Actions(driver)).click().perform();
        Thread.sleep(3000);

        byValue = By.xpath("//h2[text() = 'João Pedro Laureano']");
        Boolean foundName = driver.findElements(byValue).size() > 0;

        assertTrue(foundName);
        driver.quit();
    }
    @Test
    public void TestQuestionCreate() throws InterruptedException {
        Thread.sleep(
                3000
        );
        WebDriverWait wait = new WebDriverWait(driver,60);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        By byValue;
        WebElement we;

        byValue = By.id("ask-anchor");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).click();
        Thread.sleep(3000);

        byValue = By.id("email");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("laureano.pedrojoao@gmail.com");
        byValue = By.id("password");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("123456");

        driver.findElement(By.xpath( "//button[text() = 'Entrar' and @type = 'submit']")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        driver.findElement(By.xpath( "//button[text() = 'Perguntar']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        byValue = By.id("title");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("Testando Selenium");
        byValue = By.id("description");
        wait.until(ExpectedConditions.elementToBeClickable(byValue)).sendKeys("Estou testando uma pergunta ?");

        byValue = By.id("topic");
        Select dropdown = new Select(driver.findElement(byValue));
        dropdown.selectByVisibleText("Administração");

        driver.findElement(By.xpath( "//button[text() = 'Criar Pergunta' and @type = 'submit']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        byValue = By.xpath("//p[text() = 'Testando Selenium']");
        Boolean foundName = driver.findElements(byValue).size() > 0;

        assertTrue(foundName);

        driver.quit();
    }
}