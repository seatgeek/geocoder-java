package com.google.code.geocoder;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class LatLngBounds {
    private LatLng southwest, northeast;

    public LatLngBounds() {
    }

    public LatLngBounds(final LatLng southwest, final LatLng northeast) {
        this.southwest = southwest;
        this.northeast = northeast;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LatLngBounds that = (LatLngBounds) o;

        if (northeast != null ? !northeast.equals(that.northeast) : that.northeast != null) return false;
        if (southwest != null ? !southwest.equals(that.southwest) : that.southwest != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = southwest != null ? southwest.hashCode() : 0;
        result = 31 * result + (northeast != null ? northeast.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return northeast.toString() + '|' + southwest.toString();
    }
}