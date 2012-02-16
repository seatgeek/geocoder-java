package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.LatLng;
import com.google.code.geocoder.model.LatLngBounds;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocoderTest extends BaseGeocoderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreationClientIdFail() throws Exception {
        new Geocoder("someClientId", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationClientKeyFail() throws Exception {
        new Geocoder("", "someClientKey");
    }

    @Test
    public void testURL() throws Exception {
        String res;

        res = geocoder.getURL(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("fr").getGeocoderRequest());

        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=fr", res);

        res = geocoder.getURL(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").setRegion("fr").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=en&region=fr", res);


        res = geocoder.getURL(new GeocoderRequestBuilder().setAddress("Winnetka").setBounds(new LatLngBounds(new LatLng("34.172684", "-118.604794"), new LatLng("34.236144", "-118.500938"))).getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Winnetka&bounds=34.172684%2C-118.604794%7C34.236144%2C-118.500938", res);
    }

    @Test
    public void testGeocode() throws Exception {
        GeocodeResponse geocoderResponse;

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("fr").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").setRegion("fr").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").setRegion("fr").setBounds(new LatLngBounds(new LatLng("49.01", "2.51"), new LatLng("48.02", "2.03"))).getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Germany, Munich").setLanguage("en").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Бровари, вул. Київська 17").setLanguage("uk").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Дніпропетровськ, ул. Артема 28").setLanguage("uk").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("中国上海安化路").setLanguage("zn").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Odessa, TX").getGeocoderRequest());
        assertNotNull(geocoderResponse);
    }
}

