package com.google.code.geocoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ReverseGeocoderTest extends Assert {
    @Test
    public void testGeocod() throws Exception {
        final Geocoder geocoder = new Geocoder();

        String res;

        res = geocoder.getURL(new GeocoderRequest(new LatLng("40.714224", "-73.961452")));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452");

        res = geocoder.getURL(new GeocoderRequest(new LatLng("40.714224", "-73.961452"), "en"));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452&language=en");
    }

    @Test
    public void testGeocode() throws Exception {
        final Geocoder geocoder = new Geocoder();
        GeocodeResponse geocoderResponse;

        //http://code.google.com/intl/uk/apis/maps/documentation/geocoding/#ReverseGeocoding
        geocoderResponse = geocoder.geocode(new GeocoderRequest(new LatLng("40.714224", "-73.961452"), "en"));
        assertNotNull(geocoderResponse);
        assertEquals(geocoderResponse.getStatus(), GeocoderStatus.OK);
        assertFalse(geocoderResponse.getResults().isEmpty());

        final GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();
        assertTrue(geocoderResult.getTypes().contains(GeocoderResultType.STREET_ADDRESS.value()));
    }
}