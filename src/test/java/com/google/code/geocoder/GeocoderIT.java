package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.LatLng;
import com.google.code.geocoder.model.LatLngBounds;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocoderIT extends BaseGeocoderTest {

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

