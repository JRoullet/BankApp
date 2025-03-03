package jroullet83.msconfigserver.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvLoader {

    private static final Logger logger = LoggerFactory.getLogger(EnvLoader.class);

    public static void load() {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
//            logger.info("Loaded environment variable: {}={}", entry.getKey(), entry.getValue());
        });
    }
}
