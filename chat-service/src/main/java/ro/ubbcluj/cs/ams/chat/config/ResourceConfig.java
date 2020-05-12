package ro.ubbcluj.cs.ams.chat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
@Data
@Configuration
@EnableResourceServer
@EnableConfigurationProperties
@ConfigurationProperties("spring.datasource")
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    private String url;
    private String username;
    private String password;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
        http.headers()
                .addHeaderWriter(
                        new StaticHeadersWriter("Access-Control-Allow-Origin", "http://localhost:3000")
                );
    }

}