package framework.steps;

import io.qameta.allure.Step;


public class StartStep extends BaseStep{
	
    	@Step("выбрана ипотека")
    	public StartStep selectTypeService(String message) {
    		
    		appPages.getStartPage().selectTypeService(message);;
    		return this;
    	}

    	@Step("выбрано готовое жилье")
    	public IpotekaStep selectService(String message) {
    		
    		appPages.getStartPage().selectService(message);;
    		return appSteps.getIpotekaStep();
    	}
}