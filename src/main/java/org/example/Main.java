package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println(StringRandom.randomAlphaNumeric((int) (50*(Math.random()))));
        System.out.println("Hello world!");

        WebDriverManager.firefoxdriver().setup();
        //     FirefoxOptions options = new FirefoxOptions();
        //         System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mikhail\\IdeaProjects\\A1QA\\geckodriver-v0.32.2-win-aarch64");
        //       options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //          new WebDriverWait(driver, Duration.ofSeconds(3));
        //         driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.get("https://store.steampowered.com/");
//           try {
//                Thread.sleep(12* 1000);
//            } catch (InterruptedException ie) {
//                Thread.currentThread().interrupt();
//            }
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[1]/div/div[3]/div/a"));
        Actions action = new Actions(driver);
        action.moveToElement(loginButton).click().perform();
        //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //        new WebDriverWait(driver, Duration.ofSeconds(3));
//            try {
//                Thread.sleep(15* 1000);
//            } catch (InterruptedException ie) {
//                Thread.currentThread().interrupt();

        WebElement loginPassField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/div/div/div/div[2]/div/form/div[2]/input"));
//                WebElement loginPassField = driver.findElement(By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
                     action.moveToElement(loginPassField).click().perform();
              action.sendKeys(StringRandom.randomAlphaNumericSpesh(8)).perform();

        WebElement loginUserField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/div/div/div/div[2]/div/form/div[1]/input"));
//                WebElement loginPassField = driver.findElement(By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
        action.moveToElement(loginUserField).click().perform();
        action.sendKeys(StringRandom.randomAlphaNumeric(8)).perform();

        WebElement loginEnterButton = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/div/div/div/div[2]/div/form/div[4]/button"));
//                WebElement loginPassField = driver.findElement(By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
          action.moveToElement(loginEnterButton).click().perform();

  //     div class="newlogindialog_LoadingSpinner_2rGL7 newlogindialog_Small_2G7Us"


 //     div  class="newlogindialog_FormError_1Mcy9"




        try {
                Thread.sleep(5* 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();


        }
        driver.quit();

//}
    }
}
