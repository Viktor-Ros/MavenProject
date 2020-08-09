package framework.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.managers.DriverManager;
import framework.utils.MethodsUtils;
import framework.utils.MyExpectedCondition;
import io.qameta.allure.Step;

public class ContributionPage extends Page{
	
	@FindBy(xpath = "//label[@class='calculator__currency-field']")
	private List<WebElement> currencyList;//Список валют
	
	@FindBy(xpath = "//div[@class='calculator__slide-section']")
	private List<WebElement> paramList;//Список опций вклада
	
	@FindBy(xpath = "//select[@class='calculator__slide-input js-slide-value']")
	private WebElement selectMonth;//Выбор срока
	
	@FindBy(xpath = "//label[@class='calculator__check-block']")
	private List<WebElement> additionalOptionsCheckBoxList;//Список дополнительных опций
	
	@FindBy(xpath = "//tr[@class='calculator__dep-result-table-row']")
	private List<WebElement> checkParamList;//Список параметров для проверки: Начислено и Пополнение
	
	@FindBy(xpath = "//div[@class='calculator__dep-result']")
	private WebElement checkParam;//Параметр для проверки: К снятию
	
	/**
	 * 
	 * Выбор вылюты
	 */
	
	@Step("Выбор валюты")
	public ContributionPage selectCurrency(String name) {
		
		for(WebElement element : currencyList) {
			
			WebElement nameElement = element.findElement(By.xpath(".//span[@class='calculator__currency-field-text']"));
			
			String nameLabel = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(nameElement)).getAttribute("innerHTML");
			
			if(name.equals(nameLabel)) {
				
				new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(element)).click();
				
				return this;
			}
		}
		
		Assert.fail("Такой валюты нет: " + name);

		return this;
	}

	
	/**
	 * 
	 * Ввод параметров вклада
	 */
	
	@Step("Выбор параметра вклада")
	public ContributionPage setContributionParam(String name, String value) {
		
		for(WebElement element : paramList) {
			
			WebElement label = element.findElement(By.xpath(".//label[@class='calculator__slide-input-label']"));
			
			String labelName = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(label)).getAttribute("innerHTML");
			
			if(name.equals(labelName) && !name.equals("На срок")) {
				
				WebElement input = element.findElement(By.xpath(".//input[@class='calculator__slide-input currency-input js-slide-value']"));
				
				new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(input)).click();
				
				input.sendKeys(value);
	
				return this;
			}
		}
		
		if(name.equals("На срок")) {
			
			Select select = new Select(selectMonth);
			select.selectByVisibleText(value + " месяцев");
			return this;
		}
		
		Assert.fail("Такой опции нет: " + name);
		
		return this;
	}
	
	/**
	 * 
	 * Выбор дополнительной опции
	 */
	
	@Step("Выбор дополнительной опции")
	public ContributionPage additionalOptionsOn(String name) {
		
		for(WebElement element : additionalOptionsCheckBoxList) {
			
		
		WebElement label = element.findElement(By.xpath(".//span[@class='calculator__check-text']"));
		
		String nameLabel = new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(label)).getAttribute("innerHTML");
		
		
			if(name.equals(nameLabel)) {
				WebElement checkBox = element.findElement(By.xpath(".//span[@class='calculator__check-block-input']"));
				checkBox.click();
				return this;
				
			}
		}
		
		Assert.fail("Такой дополнительной опции нет: " + name);

		return this;
	}

	/**
	 * 
	 * Проверка полей
	 */
	
	@Step("Проверка поля")
	public ContributionPage checkParametr(String name, String value) {
		
		for(WebElement element : checkParamList) {
			
			WebElement nameElement = element.findElement(By.xpath(".//td[@class='calculator__dep-result-table-cell calculator__dep-result-table-cell_title']"));
			
			String nameLabel = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(nameElement)).getAttribute("innerHTML");
			
			if(name.equals(MethodsUtils.returnLetters(nameLabel))) {
				
				WebElement valueElement = element.findElement(By.xpath(".//td[@class='calculator__dep-result-table-cell calculator__dep-result-table-cell_val']"));
				
				boolean bool = new WebDriverWait(DriverManager.getDriver(), 10)
				.until(MyExpectedCondition.textToBePresentInElement(valueElement,value));
				
				String valueLabel = new WebDriverWait(DriverManager.getDriver(), 10)
						.until(ExpectedConditions.elementToBeClickable(valueElement)).getAttribute("innerHTML");
				
				if(bool) {
					
					Assert.assertEquals("Значения " + name + " не совпадают", value, MethodsUtils.returnNumber(valueLabel));
					return this;
					
				}	
			}	
		}
		
		WebElement label = checkParam.findElement(By.xpath(".//div[@class='calculator__dep-result-label']"));
		
		String nameLabel = new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(label)).getAttribute("innerHTML");
				
		if(name.equals(MethodsUtils.returnLetters(nameLabel))) {
			
			WebElement labelValue = checkParam.findElement(By.xpath(".//div[@class='calculator__dep-result-value']"));
			
			String valueLabel = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(labelValue)).getAttribute("innerHTML");
						
			Assert.assertEquals("Значения " + name + " не совпадают", value, MethodsUtils.returnNumber(valueLabel));
			return this;
		}
		
		Assert.fail("Такого параметра нет: " + name);

		return this;
	}
}
