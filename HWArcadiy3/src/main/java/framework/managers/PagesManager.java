package framework.managers;

import framework.pages.ContributionPage;
import framework.pages.StartPage;

public class PagesManager {
	
	private static PagesManager pagesManager;
	
	private StartPage sPage;
	private ContributionPage cPage;
	
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
	
	public ContributionPage getContributionPage() {
		if(cPage == null) {
			cPage = new ContributionPage();
		}
		return cPage;
	}
}
