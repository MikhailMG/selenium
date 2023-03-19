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
import java.util.concurrent.TimeUnit;

public class Main {

        public static void main(String[] args) {
        System.out.println("Hello world!");

            WebDriverManager.firefoxdriver().setup();
       //     FirefoxOptions options = new FirefoxOptions();
            //         System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mikhail\\IdeaProjects\\A1QA\\geckodriver-v0.32.2-win-aarch64");
            //       options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new FirefoxDriver();
           driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
      //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //         driver.get("https://selenium.dev");
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
            try {
                Thread.sleep(12* 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            driver.quit();
        }

}

