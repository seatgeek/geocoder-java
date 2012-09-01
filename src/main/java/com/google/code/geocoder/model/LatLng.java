package com.google.code.geocoder.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 * @link http://code.google.com/intl/uk/apis/maps/documentation/javascript/reference.html#LatLng
 */
public class LatLng implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_PRECISION = 6;

    private BigDecimal lat, lng;

    public LatLng() {
    }

    public LatLng(final BigDecimal lat, final BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LatLng(final String lat, final String lng) {
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

    /**
     * @return Returns a string of the form "lat,lng" for this LatLng. We round the lat/lng values to 6 decimal places by default.
     */
    public String toUrlValue() {
        return toUrlValue(DEFAULT_PRECISION);
    }

    /**
     * @param precision We round the lat/lng values
     * @return Returns a string of the form "lat,lng" for this LatLng.
     */
    public String toUrlValue(int precision) {
        return lat.setScale(precision, BigDecimal.ROUND_HALF_EVEN).toString() + "," + lng.setScale(precision, BigDecimal.ROUND_HALF_EVEN).toString();
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

    @Override
    public String toString() {
        return "LatLng{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }


}