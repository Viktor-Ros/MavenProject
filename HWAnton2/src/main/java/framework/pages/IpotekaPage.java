package framework.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.managers.DriverManager;
import framework.utils.MethodsUtils;

/**
 * Страница ипотеки
 */

public class IpotekaPage extends Page{	
	

	@FindBy(xpath = "//iframe[@title='Основной контент']")
	private WebElement inputsLabel;//Рамка с полями
	
	@FindBy(xpath = "//div[@class = 'style_loanConditionItem__1XKyE']")
	private List<WebElement> inputLabelList;//Лист с полями
	
	@FindBy(xpath = "//label[@class = 'dc-switch-2-3-2 dc-switch--checked-2-3-2']")
	private WebElement sberCard;//Выбор сберовской карты
	
	@FindBy(xpath = "//span[@class = 'style_title__3IybU style_font__10HUw']")
	private WebElement proofIncomeTextLabel;//Есть возможность подтвердить доход справкой
	
	@FindBy(xpath = "//div[@class= 'styles_item__1SP5M']")
	private List<WebElement> addDiscount;//Выбор доп. скидки
	
	@FindBy(xpath = "//li[@class = 'styles_listItem__2oHcd']")
	private List<WebElement> checkElement;
	
	{
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", inputsLabel);
		DriverManager.getDriver().switchTo().frame(inputsLabel);
	}
	
	/**
	 * Ввод параметров ипотеки
	 */
	
	public IpotekaPage inputIpotekaParam(String nameParam, String valueParam) {
					
		for(WebElement element : inputLabelList) {
			
			WebElement elementLabel = element.findElement(By.xpath(".//div[@class = 'dc-input__input-container-4-6-1']"));

			String nameLabel = new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(elementLabel)).getAttribute("innerHTML")
			.replaceAll("(?u)[^а-яА-я ]","").trim();
			
			if(nameParam.equals(nameLabel)) {
				
				WebElement elementInput = element.findElement(By.xpath(".//input[@class = 'dc-input__input-4-6-1']"));

				elementInput.click();
				elementInput.sendKeys(Keys.CONTROL, "a");
				elementInput.sendKeys(Keys.DELETE);
				elementInput.sendKeys(valueParam);
			}	
		}			
		return this;
	}
	
	/**
	 * Отключение карты сбербанка
	 */
	
	public IpotekaPage cardSberOff() {
				
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(sberCard)).click();
		 
		return this;
	}

	/**
	 * Проверка поля: "есть возможность подтвердить доход справкой"
	 */
	
	public IpotekaPage proofIncomeTextVisible() {
				
		boolean proofIncomeTextVisible = new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.visibilityOf(proofIncomeTextLabel)).isEnabled();
		
		Assertions.assertTrue(proofIncomeTextVisible, "Поле не видно");
		
		return this;
	}
	
	/**
	 * Выбор скидки: "молодая семья"
	 */
	
	public IpotekaPage discountOn(String nameDiscount) {
				
		for(WebElement element : addDiscount) {
			
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("arguments[0].scrollIntoView();", element);
			
			String elementTitle = element.findElement(By.xpath(".//span[@class= 'styles_title__1ZfZY']"))
					.getAttribute("innerHTML");
			
			if(elementTitle.equals(nameDiscount)) {
				
				WebElement elementDiscount = element.findElement(By.xpath(".//label[@class= 'dc-switch-2-3-2']"));
				
				JavascriptExecutor jsDis = (JavascriptExecutor) DriverManager.getDriver();
				jsDis.executeScript("arguments[0].click();", elementDiscount);
				
				return this;
			}	 
		}
		
        Assertions.fail("Такой скидки нет: " + nameDiscount);

		return this;
	}
	
	/**
	 * Проверка параметров ипотеки
	 */
	
	public IpotekaPage checkValue(String name, String value) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for(WebElement element : checkElement) {
			
		String elementValue = element.findElement(By.xpath(".//span[@data-e2e-id]"))
					.getAttribute("innerHTML");
			
			String elementName = element.findElement(By.xpath(".//span[@class = 'style_label__270Um']"))
					.getAttribute("innerHTML");
			
			if(elementName.equals(name)) {
								
				Assertions.assertEquals(value,MethodsUtils.returnNumber(elementValue),"Значение: " + elementName + " не совпадает");
				return this;
			}
		}
		
		Assertions.fail("Поле " + name + " не найдено");
		
		return this;
	}	
}

