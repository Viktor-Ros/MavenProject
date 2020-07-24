package framework.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedCondition {
	
	public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element,
    final int number) {

	return new ExpectedCondition<Boolean>() {
		
				public Boolean apply(WebDriver driver) {
					try {
							int elementNumber = Integer.parseInt(element.getText().replaceAll("\\s+",""));
								return elementNumber == number;
						} catch (StaleElementReferenceException e) {
							return null;
						}
			}
	};
}		
	
	public static ExpectedCondition<WebElement> textToBePresentInElement(final WebElement elementText, 
			final WebElement elementClick,
			
		    final int number) {

			return new ExpectedCondition<WebElement>() {
				
						public WebElement apply(WebDriver driver) {
							
									int elementNumber = Integer.parseInt(elementText.getText().replaceAll("\\s+",""));
									System.out.println(elementNumber);
										 if(elementNumber == number) {
											 return elementClick;
										 }
										 else return null;
						
					}
			};
		}
	
	////////////////////////////////////////////////////////////////////////
	  /*public static ExpectedCondition<WebElement> elementToBeClickable(final WebElement element) {
		    return new ExpectedCondition<WebElement>() {

		      
		      public WebElement apply(WebDriver driver) {
		        WebElement visibleElement = visibilityOf(element).apply(driver);
		        try {
		          if (visibleElement != null && visibleElement.isEnabled()) {
		            return visibleElement;
		          }
		          return null;
		        } catch (StaleElementReferenceException e) {
		          return null;
		        }
		      }

		      @Override
		      public String toString() {
		        return "element to be clickable: " + element;
		      }
		    };
		  }
	
	
	*/
	
	
}
	
	
