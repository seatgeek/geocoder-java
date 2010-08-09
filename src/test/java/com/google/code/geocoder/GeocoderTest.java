package com.google.code.geocoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocoderTest extends Assert {
    @Test
    public void testGeocod() throws Exception {
        final Geocoder geocoder = new Geocoder();

        String res;

        res = geocoder.getURL(new GeocoderRequest("Paris, France", "fr"));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=fr");

        res = geocoder.getURL(new GeocoderRequest("Paris, France", "en", "fr"));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=en&region=fr");

        res = geocoder.getURL(new GeocoderRequest("Paris, France", "en", "fr", new LatLngBounds(new LatLng("49.01", "2.51"), new LatLng("48.02", "2.03"))));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=en&region=fr&bounds=48.02%2C2.03%7C49.01%2C2.51");

        res = geocoder.getURL(new GeocoderRequest(new LatLng("40.714224", "-73.961452")));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452");

        res = geocoder.getURL(new GeocoderRequest(new LatLng("40.714224", "-73.961452"), "en"));
        assertEquals(res, "http://maps.google.com/maps/api/geocode/json?sensor=false&latlng=40.714224%2C-73.961452&language=en");
    }

    @Test
    public void testGeocode() throws Exception {
        final Geocoder geocoder = new Geocoder();

        GeocodeResponse geocoderResponse;

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Paris, France", "fr"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Paris, France", "en", "fr"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Paris, France", "en", "fr", new LatLngBounds(new LatLng("49.01", "2.51"), new LatLng("48.02", "2.03"))));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest(new LatLng("40.714224", "-73.961452")));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest(new LatLng("40.714224", "-73.961452"), "en"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Germany, Munich", "en"));
        assertNotNull(geocoderResponse);

        //my home :)
        geocoderResponse = geocoder.geocode(new GeocoderRequest("Київ, вул. Челябінська 17, кв 3", "uk"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Бровари, вул. Київська 17", "uk"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Дніпропетровськ, ул. Артема 28, кв 35", "uk"));
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequest("Odessa, TX", null, null, null));
        assertNotNull(geocoderResponse);
    }
}

