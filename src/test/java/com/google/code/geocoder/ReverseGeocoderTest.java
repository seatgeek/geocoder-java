package com.google.code.geocoder;

import com.google.code.geocoder.model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ReverseGeocoderTest extends Assert {
    private static Geocoder geocoder;

    @BeforeClass
    public static void setUp() {
        geocoder = new Geocoder();
    }

    @Test
    public void testURL() throws Exception {
        String res;

        res = geocoder.getURL(new GeocoderRequestBuilder().setLocation(new LatLng("40.714224", "-73.961452")).getGeocoderRequest());
        assertEquals(res, "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452");

        res = geocoder.getURL(new GeocoderRequestBuilder().setLocation(new LatLng("40.714224", "-73.961452")).setLanguage("en").getGeocoderRequest());
        assertEquals(res, "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452&language=en");
    }

    @Test
    public void testGeocode() throws Exception {
        GeocoderRequest geocoderRequest;
        GeocodeResponse geocoderResponse;

        //http://code.google.com/intl/uk/apis/maps/documentation/geocoding/#ReverseGeocoding
        geocoderRequest = new GeocoderRequestBuilder().setLocation(new LatLng("40.714224", "-73.961452")).setLanguage("en").getGeocoderRequest();
        geocoderResponse = geocoder.geocode(geocoderRequest);
        assertNotNull(geocoderResponse);
        assertEquals(GeocoderStatus.OK, geocoderResponse.getStatus());
        assertFalse(geocoderResponse.getResults().isEmpty());

        final GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();
        assertTrue(geocoderResult.getTypes().contains(GeocoderResultType.STREET_ADDRESS.value()));
    }
}