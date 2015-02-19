package com.google.code.geocoder;

public interface GeocoderLogger {
    public static final GeocoderLogger NOP_LOGGER = new GeocoderLogger() {
        @Override
        public void log(String message) {
            // NO-OP
        }
    };

    void log(String message);
}
