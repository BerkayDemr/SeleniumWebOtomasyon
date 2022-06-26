import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage extends BaseMethods{
    By productPriceInTheBasketLocator =By.className("total-price");
    By productAmountLocator = By.tagName("select");
    By clearTheBasketLocator = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[6]/div[3]/div[2]/div[1]/div[3]/div/div[3]/div/div/a/i");
    By emptyBasketLocator = By.id("empty-cart-container");
    By productCountChangedLocator = By.className("success-toaster");
    By lastProductControlLocator = By.xpath("//*[@id=\"cart-item-533401612\"]/div[1]/div[4]/p");
    String ProductQuantity;
    public static Boolean lastProduct = false;
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public boolean checkIfSamePrice() {
        String ProductPriceInTheBasket = driver.findElement(productPriceInTheBasketLocator).getText();
        if((new String(ProductPriceInTheBasket).equals(ProductDetailPage.ProductPrice))){
            return true;
        }
        else{
            return false;
        }
    }

    public void increaseQuantity() {
        Select dropdown = new Select(driver.findElement(productAmountLocator));
        if(dropdown.getOptions().size() > 1){
            dropdown.selectByVisibleText("2");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(productCountChangedLocator));
            ProductQuantity = driver.findElement(productAmountLocator).getAttribute("value");
        }
        else{
            lastProduct = true;
        }

    }

    public boolean checkIfIncreaseQuantity() {
        if((new String(ProductQuantity).equals("2"))){
            return true;
        }
        else{
            return false;
        }
    }

    public void clearTheBasket() {
        click(clearTheBasketLocator,5);
    }

    public boolean checkIfEmptyBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emptyBasketLocator));

        if(isDisplayed(emptyBasketLocator)){
            return true;
        }
        else{
            return false;
        }
    }
}
