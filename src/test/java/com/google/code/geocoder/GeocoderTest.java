package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocoderComponent;
import com.google.code.geocoder.model.LatLng;
import com.google.code.geocoder.model.LatLngBounds;
import org.junit.Test;

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
    public void testURLParams() throws Exception {
        String res;

        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Paris, France").setChannel("test").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&channel=test&address=Paris%2C+France", res);

        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("fr").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=fr", res);

        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").setRegion("fr").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Paris%2C+France&language=en&region=fr", res);
    }

    @Test
    public void testURLBounds() throws Exception {
        String res;
        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Winnetka").setBounds(new LatLngBounds(new LatLng("34.172684", "-118.604794"), new LatLng("34.236144", "-118.500938"))).getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Winnetka&bounds=34.172684%2C-118.604794%7C34.236144%2C-118.500938", res);
    }

    @Test
    public void testURLComponents() throws Exception {
        String res;

        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Torun").addComponent(GeocoderComponent.ADMINISTRATIVE_AREA, "TX").addComponent(GeocoderComponent.COUNTRY, "US").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Torun&components=administrative_area:TX%7Ccountry:US", res);

        res = GeocoderIT.geocoder.getURL(new GeocoderRequestBuilder().setAddress("Torun").addComponent(GeocoderComponent.ADMINISTRATIVE_AREA, "TX").addComponent(GeocoderComponent.COUNTRY, "FR").getGeocoderRequest());
        assertEquals("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=Torun&components=administrative_area:TX%7Ccountry:FR", res);
    }
}