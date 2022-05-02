package com.lnct.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextInstanceDataAutoConfiguration.class, ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
public class LncTnewsPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LncTnewsPortalApplication.class, args);
	}

}
