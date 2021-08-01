package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities {
	public static RequestSpecification baseDetailsReq;
	public RequestSpecification RequestSpecificationDetails() throws IOException {
		if (baseDetailsReq == null)
		{
		   PrintStream log = new PrintStream(new FileOutputStream("logFile.txt"));
		   baseDetailsReq=new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURI")).addQueryParam("key","qaclick123")
				   .addFilter(RequestLoggingFilter.logRequestTo(log))
				   .addFilter(ResponseLoggingFilter.logResponseTo(log))
				   .setContentType(ContentType.JSON).build();
		   	 
		}
		  return baseDetailsReq;
	}
   public static String  getGlobalValues(String key) throws IOException {
	   Properties prop= new Properties();
	   FileInputStream fileInput=new FileInputStream("C:\\Discount Central\\Automation\\APIFramework\\src\\test\\java\\Resources\\global.properties");
	   prop.load(fileInput);
	   return prop.getProperty(key);
	   
   }
   
   public static String getJsonValue(Response response,String key)
   {
	   String str = response.asString();
	    JsonPath js = new JsonPath(str);
	    return js.get(key).toString();
	   
   }
}
