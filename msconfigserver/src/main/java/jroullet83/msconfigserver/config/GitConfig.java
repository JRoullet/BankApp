package jroullet83.msconfigserver.config;

import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitConfig {

    @Bean
    public CredentialsProvider credentialsProvider() {
        return new UsernamePasswordCredentialsProvider("YOUR USERNAME", "YOUR PASSWORD");
    }

    @Bean
    public TransportConfigCallback transportConfigCallback(CredentialsProvider credentialsProvider) {
        return transport -> transport.setCredentialsProvider(credentialsProvider);
    }
}