package com.google.code.geocoder.model;

/**
 * Components used for geocoding queries.
 *
 * @author <a href="mailto:cesar@caih.org">César Izurieta</a>
 */
public enum GeocoderComponent {
    ROUTE("route"),
    LOCALITY("locality"),
    ADMINISTRATIVE_AREA("administrative_area"),
    POSTAL_CODE("postal_code"),
    COUNTRY("country");

    private final String value;

    GeocoderComponent(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GeocoderComponent fromValue(final String v) {
        for (GeocoderComponent c : GeocoderComponent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
