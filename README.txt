# SeleniumWebOtomasyon
 E-ticaret web sitesinde sepete ürün ekleme.

Proje Açıklaması

- Proje Maven projesi olarak, Java programlama dilinde yazılmıştır.
- Selenium, JUnit ve Log4J kütüphanelerini kullanılmıştır.
- Proje OOP (Object Oriented Programming) prensiplerine uygun yazılmıştır.
- Page Object Pattern kullanılmıştır.

Senaryo Adımları

- www.gittigidiyor.com sitesi açılır.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir
