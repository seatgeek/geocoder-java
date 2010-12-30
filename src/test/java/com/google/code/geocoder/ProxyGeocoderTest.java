package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.LatLng;
import com.google.code.geocoder.model.LatLngBounds;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ProxyGeocoderTest extends Assert {
    private static Geocoder geocoder;

    @BeforeClass
    public static void setUp() {
        geocoder = new Geocoder();
        geocoder.getHttpClient().getHostConfiguration().setProxy("220.231.93.41", 80);
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

        //my home :)
        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Київ, вул. Челябінська 17, кв 3").setLanguage("uk").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Бровари, вул. Київська 17").setLanguage("uk").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Дніпропетровськ, ул. Артема 28, кв 35").setLanguage("uk").getGeocoderRequest());
        assertNotNull(geocoderResponse);

        geocoderResponse = geocoder.geocode(new GeocoderRequestBuilder().setAddress("Odessa, TX").getGeocoderRequest());
        assertNotNull(geocoderResponse);
    }
}

