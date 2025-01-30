package seleniumdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumDriver {

    private final static String CHROME_DRIVER_FULL_PATH = ".idea/Driver/windows/chromedriver.exe";


    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FULL_PATH);
        driver = new ChromeDriver();
    }




    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
