package framework.stepdef;

import framework.managers.StepsManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	protected StepsManager appSteps = StepsManager.getStepsManager();
	
    @When("выбран тип услуги: {string}")
    public void selectTypeService(String title){
        appSteps.getStartStep().selectTypeService(title);   
    }
    
    @Then("выбрана услуга: {string}")
    public void selectMenuItem(String title){
    	appSteps.getStartStep().selectService(title);
    }
	
    @When("заполняются поля:")
    public void inputIpotekaParams(DataTable fields){
    	appSteps.getIpotekaStep().inputIpotekaParams(
                fields.asMap(String.class, String.class));
    }
    
    @When("отключается карта сбера")
    public void cardSberOff(){
    	
    	appSteps.getIpotekaStep().cardSberOff();
    }
    
    @Then("проверяется заголовок")
    public void proofIncomeTextVisible(){
    	appSteps.getIpotekaStep().proofIncomeTextVisible();
    }
    
    @When("выбирается скидка: {string}")
    public void discountOn(String title){
    	appSteps.getIpotekaStep().discountOn(title);
    }
    
    @Then("значения полей равны:")
    public void checkValues(DataTable fields){
    	appSteps.getIpotekaStep().checkValues(
                fields.asMap(String.class, String.class));
    }  
}