import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before

    public void initializationDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void validRegisterTest(){

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-link.skip-account"));
        accountButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("[title = Register]"));
        registerButton.click();
        String random = RandomStringUtils.randomAlphanumeric(5);

        WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
        firstName.sendKeys(random);
        WebElement lastName = driver.findElement(By.cssSelector("#lastname"));
        lastName.sendKeys(random);
        WebElement emailField = driver.findElement(By.cssSelector("#email_address"));
        emailField.sendKeys(random + "@testFastTrackIT.com");
        WebElement pwd = driver.findElement(By.cssSelector("#password"));
        pwd.sendKeys("parola");
        WebElement confirmpwd = driver.findElement(By.cssSelector("#confirmation"));
        confirmpwd.sendKeys("parola");

        WebElement lastRegisterButton = driver.findElement(By.cssSelector("[title = 'Register'].button"));
        lastRegisterButton.click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector("li span"));
        Assert.assertEquals(welcomeMessage.getText(),"Thank you for registering with Madison Island.");

    }

    @After
    public void browserCloser (){
        driver.quit();
    }

}
