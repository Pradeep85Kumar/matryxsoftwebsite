package parallelExecution;
 
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
 
public class Test04  extends TestBase{
 
    @Test
    public void testLink()throws Exception{
        getDriver().get("https://twitter.com");
        Thread.sleep(5000);
        WebElement textBox = getDriver().findElement(By.xpath("//label1"));
        textBox.click();
        Thread.sleep(5000);
        textBox.sendKeys("Test 4!");
        Thread.sleep(10000);
    }
}
	
