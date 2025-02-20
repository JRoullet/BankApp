package jroullet83.mscards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
// Properties Object to fill-in and display in the controller by CardConfig
// Cardconfig ( => itself related to the configuration BankApplication_config)
public class Properties {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    public List<String> activeBranches;

    public Properties(String msg, String buildVersion, Map<String, String> mailDetails, List<String> activeBranches) {
        this.msg = msg;
        this.buildVersion = buildVersion;
        this.mailDetails = mailDetails;
        this.activeBranches = activeBranches;
    }
}
