package com.google.code.geocoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocoderTest extends Assert {
    @Test
    public void testGeocode() throws Exception {
        final Geocoder geocoder = new Geocoder();

        GeocodeResponse geocoderResponse;

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Київ, вул. Челябінська 17", "uk"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Бровари, вул. Київська 118", "uk"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("2, Гагаріна просп., Кривий Ріг", "uk"));
        assertNotNull(geocoderResponse);
    }
}

