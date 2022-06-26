import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BaseMethods {

    By acceptCookiesLocator = By.xpath("//*[@id=\"__next\"]/main/div[3]/section[1]/section[2]/a/span");
    By goToBasketLocator = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");
    By moveToElementLocator = By.className("dIB");
    SearchBox searchBox;
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public void acceptCookies() {
        List<WebElement> list_acceptCookiesLocator = driver.findElements(acceptCookiesLocator);
        if (list_acceptCookiesLocator.size() != 0) {
            click(acceptCookiesLocator, 3);
        }
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public void goToBasket() {
        moveToElement(moveToElementLocator);
        click(goToBasketLocator,5);
    }
}
