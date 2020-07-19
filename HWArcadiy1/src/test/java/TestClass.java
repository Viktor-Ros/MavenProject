
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestClass {
	
    @BeforeAll
    public static void setUp() {
        Driver.getDriver();
    }

    @Test
	public void testSber(){
    	
    	PersonPage person = new PersonPage();
    	InsuranceTravelPage travel = new InsuranceTravelPage();
    	RegRequestStep1Page reqStep1 = new RegRequestStep1Page();
    	RegRequestStep2Page reqStep2 = new RegRequestStep2Page();

    	person.insurButtonClick();
    	person.travelsAndPurchButtonClick();
    	
	    travel.checkTravelInsurHeading("Страхование путешественников");
    	travel.makeRequestButtonClick();
    	
    	reqStep1.requestButtonStep1Click();
    	
    	reqStep2.textLastNameLabel1("Иванов");
    	reqStep2.textFirstNameLabel1("Иван");
    	reqStep2.textBirthdayLabel1("03031995");
    	reqStep2.textLastNameLabel2("Петров");
    	reqStep2.textFirstNameLabel2("Петр");
    	reqStep2.textMiddleNameLabel2("Петрович");
    	reqStep2.textBirthdayLabel2("03031993");
    	reqStep2.textPassSerLabel("1111");
    	reqStep2.textPassNumLabel("111111");
    	reqStep2.sexButtonClick("Ж");
    	reqStep2.textPassDateLabel("03031997");
    	reqStep2.textPassIssueLabel("Пункт Выдачи");
    	
    	Assertions.assertEquals("Иванов", reqStep2.getTextLastNameLabel1(),"Некорректнная фамилия Застрахованного");
    	Assertions.assertEquals("Иван", reqStep2.getTextFirstNameLabel1(), "Некорректнное имя Застрахованного");
    	Assertions.assertEquals("03.03.1995", reqStep2.getTextBirthdayLabel1(),"Некорректнный д/р Застрахованного");
    	Assertions.assertEquals("Петров", reqStep2.getTextLastNameLabel2(),"Некорректнная фамилия Страхователя");
    	Assertions.assertEquals("Петр", reqStep2.getTextFirstNameLabel2(),"Некорректнное имя Страхователя");
    	Assertions.assertEquals("Петрович", reqStep2.getTextMiddleNameLabel2(),"Некорректнное отчество Страхователя");
    	Assertions.assertEquals("03.03.1993", reqStep2.getTextBirthdayLabel2(),"Некорректнный д/р Страхователя");
    	Assertions.assertEquals("1111", reqStep2.getTextPassSerLabel(),"Некорректнная серия паспорта");
    	Assertions.assertEquals("111111", reqStep2.getTextPassNumLabel(),"Некорректнный номер паспорта");
    	Assertions.assertEquals("03.03.2013", reqStep2.getTextPassDateLabel(),"Некорректнная дата выдачи паспорта");
    	Assertions.assertEquals("Пункт Выдачи", reqStep2.getTextPassIssueLabel(),"Некорректнный пункт выдачи паспорта");

    	reqStep2.proceedButtonClick();
    	
    	Assertions.assertEquals("При заполнении данных произошла ошибка", reqStep2.getTextErrorLabel(),"При заполнении данных произошла ошибка");	
    }
 
    @AfterAll
    public static void tearDown() {
    	Driver.quitDriver();
    }
}