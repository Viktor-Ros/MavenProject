package framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.utils.DriverManager;

public class ResultSearchPage extends Page{// Страница с результатами поиска

	@FindBy(xpath = "//a[contains(text(), 'Игровая консоль PlayStation 4 Slim Black 1 TB + 3 игры')]")
	private WebElement psTitle;//Заголовок PS
	
	public PSPage psTitleClick() {
		
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(psTitle)).click();	
		
		return app.getPSPage();
	}
}