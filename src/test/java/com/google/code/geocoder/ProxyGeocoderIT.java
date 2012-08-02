package com.google.code.geocoder;

import org.junit.BeforeClass;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ProxyGeocoderIT extends GeocoderIT {
    @BeforeClass
    public static void setUp() {
        final AdvancedGeoCoder advancedGeoCoder = new AdvancedGeoCoder();
        advancedGeoCoder.getHttpClient().getHostConfiguration().setProxy("41.190.16.17", 8080);
        geocoder = advancedGeoCoder;
    }
}

