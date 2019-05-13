package parallelExecution;
 
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

 
public class Test03  extends TestBase{
 
    @Test
    public void testLink()throws Exception{
        getDriver().get("http://facebook.com");
        Thread.sleep(5000);
        WebElement textBox = getDriver().findElement(By.xpath("//input[@value='Re-enter Email']"));
        textBox.click();
        Thread.sleep(5000);
        textBox.sendKeys("Test three!");
        Thread.sleep(10000);
    }
}
