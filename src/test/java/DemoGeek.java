import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class DemoGeek extends BaseClass {
    @Test
    public void demo(){
        openURL("demoGeek");
        String contact = "Roland Mendel";
        String xpathDemo = "//td[normalize-space()='"+contact+"']/parent::tr/td[3]";
        String country = driver.findElement(By.xpath(xpathDemo)).getText();
        System.out.println(country);
    }
}
