package framework.pages;

import org.openqa.selenium.support.PageFactory;

import framework.utils.DriverManager;
import framework.utils.PagesManager;

public class Page {

	PagesManager app = PagesManager.getPagesManager();
	
    public Page(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}