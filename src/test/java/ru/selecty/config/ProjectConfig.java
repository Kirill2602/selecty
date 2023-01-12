package ru.selecty.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface ProjectConfig extends Config {
    @Key("isRemote")
    Boolean getIsRemote();

    @Key("browserSize")
    String getBrowserSize();

    @Key("baseUrl")
    String getBaseUrl();
}
