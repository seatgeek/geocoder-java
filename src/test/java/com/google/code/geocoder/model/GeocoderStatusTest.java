package com.google.code.geocoder.model;

import org.junit.Assert;
import org.junit.Test;


public class GeocoderStatusTest extends Assert {
    @Test
    public void testFromValue() throws Exception {
        GeocoderStatus result;

        result = GeocoderStatus.valueOf("OK");
        assertEquals(GeocoderStatus.OK, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromValueFail() throws Exception {
        GeocoderStatus result;

        result = GeocoderStatus.valueOf("ok");
        assertEquals(GeocoderStatus.OK, result);
    }
}
