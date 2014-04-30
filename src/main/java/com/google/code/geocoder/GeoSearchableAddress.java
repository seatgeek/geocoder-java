package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

import java.io.IOException;

/**
 * Interface which specifies search operations that can be done using an address
 */
public interface GeoSearchableAddress {

    /**
     * This method receives address as string and returns
     * GeocoderResult for the given address
     *
     * @param address being looked for
     * @return geocoder result
     */
    abstract GeocoderResult getAddress(String address) throws IOException;

    /**
     * This method receives address as string input and
     * country code top-level domain (ccTLD) that is used to indicate the region
     * and returns GeocoderResult
     *
     * @param address being looked for
     * @param ccTld   - country code top-level domain
     * @return geocoder result
     */
    abstract GeocoderResult getAddress(String address, String ccTld) throws IOException;

    /**
     * This method receives address as string input and
     * and returns a LatLng object which represents this address
     *
     * @param address
     * @return
     */
    abstract LatLng getLatLngPointsByAddress(String address) throws IOException;

}
