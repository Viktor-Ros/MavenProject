package framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.products.Product;
import framework.utils.DriverManager;

public class PSPage extends Page{// Страница PS

	@FindBy(xpath = "//h1[@class = 'page-title price-item-title']")
	private WebElement nameLabel;//Название
	
	@FindBy(xpath = "//span[@class = 'current-price-value']")
	private WebElement priceLabel;//Цена
	
	@FindBy(xpath = "//p[contains(text(), 'Игровая приставка')]")
	private WebElement descriptionLabel;//Описание
	
	@FindBy(xpath = "//option[@value= '2']")
	private WebElement garantLabelTwoYearSelect;//Гарантия 2 года
	
	@FindBy(xpath = "//button[@class = 'button-ui button-ui_brand buy-btn btn-cart btn-lg button-ui_card button-ui_passive']")
	private WebElement buyButton;//Кнопка купить
	
	@FindBy(xpath = "//input[@class = 'ui-input-search__input ui-input-search__input_presearch' and @placeholder= 'Поиск по сайту']")
	private WebElement searchLabel;//Поле поиска

	private String name = new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(nameLabel)).getAttribute("innerHTML");

	private int price = Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(priceLabel)).getAttribute("innerHTML")
			.replaceAll("\\s+",""));
	
	private String description = new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(descriptionLabel)).getAttribute("innerHTML");
	
	private Product ps4SlimBlackProduct = new Product(name, price, description);
	
	public PSPage garantLabelPS4Select() {
	
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(garantLabelTwoYearSelect)).click();
		
		price += Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(garantLabelTwoYearSelect))
				.getAttribute("data-additional-price"));
		
		ps4SlimBlackProduct.setGarantPrice(price);
		
		return this;
	}
	
	public Product getPSProduct() {
		return ps4SlimBlackProduct;
	}
	
	public PSPage buyPS4Button() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
	
		return this;
	}
	
	public DetroitPage searchDetroit(){

		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(searchLabel)).sendKeys("Detroit");
		
		searchLabel.sendKeys(Keys.ENTER);	
		
		return app.getDetroitPage();
	}
}