//package jroullet83.msconfigserver.config;
//
//import org.eclipse.jgit.transport.CredentialsProvider;
//import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//// Choose between this config class or the fields in application.yml
//@Configuration
//public class GitConfig {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(GitConfig.class);
//
////    @Value("${GIT_URI}")
////    private String gitURI;
//
////    @Value("${GIT_PASSWORD}")
////    private String password;
////
////    @Value("${GIT_USERNAME}")
////    private String username;
//
////    @Bean
////    public CredentialsProvider credentialsProvider() {
////        String username = System.getenv("GIT_USERNAME");
////        String password = System.getenv("GIT_PASSWORD"); // Password is initialized and needs to be passed as a variable in a String (for example)
//////        logger.info("Git URI: {}", gitURI);
////        logger.info("Using Git username: {}", username);
////        logger.info("Using Git password: {}", password != null ? "***" : "null");
////        return new UsernamePasswordCredentialsProvider(username, password);
////    }
//
////    @Bean
////    public TransportConfigCallback transportConfigCallback(CredentialsProvider credentialsProvider) {
////        return transport -> transport.setCredentialsProvider(credentialsProvider);
////    }
//
//
//}