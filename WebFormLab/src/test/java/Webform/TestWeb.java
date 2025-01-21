package Webform;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class TestWeb {


    By textinput= new By.ById("my-text-id");
    By password= new By.ByXPath("/html/body/main/div/form/div/div[1]/label[2]/input");
    By textarea= new By.ByXPath("/html/body/main/div/form/div/div[1]/label[3]/textarea");
    By submit = new By.ByXPath("/html/body/main/div/form/div/div[2]/button");
    By message = new By.ById("message");
    By readonlyinput = new By.ByXPath("/html/body/main/div/form/div/div[1]/label[5]/input");
    By dropdown_element= new By.ByName("my-select");
    By dropdown_datalist= new By.ByName("my-datalist");
    By fileinput= new By.ByName("my-file");
    By defaultradio= new By.ByXPath("/html/body/main/div/form/div/div[2]/div[3]/label");
    By firstcheckbox= new By.ByXPath("/html/body/main/div/form/div/div[2]/div[1]/label[1]");
    By secondcheckbox= new By.ByXPath("/html/body/main/div/form/div/div[2]/div[1]/label[2]");
    By color= new By.ByXPath("/html/body/main/div/form/div/div[3]/label[1]/input");
    By range= new By.ByXPath("/html/body/main/div/form/div/div[3]/label[3]/input");
    By date= new By.ByXPath("/html/body/main/div/form/div/div[3]/label[2]/input");
    By datepicker= new By.ByXPath("/html/body/div/div[1]/table/tbody/tr[5]/td[3]");





    @Test
    public void Testapp() {

        // open browser
        WebDriver driver = new ChromeDriver();

        // navigate to url ""
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        // click on field
        driver.findElement(textinput).click();
        // fill the field
        driver.findElement(textinput).sendKeys("Ehab Ahmed");

        //  // repeat on each field that must be tested
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Ehab123");

        // repeat on each field that must be tested
        driver.findElement(textarea).click();
        driver.findElement(textarea).sendKeys("Hello Test automation");

        driver.findElement(readonlyinput).click();
        driver.findElement(readonlyinput).sendKeys("Test Automation");


        Select dropdown = new Select(driver.findElement(dropdown_element));

        dropdown.selectByVisibleText("Two");

        //driver.findElement(dropdown_datalist).sendKeys("Seattle");


        //////////////////////////////////////////////////////////////////retreive data from select menu ////////



        driver.findElement(dropdown_datalist).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"my-options\"]")));


        List<WebElement> suggestions = driver.findElements(By.xpath("//*[@id=\"my-options\"]/option"));


        for (WebElement suggestion : suggestions) {


            String mytext ="Seattle";

           if(mytext.equals(suggestion.getAttribute("value")))
           {
               System.out.println(suggestion.getAttribute("value"));

               WebElement inputField = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
              // inputField.clear();
               inputField.sendKeys(suggestion.getAttribute("value"));
               break;


           }
           else
           {
               System.out.println("not found ");
           }

        }







        // import file
        File uploadFile = new File(  "C:\\Users\\SkradOo\\Desktop\\wc.cpp");
        WebElement fileInput = driver. findElement(By.cssSelector("div.col-md-4:nth-child(2) > label:nth-child(3) > input:nth-child(1)"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());


        // select checkboxes
        boolean selected = driver.findElement(firstcheckbox).isEnabled();
        if (selected) {
           // System.out.println("Selected");
        } else {
            //System.out.println("not Selected");

            driver.findElement(firstcheckbox).click();
        }




        driver.findElement(secondcheckbox).click();
        //click on radio
        driver.findElement(defaultradio).click();

        //pick color
        WebElement elementt = driver. findElement(color);
        JavascriptExecutor javascriptexecutor=(JavascriptExecutor)driver;
        javascriptexecutor.executeScript( "arguments[0]. setAttribute('value','#FFEEFX' )", elementt);


        //pickupdate

        //to make select for Date
        driver. findElement(date).click();
        driver. findElement(datepicker).click();
        driver. findElement (date). sendKeys(Keys. ESCAPE);



        //adjust range
        WebElement Range = driver. findElement(range);
        JavascriptExecutor javascriptexecutor1 =(JavascriptExecutor)driver;
        javascriptexecutor1.executeScript( "arguments[0].setAttribute('value','0')", Range);



        driver.findElement(submit).click();
        //get message
        String actualmessage = driver.findElement(message).getText();
        //start asserting the results
        Assert.assertEquals(actualmessage , "Received!");


        //driver.quit();

    }




}
