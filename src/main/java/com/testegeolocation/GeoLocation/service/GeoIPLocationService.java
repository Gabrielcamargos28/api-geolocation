package com.testegeolocation.GeoLocation.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.testegeolocation.GeoLocation.model.GeoIP;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface GeoIPLocationService {
    GeoIP getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception;
}
