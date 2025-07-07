package com.forkandfeast.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class searchtest 
{

    WebDriver driver;

    /*
    @Test
    public void testimonials() throws InterruptedException {
        System.out.println("Setting up WebDriver on thread: " + Thread.currentThread().getName());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        System.out.println("Running testLogin on thread: " + Thread.currentThread().getName());
        driver.get("http://127.0.0.1:3002/login.html");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("hardetyagill@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        WebElement successMessage = driver.findElement(By.xpath("//h2[normalize-space()='Welcome user!']"));
        Assert.assertTrue(successMessage.isDisplayed(), "Welcome message not displayed!");
        
        System.out.println("Running testSearch on thread: " + Thread.currentThread().getName());
        driver.get("http://127.0.0.1:3002/index.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Testimonials']")).click();
        Thread.sleep(5000);

        driver.quit();
    }
    */
    
    @BeforeMethod
    public void setup() {
        System.out.println("Setting up WebDriver on thread: " + Thread.currentThread().getName());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException{
        System.out.println("Running testLogin on thread: " + Thread.currentThread().getName());
        driver.get("http://127.0.0.1:3000/login.html");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("hardetyagill@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        WebElement successMessage = driver.findElement(By.xpath("//h2[normalize-space()='Welcome user!']"));
        Assert.assertTrue(successMessage.isDisplayed(), "Welcome message not displayed!");
    }

    @Test
    public void testSearch() throws InterruptedException{
    	System.out.println("Running testSearch on thread: " + Thread.currentThread().getName());
        driver.get("http://127.0.0.1:3000/index.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Testimonials']")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Tearing down WebDriver on thread: " + Thread.currentThread().getName());
        if (driver != null) {
            driver.quit();
        }
        
}
}

