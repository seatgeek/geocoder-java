package com.google.code.geocoder;

import org.junit.BeforeClass;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ProxyGeocoderIT extends GeocoderIT {
    @BeforeClass
    public static void setUp() {
        final AdvancedGeoCoder advancedGeoCoder = new AdvancedGeoCoder();
        advancedGeoCoder.getHttpClient().getHostConfiguration().setProxy("85.25.109.152", 3128);
        geocoder = advancedGeoCoder;
    }
}

