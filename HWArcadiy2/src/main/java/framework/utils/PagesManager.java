package framework.utils;

import framework.pages.BasketPage;
import framework.pages.DetroitPage;
import framework.pages.PSPage;
import framework.pages.ResultSearchPage;
import framework.pages.StartPage;

public class PagesManager {
	
	private static PagesManager pagesManager;
	
	private StartPage sPage;
	private ResultSearchPage resultSearch;
	private PSPage psPage;
	private DetroitPage dPage;
	private BasketPage bPage;
	
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
	
	public ResultSearchPage getResultSearchPage() {
		if(resultSearch == null) {
			resultSearch = new ResultSearchPage();
		}
		return resultSearch;
	}

	public PSPage getPSPage() {
		if(psPage == null) {
			psPage = new PSPage();
		}
		return psPage;
	}
	
	public DetroitPage getDetroitPage() {
		if(dPage == null) {
			dPage = new DetroitPage();
		}
		return dPage;
	}
	
	public BasketPage getBasketPage() {
		if(bPage == null) {
			bPage = new BasketPage();
		}
		return bPage;
	}
}