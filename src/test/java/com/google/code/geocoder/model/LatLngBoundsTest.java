package com.google.code.geocoder.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class LatLngBoundsTest extends Assert {
    @Test
    public void testToUrlValue() throws Exception {
        LatLngBounds latLngBounds;

        latLngBounds = new LatLngBounds(
                new LatLng(new BigDecimal(50.00000001), new BigDecimal(30.0000006)),
                new LatLng(new BigDecimal(50.46068), new BigDecimal(30.507268))
        );

        assertEquals("50.000000,30.000001,50.460680,30.507268", latLngBounds.toUrlValue());
    }
}
