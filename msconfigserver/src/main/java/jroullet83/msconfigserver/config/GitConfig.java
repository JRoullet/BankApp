package jroullet83.msconfigserver.config;

import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Choose between this config class or the fields in application.yml
@Configuration
public class GitConfig {

    @Bean
    public CredentialsProvider credentialsProvider() {
        String username = System.getenv("GIT_USERNAME");
        String password = System.getenv("GIT_PASSWORD"); // Password is initialized and needs to be passed as a variable in a String (for example)
        return new UsernamePasswordCredentialsProvider(username, password);
    }

    @Bean
    public TransportConfigCallback transportConfigCallback(CredentialsProvider credentialsProvider) {
        return transport -> transport.setCredentialsProvider(credentialsProvider);
    }

}