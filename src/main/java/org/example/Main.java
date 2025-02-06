package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "lib/selenium-java-4.28.1/chromedriver.exe"); // Update the path



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  // Allow all origins
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Open the login page
            driver.get("https://treasurenft.xyz/#/"); // Change to actual URL

            WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class, 'menuIcon')]")));
            menuButton.click();
            System.out.println("Clicked on Menu Icon");

            // Step 3: Wait for Menu Items to Appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Account')]")));
            System.out.println("Menu is now visible");

            // Step 4: Click on the Account Tab to Open Login Modal
            WebElement accountTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Account')]")));
            accountTab.click();
            System.out.println("Clicked on Account Tab");

            // Step 5: Wait for the Login Modal to Appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='User name']")));
            System.out.println("Login Modal is now visible");

            // Locate username and password fields
            WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User name']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));


            usernameField.sendKeys("vasu1357");
            passwordField.sendKeys("Vasu@123");
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='footerBtn']/button[contains(@class, 'ivu-btn-primary')]")
            ));
            confirmButton.click();
            System.out.println("Login successful!");

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ivu-modal-wrap")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//image")));

            WebElement ReserveTabInNavbar =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'pc-menu-wrap')]//div[contains(@class, 'pc-menu')]/span)[3]")));
            ReserveTabInNavbar.click();
            System.out.println("Clicked on Reserve Tab on Navbar");


            WebElement closeButtonModal = driver.findElement(By.xpath("(//a[contains(@class, 'ivu-modal-close')]//i[contains(@class, 'ivu-icon-ios-close')])[3]"));
            closeButtonModal.click();
            System.out.println("Closed the Modal");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Shutting Down");
//            driver.quit();
        }
    }


}