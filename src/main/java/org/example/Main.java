package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
       //     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //         driver.get("https://selenium.dev");
  //          new WebDriverWait(driver, Duration.ofSeconds(3));
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            try {
                Thread.sleep(7* 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

      //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //        new WebDriverWait(driver, Duration.ofSeconds(3));
            driver.quit();
        }

}

