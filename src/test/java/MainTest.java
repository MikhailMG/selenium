import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.StringRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public WebDriver driver1;

    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        System.out.println("It will be executed first");
/*Driver launch*/
        WebDriverManager.firefoxdriver().setup();
        //     FirefoxOptions options = new FirefoxOptions();
        //         System.setProperty("webdriver.gecko.driver",
        //         "C:\\Users\\Mikhail\\IdeaProjects\\A1QA\\geckodriver-v0.32.2-win-aarch64");
        //       options.addArguments("--remote-allow-origins=*");
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driverFirefox.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //          new WebDriverWait(driver, Duration.ofSeconds(3));
        driver1 = driverFirefox;
    }

    @Test
    public void selenium() {
        System.out.println("selenium test started");
        // Random string method tests
        System.out.println(StringRandom.randomAlphaNumeric((int) (50 * (Math.random()))));
        System.out.println(StringRandom.randomAlphaNumericSpesh((int) (50 * (Math.random()))));

/*Loading the HomePage*/
        driver1.get("https://store.steampowered.com/");
//           try {
//                Thread.sleep(12* 1000);
//            } catch (InterruptedException ie) {
//                Thread.currentThread().interrupt();
//            }

/*// Page was loaded - check*/
      //  WebElement siteLoadCheck = driver1.findElement(By.
        //  xpath("/html/body/div[1]/div[7]/div[1]/div/div[3]/div/a"));
        WebElement siteLoadCheck = driver1.findElement(By.
                xpath("//a[contains(@class,'global_action_link') and" +
                        " contains(@href,'store.steampowered.com/login')]"));
   //     <a class="global_action_link" href="https://store.steampowered.com/login/
        //     ?redir=&amp;redir_ssl=1&amp;snr=1_4_springsale__global-header">войти</a>

        Assert.assertTrue(siteLoadCheck.isDisplayed(),"Login button is not dispayed");
//        Assert.assertEquals(false, siteLoadCheck.isDisplayed(),"Login button is not dispayed");

/*Login button HomePage click*/
        WebElement loginButtonHomePage = driver1.findElement(By.
                xpath("//a[contains(@class,'global_action_link') and" +
                        " contains(@href,'store.steampowered.com/login')]"));
    //    WebElement loginButtonHomePage = driver1.findElement(By.
        //    xpath("/html/body/div[1]/div[7]/div[1]/div/div[3]/div/a"));
        Actions action = new Actions(driver1);
        action.moveToElement(loginButtonHomePage).click().perform();

/*Login page was loaded - check*/



/*Pass field entry creation*/
        WebElement loginPassField = driver1.findElement(By.
                xpath("/html/body/div[1]/div[7]/div[6]/div/" +
                        "div[1]/div/div/div/div[2]/div/form/div[2]/input"));
//                WebElement loginPassField = driver.findElement(By.
//                xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
        action.moveToElement(loginPassField).click().perform();
        action.sendKeys(StringRandom.randomAlphaNumericSpesh(8)).perform();

/*Username field entry creation*/
        WebElement loginUserField = driver1.findElement(By.
                xpath("/html/body/div[1]/div[7]/div[6]/div/" +
                        "div[1]/div/div/div/div[2]/div/form/div[1]/input"));
//                WebElement loginPassField = driver.findElement(By.
//                xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;

        action.moveToElement(loginUserField).click().perform();
        action.sendKeys(StringRandom.randomAlphaNumeric(8)).perform();

/*Login Data ENTER button click*/
        WebElement loginEnterButton = driver1.findElement(By.
                xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/" +
                        "div/div/div/div[2]/div/form/div[4]/button"));
//                WebElement loginPassField = driver.findElement(By.
//                xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
        action.moveToElement(loginEnterButton).click().perform();

/*Loading SPINNER check*/
        WebElement loadSpinner = driver1.findElement(By.
                xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"));
        // //a[contains(@class,'global_action_link') and
        // contains(@href,'store.steampowered.com/login')newlogindialog_LoadingSpinner_2rGL7]
                //     div class="newlogindialog_LoadingSpinner_2rGL7 newlogindialog_Small_2G7Us"
        Assert.assertTrue(loadSpinner.isDisplayed(), "Loading spinner is not dispayed");
        System.out.println("SPINNER WAS FOUND!!!!!!!!!!!!!!!!!!!!!!!!");

/*Loading SPINNER disappeared condition*/
        int count = 4;
       List<WebElement> presence = driver1.findElements(By.
               xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"));
       int size1 = presence.size();
  //      boolean spinPresenseStatus = size1>0;
       while (count-- != 0 && (size1 >0))
      /*(loadSpinner.isDisplayed())*/ /*&&*/
        {
            System.out.println("while cycle "+count);
            //         loadSpinner = driver1.findElement(By.
   //                 xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"));
  //          System.out.println("Spinner status  "+loadSpinner.isDisplayed());
                    try {
            Thread.sleep(5 * 100);
//        } catch (NoSuchElementException e) {
//      throw new RuntimeException("Web element not visible within given time" + loadSpinner +" Time "+ "delay");
        } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            presence = driver1.findElements(By.
                    xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"));
            size1 = presence.size();
            System.out.println(size1);
        //    System.out.println(spinPresenseStatus);
//            WebDriverWait waitForSpinDisappire = new WebDriverWait(driver1, 10);
//                       waitForSpinDisappire.until(ExpectedConditions.invisibilityOf(loadSpinner))
// <div class="newlogindialog_FormError_1Mcy9">Пожалуйста, проверьте свой пароль и
// имя аккаунта и попробуйте снова.</div>
        }

//        WebDriverWait waitForSpinDisappire = new WebDriverWait(driver1, 20);
//        waitForSpinDisappire.until(ExpectedConditions.invisibilityOf(loadSpinner));
//        new WebDriverWait(driver1, 10).until(ExpectedConditions.invisibilityOf(loadSpinner));

//       Boolean waitForSpinnerDisappire = new WebDriverWait(driver1, 10)
//        .until(ExpectedConditions.invisibilityOfElementLocated((By.
//        xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"))));
//        loadSpinner = driver1.findElement(By.
//                xpath("//div[contains(@class,'newlogindialog_LoadingSpinner_2rGL7')]"));
       Assert.assertEquals(0,presence.size(), "Loading spinner is STILL displayed");


/*Login ERROR message check*/
        //     div  class="newlogindialog_FormError_1Mcy9"


//        try {
//            Thread.sleep(5 * 1000);
//        } catch (InterruptedException ie) {
//            Thread.currentThread().interrupt();
//        }
    }

    @AfterClass
    public void after_test() {
        driver1.quit();
        System.out.println("driver disabled");
    }
}




