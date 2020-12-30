package com.titowecz.appList;

import com.titowecz.appList.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class ApplicationSpring {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSpring.class, args);
	}
}
