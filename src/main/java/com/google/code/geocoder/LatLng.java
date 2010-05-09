package com.google.code.geocoder;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class LatLng {
    private BigDecimal lat, lng;

    public LatLng() {
    }

    public LatLng(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }


}