package GetData;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
	public static void test_Post()
	{	
		String requestbody = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"dogg2\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		String Responsebody = given().
			when().
			contentType(ContentType.JSON).
			body(requestbody).
			post("https://petstore.swagger.io/v2/pet").
		then().
			statusCode(200).extract().asString();  
		System.out.println(Responsebody);

	}


}

