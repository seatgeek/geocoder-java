package com.google.code.geocoder;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class ProxyGeocoderTest extends GeocoderTest {
    @BeforeClass
    public static void setUp() {
        geocoder.getHttpClient().getHostConfiguration().setProxy("41.190.16.17", 8080);
    }

    @AfterClass
    public static void tearDown() {
        geocoder.getHttpClient().getHostConfiguration().setProxyHost(null);
    }
}

