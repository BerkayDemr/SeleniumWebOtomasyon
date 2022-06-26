import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddProductToTheCartAndClearTheCart extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;
    Log log = new Log();

    @Test
    @Order(1)
    public void searchProductAndGoToSecondPage(){
        homePage = new HomePage(driver);
        productsPage =new ProductsPage(driver);
        productDetailPage =new ProductDetailPage(driver);

        //Cookies bildirimi çıkarsa, cookies'ler kabul edilir.
        homePage.acceptCookies();
        //Arama çubuğunda verilen text aratılır.
        homePage.searchBox().search("bilgisayar");
        //Filtrelenmiş ürünler sayfasında sayfa numaralarının olduğu alana gidilir ve ikinci sayfaya geçilir.
        productsPage.goToSecondPage();
        Assertions.assertTrue(productsPage.checkIfSecondPage(),
                "The page is not second page!");
    }
    @Test
    @Order(2)
    public void selectProductAndAddTheCart(){
        homePage = new HomePage(driver);
        productsPage =new ProductsPage(driver);
        productDetailPage =new ProductDetailPage(driver);
        basketPage =new BasketPage(driver);
        //Açılan sayfada rastgele bir ürün seçilir
        productsPage.selectRandomProduct();
        //Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
        productDetailPage.productInfoLog();
        //Seçilen ürün sepete eklenir.
        productDetailPage.addToBasket();
        //Sepete gidilir.
        homePage.goToBasket();
        // Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        Assertions.assertTrue(basketPage.checkIfSamePrice(),
                "Product is not same price!");
    }
    @Test
    @Order(3)
    public void increaseQuantity(){
        basketPage =new BasketPage(driver);
        basketPage.increaseQuantity();
        if(!BasketPage.lastProduct){
            Assertions.assertTrue(basketPage.checkIfIncreaseQuantity(),
                    "Product quantity was not increase!");
        }
        else{
            log.info("Seçilen üründen bir tane bulunmaktadır");
        }

    }

    @Test
    @Order(4)
    public void clearTheBasket(){
        basketPage =new BasketPage(driver);
        basketPage.clearTheBasket();
        Assertions.assertTrue(basketPage.checkIfEmptyBasket(),
                "Basket is not empty!");
    }

}
