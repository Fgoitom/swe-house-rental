package miu.edu;

import miu.edu.config.sysinit.RoleInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class SweHouseRentalApplication /* extends SpringBootServletInitializer */{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SweHouseRentalApplication.class, args);

		// Get the DataSource bean
		DataSource dataSource = context.getBean(DataSource.class);

		// Create an instance of RoleInitializer
		RoleInitializer roleInitializer = new RoleInitializer(dataSource);

		// Run the initialization
		roleInitializer.initializeRoles();
	}

}
