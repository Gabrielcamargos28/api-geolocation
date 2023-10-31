package com.testegeolocation.GeoLocation.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class GeoIP {

    private String ipAddress;
    private String device;
    private String city;
    private String fullLocation;
    private Double latitude;
    private Double longitude;

}