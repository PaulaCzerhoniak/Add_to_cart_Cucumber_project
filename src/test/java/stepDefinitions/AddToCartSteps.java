package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddToCartSteps {

    WebDriver driver;

    @Given("user opens Amazon")
    public void user_opens_amazon() {
        System.setProperty("webdriver.chrome.driver", "C://Users//folkl//Desktop//EPAM//Automation testing module//chromedriver_win32//chromedriver.exe/");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @And("chooses category")
    public void chooses_category() {
        WebElement toysGamesCategory = driver.findElement(By.xpath("//*[@aria-label='Toys & Games']"));
        toysGamesCategory.click();
    }

    @When("user adds product to the cart")
    public void user_adds_product_to_the_cart() throws InterruptedException {
        WebElement jenga = driver.findElement(By.xpath("//span[contains(text(), 'Hasbro Gaming: Jenga Classic Game')]"));
        jenga.click();
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.submit();
        Thread.sleep(3000);
    }

    @Then("user verifies that is in the cart")
    public void user_verifies_that_is_in_the_cart() {
        WebElement cart = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
        Assert.assertEquals(cart.getText(), "1");
        WebElement findItemAddedToCart = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertEquals(findItemAddedToCart.getText(), "Added to Cart");
        System.out.println("okay");
    }
}
