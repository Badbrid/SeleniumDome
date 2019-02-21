import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import org.apache.log4j.Logger;
import page.TeamPage;
import utils.ReadCSVFile;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class TestChromeDriver {
    public WebDriver webDriver;
    private static Logger logger =Logger.getLogger(TestChromeDriver.class);

    @DataProvider
    private Object[][] selDates() throws IOException {
        return ReadCSVFile.readCSVFile("C:\\Users\\张涛\\Desktop\\sreachK.csv");
    }

    @BeforeClass
    private void setup(){
        webDriver =new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }

    /**
     * 测试首页搜索功能
     */
    @Test(dataProvider = "selDates")
    private void test(String date ,String date1){
        webDriver.get("https://testerhome.com/");
        logger.info("开始进入testerhome社区");
        HomePage homePage = new HomePage(webDriver);
        homePage.sreachKeyWords(date +" " +date1);
        logger.info("先清除搜索框里的内容，然后搜索关键字"+date +" "+ date1);
        Actions actions =new Actions(webDriver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    public void testTeams(){
        webDriver.get("https://testerhome.com/");
        logger.info("开始进入testerhome社区");
        HomePage homePage = new HomePage(webDriver);
        TeamPage teamPage = homePage.gotoTeam(webDriver);
        String context = teamPage.gotoHogwarts();
        Assert.assertTrue(context.contains("访问被拒绝"),"实际的标题是" + context);
    }

    @AfterClass
    private void teardown(){
        webDriver.quit();
    }
}
