package ru.selecty.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${env}.properties"})

public interface ProjectConfig extends Config {
    @Key("isRemote")
    Boolean getIsRemote();

    @Key("remote")
    String getRemote();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("timeout")
    Long getTimeout();
}
