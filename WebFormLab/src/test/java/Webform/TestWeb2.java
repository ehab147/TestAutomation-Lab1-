package Webform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWeb2 {

    @Test
    public void waitbutton()
    {
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("adder")).click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("box0")));

        driver.findElement(By.id("reveal")).click();

        WebDriverWait delayy=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement reveal=delayy.until(ExpectedConditions.presenceOfElementLocated(By.id("revealed")));

        driver.findElement(By.id("revealed")).click();

        driver.findElement(By.id("revealed")).sendKeys("A7mos");



    }

}
