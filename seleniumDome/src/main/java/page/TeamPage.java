package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

/**
 * @author:stzhang
 * @date:2019-02-21
 * description: div .media-heading [href="/hogwarts"]
 */
public class TeamPage {
    @FindBy(css="div .media-heading [href=\"/hogwarts\"]")
    WebElement teams;
    @FindAll({
            @FindBy(css = ".title")
    })
    public List<WebElement> topic;
    @FindBy(css =".alert-danger")
    WebElement close;

    public TeamPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public String gotoHogwarts(){
        teams.click();
        topic.get(1).click();
        return close.getText();
    }
}
