package com.google.code.geocoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
@Ignore
public class ProxyGeocoderIT extends GeocoderIT {
    @BeforeClass
    public static void setUp() {
        final HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
        httpClient.getHostConfiguration().setProxy("85.25.109.152", 3128);

        geocoder = new AdvancedGeoCoder(httpClient, GeocoderLogger.NOP_LOGGER);
    }
}

