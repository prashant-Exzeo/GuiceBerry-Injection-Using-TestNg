package com.knightrider.GuiceBerry_Injection_Using_TestNg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.guiceberry.GuiceBerryEnvMain;
import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * 
 * @author prashant
 * 
 */
@Singleton
public class GuiceBerryEnvironment extends AbstractModule {

	private static Properties applicationProperties = null;

	@Override
	protected void configure() {
		InputStream inputStream = this.getClass()
											.getClassLoader()
												.getResourceAsStream("application.properties");

		applicationProperties = new Properties();
		try {
			applicationProperties.load(inputStream);
			install(new GuiceBerryModule());
			bind(GuiceBerryEnvMain.class).to(AppInitializer.class);
			bind(Properties.class).toInstance(applicationProperties);
		} catch (IOException e) {
			System.out.println("Something went Wrong :(");
			e.printStackTrace();
		}

	}

	static class AppInitializer implements GuiceBerryEnvMain {
		public void run() {
			System.out.println("Initializing application .....  :) ");
		}

	}

}
