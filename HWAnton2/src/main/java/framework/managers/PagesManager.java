package framework.managers;

import framework.pages.IpotekaPage;
import framework.pages.StartPage;

public class PagesManager {
	
	private static PagesManager pagesManager;
	
	private StartPage sPage;
	private IpotekaPage iPage;
	
	private PagesManager() {
	}
	
	public static PagesManager getPagesManager() {
		if(pagesManager == null) {
			pagesManager = new PagesManager();
		}
		return pagesManager;
	}
	
	public StartPage getStartPage() {
		if(sPage == null) {
			sPage = new StartPage();
		}
		return sPage;
	}
	
	public IpotekaPage getIpotekaPage() {
		if(iPage == null) {
			iPage = new IpotekaPage();
		}
		return iPage;
	}
}