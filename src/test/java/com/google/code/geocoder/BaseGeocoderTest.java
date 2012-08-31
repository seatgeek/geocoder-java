package com.google.code.geocoder;

import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public abstract class BaseGeocoderTest extends Assert {
    protected static Geocoder geocoder;

    @BeforeClass
    public static void setUp() {
        geocoder = new Geocoder();
    }

}

