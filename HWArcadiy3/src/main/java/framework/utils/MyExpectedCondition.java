package framework.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedCondition {
	
	public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element,
    final String value) {

		return new ExpectedCondition<Boolean>() {
		
					public Boolean apply(WebDriver driver) {
						try {
								String elementNumber = MethodsUtils.returnNumber(element.getText());								
									return elementNumber.equals(value);
							} catch (StaleElementReferenceException e) {
								return null;
							}
					}
		};
	}		
}