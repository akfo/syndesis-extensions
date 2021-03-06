package io.syndesis.extension.webhook;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "io.syndesis.extension.webook.servlet.enabled", matchIfMissing = true)
@ConditionalOnWebApplication
public class WebhookServletAutoConfiguration {

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean mapping = new ServletRegistrationBean();
        mapping.setServlet(new CamelHttpTransportServlet());
        mapping.addUrlMappings("/webhook/*");
        mapping.setName("CamelServlet");
        mapping.setLoadOnStartup(1);

        return mapping;
    }

}
