package framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.products.Product;
import framework.utils.DriverManager;
import framework.utils.MyExpectedCondition;

public class DetroitPage extends Page {//Страница Detroit
	
	@FindBy(xpath = "//h1[@class = 'page-title price-item-title']")
	private WebElement nameLabel;//Название
	
	@FindBy(xpath = "//span[@class = 'current-price-value']")
	private WebElement priceLabel;//Цена
	
	@FindBy(xpath = "//p[contains(text(), 'Игра для PS4 \"Detroit: Стать человеком\" ')]")
	private WebElement descriptionLabel;//Описание
	
	@FindBy(xpath = "//button[@class = 'button-ui button-ui_brand buy-btn btn-cart btn-lg button-ui_card button-ui_passive']")
	private WebElement buyButton;//Кнопка купить
	
	@FindBy(xpath = "//span[@class = 'cart-link__price']")
	private WebElement priceBasketLabel;//Цена корзины

	String name = new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(nameLabel)).getAttribute("innerHTML");

	int price = Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(priceLabel)).getAttribute("innerHTML").
			replaceAll("\\s+",""));
	
	String description = new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(descriptionLabel)).getAttribute("innerHTML");
	
	public Product DetroitProduct = new Product(name, price, description);
	
	public Product getDetroitProduct() {
		return DetroitProduct;
	}
	
	public DetroitPage detroitBuyButton() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(buyButton)).click();		
		
		return this;
	}

	public DetroitPage checkBasketPrice() {
		
		int sum = app.getPSPage().getPSProduct().getGarantPrice() + app.getDetroitPage().getDetroitProduct().getPrice();
		
		/*
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		int priceBasket = Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(priceBasketLabel)).getAttribute("innerHTML")
				.replaceAll("\\s+",""));		
				
						System.out.println(priceBasket);

				    	Assertions.assertEquals(priceBasket,sum,"Цены не совпадают");
		*/		
	
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(MyExpectedCondition.textToBePresentInElement(priceBasketLabel,sum));

		return this;
	}
	
	public BasketPage goBasketButton() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(priceBasketLabel)).click();	
		
		return app.getBasketPage();
	}	
}