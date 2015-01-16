package com.knightrider.GuiceBerry_Injection_Using_TestNg;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.testing.TearDown;
import com.google.guiceberry.testng.TestNgGuiceBerry;
import com.google.inject.Inject;

public class InjectionVerifyTest {

	private TearDown toTearDown;

	@Inject
	Properties applicationProperties;
	
	@BeforeMethod
	public void setUp(Method m) {
		toTearDown = TestNgGuiceBerry.setUp(this, m,
				GuiceBerryEnvironment.class);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		toTearDown.tearDown();

	}

	@Test
	public void demoTest() {
		if(!applicationProperties.getProperty("message").isEmpty())
			System.out.println("Hurray injection done : ) "+applicationProperties.getProperty("message"));
		else
			System.out.println("Never going to print this if everything works fine.. :-) ");
	}

}
