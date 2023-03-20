package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
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
       Actions action2 = new Actions(driver);
        action2.moveToElement(loginPassField).click().perform();
              action2.sendKeys(StringRandom.randomAlphaNumericSpesh(8)).perform();

        WebElement loginUserField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/div/div/div/div[2]/div/form/div[1]/input"));
//                WebElement loginPassField = driver.findElement(By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
        Actions action3 = new Actions(driver);
        action3.moveToElement(loginUserField).click().perform();
        action3.sendKeys(StringRandom.randomAlphaNumeric(8)).perform();

        WebElement loginEnterField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[6]/div/div[1]/div/div/div/div[2]/div/form/div[4]/button"));
//                WebElement loginPassField = driver.findElement(By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
                 Actions action4 = new Actions(driver);
        action4.moveToElement(loginEnterField).click().perform();


            try {
                Thread.sleep(5* 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();


        }
        driver.quit();

//}
    }
}