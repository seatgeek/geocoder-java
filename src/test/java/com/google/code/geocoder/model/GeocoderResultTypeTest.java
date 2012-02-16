package com.google.code.geocoder.model;

import org.junit.Assert;
import org.junit.Test;

public class GeocoderResultTypeTest extends Assert {

    @Test
    public void testFromValue() throws Exception {
        GeocoderResultType result = GeocoderResultType.fromValue("street_address");
        assertEquals(GeocoderResultType.STREET_ADDRESS, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromValueFail() throws Exception {
        GeocoderResultType result = GeocoderResultType.fromValue("_street_address");
        assertEquals(GeocoderResultType.STREET_ADDRESS, result);
    }
}
