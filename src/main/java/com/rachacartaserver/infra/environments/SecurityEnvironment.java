package com.rachacartaserver.infra.environments;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cust.data.secutiry")
public class SecurityEnvironment {
    private String privateKey;
    private String algorithm;
    private  long expirationInHours;


    public long getExpirationInHours() {
        return expirationInHours;
    }

    public void setExpirationInHours(long expirationInHours) {
        this.expirationInHours = expirationInHours;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

}
