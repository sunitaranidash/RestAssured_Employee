package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase{
@BeforeClass
void getAllEmployees() throws InterruptedException
{
	logger.info("*********** Started TC001_Get_All_Employees   ********");
	RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	httpRequest=RestAssured.given();
	response=httpRequest.request(Method.GET,"/employees");
Thread.sleep(3000);	
}
//validation of headers
@Test
void checkResponseBody()
{
	logger.info("**** Checking Response Body ****");
	String responseBody=response.getBody().asString();
	logger.info(("Response Body==>"+responseBody));
	Assert.assertTrue(responseBody!=null);
	
}
void checkStatusCode()
{
	logger.info("**** Checking Status code ****");
	int statusCode=response.getStatusCode();
	logger.info(("Status Code is ==>"+statusCode));
	Assert.assertEquals(statusCode, 200);
	
}
@AfterClass
void tearDown()
{
	logger.info("*********** Finished TC001_Get_All_Employees   ********");
}

}
