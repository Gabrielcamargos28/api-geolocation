package com.testegeolocation.GeoLocation.config;

import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@Slf4j
public class GeoLocationConfig {
    private static DatabaseReader reader = null;
    private final ResourceLoader resourceLoader;

    public GeoLocationConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public DatabaseReader databaseReader(){
        try {
            log.info("GeoLocationConfig: Trying to load GeoLite2-Country Database...");
            Resource resource = resourceLoader.getResource("classpath:maxmind/GeoLite2-City.mmdb");
            InputStream dbAsStream = resource.getInputStream();

            log.info("GeoLocationConfig: Database was loaded successfully");
            return reader = new DatabaseReader.Builder(dbAsStream)
                    .fileMode(Reader.FileMode.MEMORY)
                    .build();

        } catch (NullPointerException e){
            log.error("");
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
