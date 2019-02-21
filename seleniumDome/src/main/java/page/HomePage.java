package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static Logger logger =Logger.getLogger(HomePage.class);
//    WebDriver webDriver;
    @FindBy(css="input.form-control ")
    WebElement sreachKeyWord;
    @FindBy(css =".nav [href=\"/teams\"]")
    public WebElement team;
    public HomePage(WebDriver driver){
//        webDriver=driver;
        PageFactory.initElements(driver,this);
    }

    public void sreachKeyWords(String keyWord){
        sreachKeyWord.clear();
        sreachKeyWord.sendKeys(keyWord);
    }

    public  TeamPage gotoTeam(WebDriver driver){
        logger.info("开始点击社区");
        team.click();
        return new TeamPage(driver);
    }
}
