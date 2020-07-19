import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegRequestStep1Page extends Page{//Первый шаг оформления заявки
	
    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")//Кнопка: Оформить
    private WebElement requestButton;

    public void requestButtonStep1Click(){
   
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(requestButton)).click();
    } 
}