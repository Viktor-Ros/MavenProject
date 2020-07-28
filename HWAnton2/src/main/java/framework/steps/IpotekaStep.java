package framework.steps;


import java.util.Map;

import framework.utils.AllureUtils;
import io.qameta.allure.Step;

public class IpotekaStep extends BaseStep{
	
	@Step("ввод отдельного параметра ипотеки")
	public IpotekaStep inputIpotekaParam(String name, String param) {		
		
		appPages.getIpotekaPage().inputIpotekaParam(name,param);
		return this;
	}
	
	@Step("ввод всех параметров ипотеки")
	public IpotekaStep inputIpotekaParams(Map<String, String> params) {
		
		params.forEach(this::inputIpotekaParam);
		return this;
	}
	
	@Step("отключение карты сбера")
	public IpotekaStep cardSberOff() {
		
		appPages.getIpotekaPage().cardSberOff();
		return this;
	}
	
	@Step("проверка поля: Есть возможность подтвердить доход справкой")
	public IpotekaStep proofIncomeTextVisible() {
		
		appPages.getIpotekaPage().proofIncomeTextVisible();
		return this;
	}
	
	@Step("выбор скидки: Молодая семья")
	public IpotekaStep discountOn(String message) {
		
		appPages.getIpotekaPage().discountOn(message);
		return this;
	}
	
	@Step("проверка отдельного параметра ипотеки")
	public IpotekaStep checkValue(String name, String value) {
		
		appPages.getIpotekaPage().checkValue(name, value);
		AllureUtils.addScreenshot();
		return this;
	}	
	
	@Step("ввод всех параметров ипотеки")
	public IpotekaStep checkValues(Map<String, String> params) {
		
		params.forEach(this::checkValue);
		return this;
	}
}