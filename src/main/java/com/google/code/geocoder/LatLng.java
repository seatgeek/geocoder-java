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

    public LatLng(String lat, String lng) {
        this.lat = new BigDecimal(lat);
        this.lng = new BigDecimal(lng);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LatLng latLng = (LatLng) o;

        if (lat != null ? !lat.equals(latLng.lat) : latLng.lat != null) return false;
        if (lng != null ? !lng.equals(latLng.lng) : latLng.lng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lat != null ? lat.hashCode() : 0;
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        return result;
    }

    public String toString() {
        return lat.toString() + "," + lng.toString();
    }
}