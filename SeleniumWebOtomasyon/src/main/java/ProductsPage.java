import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class ProductsPage extends BaseMethods{
    By changePageAreaLocator = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul");
    By secondPageButtonLocator = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a");
    By secondPageElementLocator = By.xpath("//*[@id=\"2\"]/li[1]/article/div[2]/a");
    By secondPageProductQuantityLocator = By.xpath("//ul[@class='sc-1yvp483-0 pmyvb0-1 dTGwmm gDmzzR card-row']/li[@class='sc-1nx8ums-0 dyekHG']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void goToSecondPage() {
        scrollToElement(changePageAreaLocator);
        click(secondPageButtonLocator,5);
    }
    public boolean checkIfSecondPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(secondPageElementLocator));
        String PageNumberTwo = driver.findElement(secondPageButtonLocator).getAttribute("aria-current");

        if(new String(PageNumberTwo).equals("true")){
            return true;
        }
        else{
            return false;
        }
    }

    public void selectRandomProduct() {
        Random rand = new Random();

        int secondPageProductQuantity = driver.findElements(secondPageProductQuantityLocator).size();
        //Sıfır ile sayfadaki ürün adedi eksi bir arasında random sayı üretir.(Örn: Sayfada 32 ürün varsa 0-31 arası(0 ile 31 de dahil) random sayı üretir)
        int randomSecondPageProductIndex = rand.nextInt(secondPageProductQuantity) + 1;
        String productRandomIndex = String.valueOf(randomSecondPageProductIndex);
        By randomProductLocator = By.xpath("//*[@id=\"2\"]/li["+productRandomIndex+"]/article/div[2]/a");

        scrollToElement(randomProductLocator);

        click(randomProductLocator,5);
    }
}
