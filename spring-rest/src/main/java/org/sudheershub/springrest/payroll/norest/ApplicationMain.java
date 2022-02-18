package org.sudheershub.springrest.payroll.norest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain {

	private static final Logger log = LoggerFactory.getLogger(ApplicationMain.class);

	public static void main(String... args) throws InterruptedException {
		try {
			log.info("starting application ...");
			SpringApplication.run(ApplicationMain.class, args);
			log.info("running");
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
