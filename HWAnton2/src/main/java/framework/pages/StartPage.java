package framework.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.managers.DriverManager;

/**
 * Стартовая страница
 */

public class StartPage extends Page{
		
	@FindBy(xpath = "//span[@class = 'lg-menu__text']")
	private List<WebElement> serviceTypeLabelList;//Типы услуг
	
	@FindBy(xpath = "//a[@class = 'lg-menu__sub-link']")
	private List<WebElement> serviceLabelList;//Услуги
		
	/**
	 * Выбор раздела
	 */
	
	public void selectTypeService(String serviceTypeName) {
		
		for (WebElement element : serviceTypeLabelList) {
        	
        	String elementName = new WebDriverWait(DriverManager.getDriver(), 10)
        			.until(ExpectedConditions.elementToBeClickable(element))
        			.getAttribute("innerHTML");
        	        	
           if (elementName.equals(serviceTypeName)) {
        	   
           	Actions insurAction = new Actions(DriverManager.getDriver());
        	insurAction.moveToElement(element).build().perform();
            } 	
        }
	}
	
	/**
	 * Выбор услуги
	 */
	
	public void selectService(String serviceName) {
		
		for (WebElement element : serviceLabelList) {
        	
        	String elementName = element.getAttribute("innerHTML");

           if (elementName.contains(serviceName)) {
        	           	           	   
        	   new WebDriverWait(DriverManager.getDriver(), 10)
   				.until(ExpectedConditions.elementToBeClickable(element)).click();
        	   
        	   break;
            }
        }
       // Assertions.fail("Такой услуги нет: " + serviceName);
	}
}