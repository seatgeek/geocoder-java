package com.google.code.geocoder.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class LatLngTest extends Assert {
    @Test
    public void testToUrlValue() throws Exception {
        LatLng latLng;

        latLng = new LatLng(new BigDecimal(50), new BigDecimal(30));
        assertEquals("50.000000,30.000000", latLng.toUrlValue());

        latLng = new LatLng(new BigDecimal(50.00000001), new BigDecimal(30.0000006));
        assertEquals("50.000000,30.000001", latLng.toUrlValue());

        latLng = new LatLng(new BigDecimal(50.46068), new BigDecimal(30.507268));
        assertEquals("50.46,30.51", latLng.toUrlValue(2));
    }
}
