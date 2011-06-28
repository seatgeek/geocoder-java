package com.google.code.geocoder;

import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GAEGeocoderTest extends GeocoderTest {

    @BeforeClass
    public static void setUp() {
        Geocoder.setConnectionManager(new SimpleHttpConnectionManager());
        geocoder = new Geocoder();
    }

    @AfterClass
    public static void tearDown() {
        Geocoder.setConnectionManager(new MultiThreadedHttpConnectionManager());
    }
}

