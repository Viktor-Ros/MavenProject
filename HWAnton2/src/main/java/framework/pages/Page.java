package framework.pages;

import org.openqa.selenium.support.PageFactory;

import framework.managers.DriverManager;
import framework.managers.PagesManager;


public class Page {

	PagesManager app = PagesManager.getPagesManager();
	
    public Page(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}