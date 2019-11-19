import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void validLogin(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement logInlink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        logInlink.click();

        WebElement user_name = driver.findElement(By.cssSelector("#email"));
        user_name.sendKeys("stan_frostmorn@yahoo.com");
        WebElement password_name = driver.findElement(By.cssSelector("#pass"));
        password_name.sendKeys("123456");

        WebElement logInButton = driver.findElement(By.cssSelector("#send2"));
        logInButton.click();





   // driver.quit();

    }


}
