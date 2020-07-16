import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {

	private WebDriver driver;
	private WebDriverWait wait;
	private final static String URL = "https://www.rgs.ru";
	
	  @Before
	  public void startUp() {//Открывает сайт
		  
		    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		    driver.get(URL);
		    wait = new WebDriverWait(driver, 10);  
	  }
	
	  @Test
	  public void testGoogleSearch() throws InterruptedException {//Сценарий

		  //Клик по кнопке: Меню
		  String menuXPath = "//a[@class='hidden-xs' and contains(text(), 'Меню')]";
		  WebElement menuButton = driver.findElement(By.xpath(menuXPath));
		  menuButton.click();
		  
		  //Клик по кнопке: ДМС
		  String dialogMenuXPath = "//div[@class='container-rgs-main-menu-links-grid-wrap']";
		  String dmsXPAth = "//a[contains(text(), 'ДМС')]";
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dialogMenuXPath)));
		  WebElement dmsButton = driver.findElement(By.xpath(dmsXPAth));
		  dmsButton.click();
		  
		  //Проверка заголовка: Добровольное медицинское страхование
		  String dmsHeadingText = "ДМС — добровольное медицинское страхование";
		  String dmsHeadingTextXpath = "//*[text()[contains(.,'добровольное медицинское страхование')]]";
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dmsHeadingTextXpath)));
		  WebElement dmsHeadingButton = driver.findElement(By.xpath(dmsHeadingTextXpath));
		  Assert.assertEquals("Такого заголовка не существует", dmsHeadingText, dmsHeadingButton.getText());		  

		  //Клик по кнопке: Отправить заявку
		  String requestXPath = "//a[contains(text(), 'Отправить заявку')]";
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(requestXPath)));
		  WebElement requestButton = driver.findElement(By.xpath(requestXPath));
		  requestButton.click();
		  
		  //Проверка заголовка: Заявка на добровольное медицинское страхование
		  String dmsWindowHeadingText = "Заявка на добровольное медицинское страхование";
		  String dmsWindowHeadingTextXpath = "//*[text()[contains(.,'Заявка на добровольное медицинское страхование')]]";
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dmsWindowHeadingTextXpath)));
		  WebElement dmsWindowHeadingButton = driver.findElement(By.xpath(dmsWindowHeadingTextXpath));
		  Assert.assertEquals("Такого заголовка не существует", dmsWindowHeadingText, dmsWindowHeadingButton.getText());
		  
		  //Заполнение формы
		  //Фамилия
		  String labelLastNameXPath = "//input[@name = 'LastName']";
		  WebElement labelLastName = driver.findElement(By.xpath(labelLastNameXPath));
		  labelLastName.sendKeys("Фамилия");	  
		  
		  //Имя
		  String labelFirstNameXPath = "//input[@name = 'FirstName']";
		  WebElement labelFirstName = driver.findElement(By.xpath(labelFirstNameXPath));
		  labelFirstName.sendKeys("Имя");
		  
		  //Отчество
		  String labelMiddleNameXPath = "//input[@name = 'MiddleName']";
		  WebElement labelMiddleName = driver.findElement(By.xpath(labelMiddleNameXPath));
		  labelMiddleName.sendKeys("Отчество");
		  
		  //Регион
		  String selectRegionXPath = "//select[@name = 'Region']";
		  WebElement selectRegion = driver.findElement(By.xpath(selectRegionXPath));
		  selectRegion.sendKeys("Москва");
		  
		  //Телефон
		  String labelPhoneXPath = "//label[text()='Телефон']//..//input";
		  WebElement labelPhone = driver.findElement(By.xpath(labelPhoneXPath));
		  labelPhone.click();
		  labelPhone.sendKeys("8002000900");
		  
		  //Электронная почта
		  String labelMailXPath = "//input[@name = 'Email']";
		  WebElement labelMail = driver.findElement(By.xpath(labelMailXPath));
		  labelMail.sendKeys("qwertyqwerty");
		  
		  //Дата
		  String labelDateXPath = "//input[@name = 'ContactDate']";
		  WebElement labelDate = driver.findElement(By.xpath(labelDateXPath));
		  labelDate.click();
		  labelDate.sendKeys("17072020");
		  
		  //Комментарий
		  String labelCommentXPath = "//textarea[@name='Comment']";
		  WebElement labelComment = driver.findElement(By.xpath(labelCommentXPath));
		  labelComment.sendKeys("Комментарий");
		  
		  //Я согласен на обработку персональных данных
		  String agreeXPath = "//input[@type='checkbox']";
		  WebElement agreeCheckBox = driver.findElement(By.xpath(agreeXPath));
		  agreeCheckBox.click();

		  //Проверка корректности полей ввода
		  Assert.assertEquals("Некорректное значение", "Фамилия", labelLastName.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "Имя", labelFirstName.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "Отчество", labelMiddleName.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "Москва", selectRegion.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "+7 (800) 200-09-00", labelPhone.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "qwertyqwerty", labelMail.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "17.07.2020", labelDate.getAttribute("value"));
		  Assert.assertEquals("Некорректное значение", "Комментарий", labelComment.getAttribute("value"));

		  //Клик по кнопке: Отправить
		  String requestFormXPath = "//button[@id='button-m']";
		  WebElement requestFormButton = driver.findElement(By.xpath(requestFormXPath));
		  requestFormButton.click();
		  
		  //Проверка сообщения об ошибке
		  String errorMessageText = "Введите адрес электронной почты";
		  String errorMessageXPath = "//span[contains(text(), 'Введите адрес электронной почты')]";
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXPath)));
		  WebElement errorMessage = driver.findElement(By.xpath(errorMessageXPath));
		  Assert.assertEquals("Такого сообщения не существует", errorMessageText, errorMessage.getText());
	  }
	  
	  @After
	  public void tearDown() throws InterruptedException {
		  
		  Thread.sleep(15000);
		  driver.quit();  
	  }  
}