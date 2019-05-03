package parallelExecution;
 
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
 
public class Test02 extends TestBase{
 
    @Test
    public void testLink()throws Exception{
        getDriver().get("https://twitter.com");
        Thread.sleep(5000);
        WebElement textBox = getDriver().findElement(By.xpath("//label1"));
        Thread.sleep(5000);
        textBox.click();
        textBox.sendKeys("Just another test!");
        Thread.sleep(20000);
    }
 
}
