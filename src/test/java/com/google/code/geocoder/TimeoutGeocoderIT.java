package com.google.code.geocoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.BeforeClass;


/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class TimeoutGeocoderIT extends GeocoderIT {
    @BeforeClass
    public static void setUp() {
        final HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
        httpClient.getHostConfiguration().setProxy("85.25.109.152", 3128);
        httpClient.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60 * 1000);

        geocoder = new AdvancedGeoCoder(httpClient);
    }
}
