
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PersonPage extends Page{//Начальная страница
	
    @FindBy(xpath = "//span[@class='lg-menu__text' and contains(text(), 'Страхование')]")//Кнопка: Страхование
    private WebElement insurButton;
    
    @FindBy(xpath = "//a[@class='lg-menu__sub-link' and contains(text(), 'Страхование путешественников')]")//Кнопка: Путешествие и покупки
    private WebElement travelsAndPurchButton;
    
    public void insurButtonClick(){
    	Actions insurAction = new Actions(Driver.getDriver());
    	insurAction.moveToElement(insurButton).build().perform();
    }
    
    public void travelsAndPurchButtonClick(){
    	travelsAndPurchButton.click();
    }   
}