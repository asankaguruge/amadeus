/**
 * Created by asanka on 2018-09-01.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Code_Coverage/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amadeus.net/home");

        try {

            FormPage formPage = new FormPage();
            formPage.submitForm(driver);

            formPage.waitForResults(driver);

            //Test if the correct price is displayed
            assertEquals("Rs175,082", formPage.getPriceOfFirstListing(driver));

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }




}
