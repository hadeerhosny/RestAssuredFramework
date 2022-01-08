package GetData;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


public class GetRequest {
	
	@Test
	public void testResponsecode()
	{
		Response resp=RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold");
		
		int code=resp.getStatusCode();
		
		System.out.println("Status code is" +code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void test_Post()
	{	
		JSONObject request = new JSONObject();
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			post("https://petstore.swagger.io/v2/pet").
		then().
			statusCode(200);  
	}


}

