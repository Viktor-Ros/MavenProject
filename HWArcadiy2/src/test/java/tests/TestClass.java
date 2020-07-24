package tests;

import org.junit.jupiter.api.Test;
import basetest.BaseTest;

public class TestClass extends BaseTest{

    @Test
	public void testDNS(){
    	
    	app.getStartPage().searchPS()
    						.psTitleClick()
    						.garantLabelPS4Select()
    						.buyPS4Button()
    						.searchDetroit()
    						.detroitBuyButton()
    						.checkBasketPrice()
    						.goBasketButton()
    						.checkGarantPS()
    						.checkPriceProducts(app.getPSPage().getPSProduct().getPrice())
    						.checkPriceProducts(app.getDetroitPage().getDetroitProduct().getPrice())
    						.deleteDetroit()
    						.checkDetroitInBasket(app.getDetroitPage().getDetroitProduct().getName())
    						.checkBasketPrice(app.getPSPage().getPSProduct().getGarantPrice())
    						.addTwoPS()
    						.checkBasketPrice(app.getPSPage().getPSProduct().getGarantPrice()*3)
    						.returnDetroit()
    						.checkBasketPrice(app.getPSPage().getPSProduct().getGarantPrice()*3 + app.getDetroitPage().getDetroitProduct().getPrice());	
    }
}