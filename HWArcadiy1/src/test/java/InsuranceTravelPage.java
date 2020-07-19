
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTravelPage extends Page{
	
    @FindBy(xpath = "//h1[@class='kit-heading kit-heading_l product-teaser-full-width__header' and contains(text(), 'Страхование путешественников')]")//Заголовок: Страхование путешественников
    private WebElement travelInsurHeading;
    
    @FindBy(xpath = "//a[@class='kit-button  kit-button_default kit-button_type_big analytics-button']")//Кнопка: Оформить онлайн
    private WebElement makeRequestButton;
    
    public void checkTravelInsurHeading(String heading) {
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.visibilityOfAllElements(makeRequestButton));

    	Assertions.assertEquals(heading, travelInsurHeading.getAttribute("innerHTML"),"Такого заголовка не существует");		  
    }  
    
    public void makeRequestButtonClick(){
    	
        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("arguments[0].click();", makeRequestButton);    	
    }
}
