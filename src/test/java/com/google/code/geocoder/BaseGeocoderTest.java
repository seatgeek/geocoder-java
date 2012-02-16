package com.google.code.geocoder;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class BaseGeocoderTest extends Assert {
    protected static Geocoder geocoder;

    @BeforeClass
    public static void setUp() {
        geocoder = new Geocoder();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreationFail() throws Exception {
        Geocoder result = new Geocoder(null, "");
    }
}

