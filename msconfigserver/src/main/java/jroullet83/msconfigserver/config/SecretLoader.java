package jroullet83.msconfigserver.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class SecretLoader {

    @PostConstruct
    public void loadSecrets() {
        try {
            setSecret("GIT_URI", "/run/secrets/git_uri");
            setSecret("GIT_USERNAME", "/run/secrets/git_username");
            setSecret("GIT_PASSWORD", "/run/secrets/git_password");
        } catch (IOException e) {
            // Catch exception if files are not found
            System.err.println("Secret files not found. Make sure you are running in a Docker environment with secrets configured.");
        }
    }

    private void setSecret(String key, String filePath) throws IOException {
        String value = new String(Files.readAllBytes(Paths.get(filePath))).trim();
        System.setProperty(key, value);
    }
}
