package framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.utils.DriverManager;

public class StartPage extends Page{//Главная страница
		
	@FindBy(xpath = "//input[@class = 'ui-input-search__input ui-input-search__input_presearch' and @placeholder= 'Поиск по сайту']")
	private WebElement searchLabel;//Поле поиска
	
	public ResultSearchPage searchPS() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(searchLabel)).sendKeys("playStation");
		
		searchLabel.sendKeys(Keys.ENTER);	
		
		return app.getResultSearchPage();
	}	
}