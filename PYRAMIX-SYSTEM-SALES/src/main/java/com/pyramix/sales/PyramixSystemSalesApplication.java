package com.pyramix.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({
	"classpath*:ApplicationContext-GuiController.xml"})
public class PyramixSystemSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyramixSystemSalesApplication.class, args);
	}

}
