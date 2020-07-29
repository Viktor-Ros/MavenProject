package framework.steps;

import org.openqa.selenium.support.PageFactory;

import framework.managers.DriverManager;
import framework.managers.PagesManager;
import framework.managers.StepsManager;

public class BaseStep {
	
    protected StepsManager appSteps = StepsManager.getStepsManager();
    
	PagesManager appPages = PagesManager.getPagesManager();

    public BaseStep(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}