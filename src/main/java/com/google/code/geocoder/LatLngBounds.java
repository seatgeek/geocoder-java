package com.google.code.geocoder;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class LatLngBounds {
    private LatLng southwest, northeast;

    public LatLng getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LatLng southwest) {
        this.southwest = southwest;
    }

    public LatLng getNortheast() {
        return northeast;
    }

    public void setNortheast(LatLng northeast) {
        this.northeast = northeast;
    }
}