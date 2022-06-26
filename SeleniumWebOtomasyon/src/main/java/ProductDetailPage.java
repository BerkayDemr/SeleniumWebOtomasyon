import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BaseMethods {
    By productInfoLocator = By.id("sp-title");
    By productPriceLocator = By.id("sp-price-highPrice");
    By addToBasketLocator = By.id("add-to-basket");
    public static String ProductPrice;
    Log log = new Log();
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void productInfoLog() {
        String ProductName = driver.findElement(productInfoLocator).getText();
        ProductPrice = driver.findElement(productPriceLocator).getText();
        log.info("Ürün Adı : " + ProductName);
        log.info("Ürün Fiyatı : " + ProductPrice);
    }

    public void addToBasket() {
        click(addToBasketLocator,5);
    }
}
