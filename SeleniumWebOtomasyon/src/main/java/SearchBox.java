import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BaseMethods {
    By searchBoxLocator = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By submitButtonLocator = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button/span");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    //Verilen metni arayan metot.
    public void search(String text) {
        type(searchBoxLocator,text);
        click(submitButtonLocator,3);
    }
}