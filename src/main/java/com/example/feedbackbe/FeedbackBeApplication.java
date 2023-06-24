package com.example.feedbackbe;

import com.example.feedbackbe.client.platform.PlatformUserClient;
import com.example.feedbackbe.client.tenant.TenantClient;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.model.user.DiscourseUser;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.service.platform.registration.UserRegistrationServiceImpl;
import com.example.feedbackbe.utils.TenantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackBeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackBeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

