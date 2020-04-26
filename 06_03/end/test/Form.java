import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

// main method - test
// main page object???
public class Form {
    //name of method with (parameter)
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/anyaturcu/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        submitForm(driver);
        waitForAlertBanner(driver);
        // asserts are to be left in main test
        assertEquals("The form was successfully submitted!", getAlertBannerText(driver));
        driver.quit();
    }

    // method to submit form details
    public static void submitForm(WebDriver driver)//name of method with (parameter)
    {
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("05/28/2019");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
    // wait for msg to show
    public static void waitForAlertBanner(WebDriver driver)//name of method with (parameter)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
    }
    // extract msg text
    public static String getAlertBannerText(WebDriver driver)//name of method with (parameter)
    {
        return driver.findElement(By.className("alert")).getText();
    }
}
