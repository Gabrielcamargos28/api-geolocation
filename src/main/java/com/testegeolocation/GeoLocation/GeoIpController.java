package com.testegeolocation.GeoLocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.testegeolocation.GeoLocation.model.GeoIP;
import com.testegeolocation.GeoLocation.service.GeoIPLocationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GeoIpController {

    public final GeoIPLocationService geoIPLocationService;


    public GeoIpController(GeoIPLocationService geoIPLocationService) {
        this.geoIPLocationService = geoIPLocationService;
    }

    @GetMapping("/geoIP/{ipAddress}")
    public GeoIP getLocation (@PathVariable String ipAddress, HttpServletRequest request) throws IOException, GeoIp2Exception {
        return geoIPLocationService.getIpLocation(ipAddress,request);
    }
}
