package com.google.code.geocoder;

/**
 * Created by IntelliJ IDEA.
 * User: panchmp
 * Date: 9 серп 2010
 * Time: 22:51:36
 * To change this template use File | Settings | File Templates.
 */
public class GeoAddress {
    protected GeocoderLocationType locationType;
    protected String formattedAddress;
    private AddressDetails addressDetails;
    protected LatLng location;
    protected LatLngBounds viewport;
}
