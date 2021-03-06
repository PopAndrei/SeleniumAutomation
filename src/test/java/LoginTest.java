import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initializeDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest(){
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
        Assert.assertTrue(logInButton.isDisplayed());
        logInButton.click();

        WebElement welcomeMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));

        Assert.assertEquals(welcomeMessage.getText(),"Hello, Andrei Pop!");


    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
