package springreact.hrms;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HumanResourcesManagementSytemApplication {

	@Value(value = "${cloudinary.cloud-name}")
	private String cloudName;

	@Value(value = "${cloudinary.api-key}")
	private String apiKey;

	@Value(value = "${cloudinary.api-secret}")
	private String apiSecret;

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+3:00"));
	}

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesManagementSytemApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("springreact.hrms"))
				.build();
	}

	@Bean
	public Cloudinary cloudinaryConfig() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put("cloud_name", cloudName);
		configMap.put("api_key", apiKey);
		configMap.put("api_secret", apiSecret);
		return new Cloudinary(configMap);
	}
}
