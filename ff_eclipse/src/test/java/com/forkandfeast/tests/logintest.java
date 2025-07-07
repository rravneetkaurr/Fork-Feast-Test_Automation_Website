package com.forkandfeast.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class logintest 
{
	
	static StringBuilder resultSummary = new StringBuilder();

    @DataProvider(name = "loginData")
    public Object[][] loginTestData() 
    {
        return new Object[][] 
        {
            {"rav@gmail.com", "rav123"},    
            {"invaliduser@example.com", "rav123"},     
            //{"rav@gmail.com", "wrongpass2"},     
            //{"wrong@gmail.com", "wrong"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:3000/login.html");  

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);       
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);    
        driver.findElement(By.xpath("//button[@type='submit']")).click();  
        
        WebElement orderNowButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(orderNowButton.isEnabled(), "Login button is not enabled!");

        Thread.sleep(4000);

        boolean loginSuccess = driver.getPageSource().contains("Welcome user!");
        
        if (loginSuccess) {
            System.out.println("Login SUCCESSFUL for: " + username);
        } else {
            System.out.println("Login FAILED for: " + username);
        }
        
        Assert.assertTrue(loginSuccess, "Login failed for: " + username);

        driver.quit();
    }
    
    public void printResults() 
    {
        System.out.println("\n========== LOGIN TEST SUMMARY ==========");
        System.out.println(resultSummary.toString());
        System.out.println("========================================\n");
    }
}
