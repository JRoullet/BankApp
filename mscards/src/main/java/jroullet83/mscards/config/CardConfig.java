package jroullet83.mscards.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
// Links to ms-cards configuration file in BankApplication_config
@ConfigurationProperties(prefix = "ms-cards")
@Getter
@Setter
@ToString
// Refresh configuration changes with 1 refresh endpoint
@RefreshScope
public class CardConfig {

    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    public List<String> activeBranches;

}
