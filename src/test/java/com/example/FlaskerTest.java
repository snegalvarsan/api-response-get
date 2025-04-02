import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlaskerTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageTitle() {
        driver.get("http://localhost:8000");
        String title = driver.getTitle();
        assertEquals("Home Page", title);
        System.out.println("Expected: Home Page");
        System.out.println("Actual: " + title);
    }

    @Test
    public void testFormSubmission() {
        driver.get("http://localhost:8000");
        WebElement inputField = driver.findElement(By.name("name"));
        inputField.sendKeys("Test User");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals("Hello, Test User!", resultText.getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
