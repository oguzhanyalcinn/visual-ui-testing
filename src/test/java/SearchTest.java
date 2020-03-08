import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    By searchBar = By.xpath("//input[@aria-label='Zoek']");

    @Test
    public void checkSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys("Hoodie");
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
        validateWindow();
    }
}
