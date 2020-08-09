package tests;


import org.junit.Test;

import basetests.BaseAllureTest;

public class AllureTest extends BaseAllureTest{
	 
	@Test
	public void testCredit(){
	    	
		app.getStartPage().selectService("Вклады")
						  .selectCurrency("Рубли")
						  .setContributionParam("Сумма вклада", "300000")
						  .setContributionParam("На срок", "6")
						  .setContributionParam("Ежемесячное пополнение", "50000")
						  .additionalOptionsOn("Ежемесячная капитализация")
						  .checkParametr("Начислено %", "7422,56")
						  .checkParametr("Пополнение за 6 месяцев", "250000")
						  .checkParametr("К снятию через 6 месяцев", "557422,56");
	
	
	  /*app.getStartPage().selectService("Вклады")
	  .selectCurrency("Доллары США")
	  .setContributionParam("Сумма вклада", "500000")
	  .setContributionParam("На срок", "9")
	  .setContributionParam("Ежемесячное пополнение", "70000")
	  .additionalOptionsOn("Ежемесячная капитализация")
	  .checkParametr("Начислено %", "13")	
	  //.checkParametr("Начислено %", "1382,24")
	  .checkParametr("Пополнение за 9 месяцев", "240000")
	  .checkParametr("К снятию через 9 месяцев", "741382,24");
	  */
	}
}