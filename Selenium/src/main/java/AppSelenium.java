import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\John Peter\\Desktop\\VeriVal2\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://google.com.br";

        driver.get(baseUrl);


        WebElement searchBar = driver.findElement(By.name("q"));

        System.out.println(searchBar);
        driver.close();
    }
}
