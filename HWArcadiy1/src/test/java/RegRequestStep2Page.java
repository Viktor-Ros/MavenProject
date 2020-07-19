import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegRequestStep2Page extends Page{//Второй шаг оформления заявки
	
	//Застрахованные 1
    @FindBy(xpath = "//input[@id='surname_vzr_ins_0']")//Поле: Фамилия
    private WebElement lastNameLabel1;
    
    @FindBy(xpath = "//input[@id='name_vzr_ins_0']")//Поле: Имя
    private WebElement firstNameLabel1;
    
    @FindBy(xpath = "//input[@id='birthDate_vzr_ins_0']")//Поле: ДР
    private WebElement birthdayLabel1;
    
	//Страхователь 2
    @FindBy(xpath = "//input[@id='person_lastName']")//Поле: Фамилия
    private WebElement lastNameLabel2;
    
    @FindBy(xpath = "//input[@id='person_firstName']")//Поле: Имя
    private WebElement firstNameLabel2;
    
    @FindBy(xpath = "//input[@id='person_middleName']")//Поле: Отчество
    private WebElement middleNamelabel2;
    
    @FindBy(xpath = "//input[@id='person_birthDate']")//Поле: ДР
    private WebElement birthdayLabel2;
    
    @FindBy(xpath = "//label[text()[contains(.,'Женский')]]")//Поле: Пол Женский
    private WebElement sexFButton;
    
    //Паспортные данные
    @FindBy(xpath = "//input[@id='passportSeries']")//Поле: Серия паспорта
    private WebElement passSerLabel;
    
    @FindBy(xpath = "//input[@id='passportNumber']")//Поле: Номер паспорта
    private WebElement passNumLabel;
    
    @FindBy(xpath = "//input[@id='documentDate']")//Поле: Дата выдачи паспорта
    private WebElement passDateLabel;
    
    @FindBy(xpath = "//input[@id='documentIssue']")//Поле: Кем выдан паспорт
    private WebElement passIssueLabel;
    
    @FindBy(xpath = "//button[text()[contains(.,'Продолжить')]]")//Кнопка: Продолжить
    private WebElement proceedButton;
    
  
    @FindBy(xpath = "//div[text()[contains(.,'При заполнении данных произошла ошибка')]]")//Ошибка
    private WebElement errorLabel;
    
    
    public void textLastNameLabel1(String lastName1){

    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(lastNameLabel1)).click();
    	lastNameLabel1.sendKeys(lastName1);	
    } 
    
    public void textFirstNameLabel1(String firstName1){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(firstNameLabel1)).click();
    	firstNameLabel1.sendKeys(firstName1);	
    }
    
    public void textBirthdayLabel1(String birthday1){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(birthdayLabel1)).click();
    	birthdayLabel1.sendKeys(birthday1);	
    }
    
    public void textLastNameLabel2(String lastName2){

    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(lastNameLabel2)).click();
    	lastNameLabel2.sendKeys(lastName2);	
    } 
    
    public void textFirstNameLabel2(String firstName2){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(firstNameLabel2)).click();
    	firstNameLabel2.sendKeys(firstName2);	
    }
    
    public void textMiddleNameLabel2(String middleName2){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(middleNamelabel2)).click();
    	middleNamelabel2.sendKeys(middleName2);	
    }
    
    public void textBirthdayLabel2(String birthday2){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(birthdayLabel2)).click();
    	birthdayLabel2.sendKeys(birthday2);	
    }
    
    public void sexButtonClick(String sex){
    	    	
    	if(sex.equals("Ж")) {
        	new WebDriverWait(Driver.getDriver(), 10)
            .until(ExpectedConditions.elementToBeClickable(sexFButton)).click();    	
    	}
    }
    
    public void textPassSerLabel(String passSer){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(passSerLabel)).click();
    	passSerLabel.sendKeys(passSer);	
    }
    
    public void textPassNumLabel(String passNum){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(passNumLabel)).click();
    	passNumLabel.sendKeys(passNum);	
    }
    
    public void textPassDateLabel(String passDate){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(passDateLabel)).click();
    	passDateLabel.sendKeys(passDate);	
    }
    
    public void textPassIssueLabel(String passIssue){
    	
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(passIssueLabel)).click();
    	passIssueLabel.sendKeys(passIssue);	
    }
    
    public String getTextLastNameLabel1() { return lastNameLabel1.getAttribute("value");}
    public String getTextFirstNameLabel1() { return firstNameLabel1.getAttribute("value");}
    public String getTextBirthdayLabel1() { return birthdayLabel1.getAttribute("value");}
    public String getTextLastNameLabel2() { return lastNameLabel2.getAttribute("value");}
    public String getTextFirstNameLabel2() { return firstNameLabel2.getAttribute("value");}
    public String getTextMiddleNameLabel2() { return middleNamelabel2.getAttribute("value");}
    public String getTextBirthdayLabel2() { return birthdayLabel2.getAttribute("value");}
    public String getTextPassSerLabel() { return passSerLabel.getAttribute("value");}
    public String getTextPassNumLabel() { return passNumLabel.getAttribute("value");}
    public String getTextPassDateLabel() { return passDateLabel.getAttribute("value");}
    public String getTextPassIssueLabel() { return passIssueLabel.getAttribute("value");}
    
    
    public void proceedButtonClick(){
    	new WebDriverWait(Driver.getDriver(), 10)
        .until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }
    
    public String getTextErrorLabel() { return errorLabel.getAttribute("innerHTML").trim();}
}