package parallelExecution;
 

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import parallelExecution.TestBase;
 
public class Test01 extends TestBase{
 
    @Test
    public void testLink()throws Exception{
        getDriver().get("https://facebook.com");
        Thread.sleep(5000);
        WebElement textBox = getDriver().findElement(By.xpath("//input[@value='Your Email']"));
        textBox.click();
        Thread.sleep(5000);
        textBox.sendKeys("Just a test!");
        Thread.sleep(30000);
    }
}
