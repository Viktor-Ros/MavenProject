package framework.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.managers.DriverManager;
import framework.utils.AllureUtils;
import io.qameta.allure.Step;

public class StartPage extends Page{
	
	@FindBy(xpath = "//div[@class='service']")
	private List<WebElement> servicesList;//Список услуг
	
	/**
	 * 
	 * Выбор услуги
	 */
	
	@Step("Выбор услуги")
	public ContributionPage selectService(String name) {
				AllureUtils.addScreenshot();
		for(WebElement element : servicesList) {
			
			WebElement labelService = element.findElement(By.xpath(".//div[@class='service__title-text']"));
			
			String elementName = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(labelService)).getAttribute("innerHTML");
			
			if(name.equals(elementName)) {
				
				WebElement elementService = element.findElement(By.xpath(".//div[@class='service__title']"));
				
				new WebDriverWait(DriverManager.getDriver(), 10)
				.until(ExpectedConditions.elementToBeClickable(elementService)).click();
				
				return app.getContributionPage();
			}
		}
		Assertions.fail("Такой услуги нет: " + name);
		
		return app.getContributionPage();
	}
}