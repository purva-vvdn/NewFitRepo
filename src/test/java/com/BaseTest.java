import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Open the desired website
        driver.get("https://www.google.com");
    }

    @Test
    public void googleSearchTest() {
        // Locate the search box
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // Enter a search term
        searchBox.sendKeys("Selenium WebDriver");
        
        // Submit the search form
        searchBox.submit();
        
        // Wait for the results to load and verify the title contains the search term
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Selenium WebDriver"));
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
