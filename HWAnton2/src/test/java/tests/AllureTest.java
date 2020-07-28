package tests;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import basetest.BaseAllureTest;

public class AllureTest extends BaseAllureTest{

    @Test
	public void testSber(){
    	
    	appSteps.getStartStep().selectTypeService("Ипотека")
							.selectService("Ипотека на готовое жильё")
							.inputIpotekaParams(
			                        new HashMap<String, String>() {{
			                            put("Стоимость недвижимости", "5180000");
			                            put("Первоначальный взнос", "3058000");
			                            put("Срок кредита", "3058000");
			                        }}
			                )
							.cardSberOff()
							.proofIncomeTextVisible()
							
							
							.discountOn("Молодая семья")
							.checkValues(			                
									new HashMap<String, String>() {{
										put("Сумма кредита","2122000");
										put("Ежемесячный платеж","18937");
										put("Необходимый доход","31561");
										put("Процентная ставка","11");

	                        }}
	                );
    }
}