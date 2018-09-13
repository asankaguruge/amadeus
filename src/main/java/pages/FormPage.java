package pages;

/**
 * Created by asanka on 2018-09-01.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.*;

/**
 * Created by asanka on 2018-07-15.
 */
public class FormPage {

    //Element locators
    //Fly from autocomplete field
    private static String flyFromLocator = "//*[@name='flying-from']/div/input[@id='autocomplete-input']";
    //Fly to autocomplete field
    private static String flyToLocator = "//*[@name='flying-to']/div/input[@id='autocomplete-input']";
    //Search button
    private static String searchButtonLocator = "//input[@value='Search']";
    //Flight price
    private static String flightPriceLocator = ".flight-price.text-6";

    public static void submitForm(WebDriver driver) throws InterruptedException {

        //Initializing elements
        WebElement flyFrom = driver.findElement(By.xpath(flyFromLocator));
        WebElement flyTo = driver.findElement(By.xpath(flyToLocator));
        WebElement searchButton = driver.findElement(By.xpath(searchButtonLocator));

        sleep(2000);

        flyFrom.click();
        flyFrom.clear();
        flyFrom.sendKeys("cmb");
        sleep(2000);
        flyFrom.sendKeys(Keys.TAB);

        flyTo.click();
        flyTo.clear();
        flyTo.sendKeys("mel");
        sleep(2000);
        flyTo.sendKeys(Keys.TAB);
        sleep(2000);
        searchButton.sendKeys(Keys.RETURN);

    }

    public static void waitForResults(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(flightPriceLocator)));
    }

    public static String getPriceOfFirstListing(WebDriver driver)
    {
        WebElement flightPrice = driver.findElement(By.cssSelector(flightPriceLocator));
        return flightPrice.getText();
    }
}

