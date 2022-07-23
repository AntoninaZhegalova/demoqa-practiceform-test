package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials_properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
