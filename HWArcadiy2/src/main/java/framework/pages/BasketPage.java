package framework.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.utils.DriverManager;

public class BasketPage extends Page{//Страница корзины
	
	@FindBy(xpath = "//span[@class = 'base-ui-radio-button__icon base-ui-radio-button__icon_checked']")
	private WebElement garantLabelTwoYearLabel;//Гарантия
	
	@FindBy(xpath = "//span[@class = 'price__current']")
	private List<WebElement> priceProductLabel;//Цены
		
	@FindBy(xpath = "//button[@data-commerce-target= '759ae0e1-2007-11e8-9dc5-00155d03330d' and @data-commerce-action = 'CART_REMOVE']")
	private WebElement deleteDetroitButton;//Кнопка удаления Detroit
	
	@FindBy(xpath = "//a[@class= 'cart-items__product-name-link']")
	private List<WebElement> basketProductsLabel;//Проверка удаления Detroit
	
	@FindBy(xpath = "//span[@class= 'cart-link__price']")
	private WebElement basketPriceLabel;//Цена корзины
	
	@FindBy(xpath = "//button[@data-commerce-target= '040b4001-3e6b-11ea-a20f-00155d03332b' and @data-commerce-action = 'CART_ADD']")
	private WebElement addPSButton;//Добавить PS
	
	@FindBy(xpath = "//span[@class= 'restore-last-removed']")
	private WebElement returnDetroitButton;//Вернуть Detroit
	
	public BasketPage checkGarantPS() {
		String garantPS4String = new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(garantLabelTwoYearLabel)).getAttribute("innerHTML").trim();

    	Assertions.assertEquals(garantPS4String,"+ 24  мес.","Гарантия не совпадает");
    	
    	return this;
	}
	
    public BasketPage checkPriceProducts(int priceProduct) {
    	
        for (WebElement priceElement : priceProductLabel) {
        	
        	int price = Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
        			.until(ExpectedConditions.elementToBeClickable(priceElement)).getAttribute("innerHTML").
        			replaceAll("\\s+","").replaceAll("<iclass=\"ru-currency-iconru-currency-icon_bold\"></i>", ""));
        	
            if (price == priceProduct) {
                return this;
            }
        }
        Assertions.fail("Такой цены нет: " + priceProduct);
      return this;
    }

	public BasketPage deleteDetroit() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(deleteDetroitButton)).click();	
		return this;
	}
	
	
	public BasketPage checkDetroitInBasket(String detroitName) {
		
        for (WebElement nameElement : basketProductsLabel) {
        	
        	String name = new WebDriverWait(DriverManager.getDriver(), 10)
        			.until(ExpectedConditions.elementToBeClickable(nameElement))
        			.getAttribute("innerHTML");
        	        	
           if (name == detroitName) {
                Assertions.fail("Товар все еще в корзине: " + detroitName);
                return this;
            }
        }
      return this;  
	}
	
	public BasketPage checkBasketPrice(int price) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    	int priceBasket = Integer.parseInt(new WebDriverWait(DriverManager.getDriver(), 10)
    			.until(ExpectedConditions.elementToBeClickable(basketPriceLabel)).getAttribute("innerHTML").
    			replaceAll("\\s+",""));
    	
    	Assertions.assertEquals(priceBasket, price,"Цены не совпадают");
    	
    	return this;
	}
	
	public BasketPage addTwoPS() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(addPSButton)).click();	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(addPSButton)).click();
		
		return this;      	
	}
	
	public BasketPage returnDetroit() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(returnDetroitButton)).click();
		
		return this;
	}	
}