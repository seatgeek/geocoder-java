package com.google.code.geocoder;


/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocoderGeometry {
    protected LatLng location;
    protected GeocoderLocationType locationType;
    protected LatLngBounds viewport;

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public GeocoderLocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(GeocoderLocationType locationType) {
        this.locationType = locationType;
    }

    public LatLngBounds getViewport() {
        return viewport;
    }

    public void setViewport(LatLngBounds viewport) {
        this.viewport = viewport;
    }
}