import utilities.BaseClass;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestDemoSugarBox extends BaseClass {

    @Test(enabled = true)
    public void testDemoSugarBoxSelenium(){
        openURL("urlSugarBox");
        String apiEndpoint = driver.findElement(By.xpath("//span[normalize-space()='Example 1 (Search by Postal PIN Code):']/parent::p/following-sibling::p[2]/a")).getAttribute("href");
        given().when().get(apiEndpoint).then().log().all();
        driver.navigate().to("https://api.postalpincode.in/pincode/110001");
    }

    @Test(enabled = true)
    public void testDemoSugarBoxRestAssured(){
        RestAssured.baseURI = "https://api.postalpincode.in";
        String message = given().when().get("/pincode/110001").then().extract().jsonPath().getString("Message");
        System.out.println(message);
    }

    @Test(enabled = true)
    public void testDemoSugarBoxAppium(){

    }

}
