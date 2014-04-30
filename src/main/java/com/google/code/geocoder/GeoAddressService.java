package com.google.code.geocoder;

import com.google.code.geocoder.model.*;

import java.io.IOException;
import java.util.List;

/**
 * This class is used as service class. this class used for
 * searching for geo location points by address which represented as string
 *
 * @author igal
 */
public class GeoAddressService implements GeoSearchableAddress {

    private Geocoder geocoder;

    public GeoAddressService() {
    }

    public GeoAddressService(Geocoder geocoder) {
        this.geocoder = geocoder;
    }

    @Override
    public GeocoderResult getAddress(String address) throws IOException {
        GeocoderRequestBuilder buildQuery = buildQuery(address, null);
        GeocodeResponse geocode = geocoder.geocode(buildQuery.getGeocoderRequest());

        // Filtering geocoding results
        return findMostAccurateGeoCoderResult(geocode);
    }

    @Override
    public GeocoderResult getAddress(String address, String ccTLD) throws IOException {
        GeocoderRequestBuilder buildQuery = buildQuery(address, ccTLD);
        GeocodeResponse geocode = geocoder.geocode(buildQuery.getGeocoderRequest());

        // Filtering geocoding results

        return findMostAccurateGeoCoderResult(geocode);
    }

    private GeocoderRequestBuilder buildQuery(String address, String ccTLD) {
        GeocoderRequestBuilder geocoderRequestBuilder = new GeocoderRequestBuilder().setAddress(address);

        // Adding region param
        if (ccTLD != null && !ccTLD.trim().isEmpty()) {
            geocoderRequestBuilder.setRegion(ccTLD);
        }

        return geocoderRequestBuilder;
    }

    private GeocoderResult findMostAccurateGeoCoderResult(GeocodeResponse geocode) {
        GeocoderResult geocodingResultMostAccurate = null;

        if (geocode != null && geocode.getStatus() == GeocoderStatus.OK) {

            List<GeocoderResult> geocodingResults = geocode.getResults();

            if (geocodingResults.size() != 0) {
                geocodingResultMostAccurate = geocodingResults.get(0);
                GeocoderLocationType locationType = getGeometryLocationType(geocodingResultMostAccurate);

                // Searching all geo coding results
                for (GeocoderResult geocoderResult : geocodingResults) {
                    GeocoderLocationType newLocationType = getGeometryLocationType(geocoderResult);

                    // Comparing location types based on their ordinals
                    if (newLocationType.compareTo(locationType) > 0) {
                        // Found more accurate result
                        locationType = newLocationType;
                        geocodingResultMostAccurate = geocoderResult;
                    }
                }
            }
        }

        return geocodingResultMostAccurate;
    }

    /**
     * Returns the geo location type. Should be one of: ROOFTOP, RANGE_INTERPOLATED, GEOMETRIC_CENTE, APPROXIMATE.
     *
     * @param geocoderResult
     * @return
     */
    private GeocoderLocationType getGeometryLocationType(GeocoderResult geocoderResult) {
        GeocoderLocationType locationType = null;

        GeocoderGeometry geometry = geocoderResult.getGeometry();

        if (geometry != null && geometry.getLocationType() != null) {
            locationType = geometry.getLocationType();
        }

        return locationType;
    }


    @Override
    public LatLng getLatLngPointsByAddress(String address) throws IOException {
        GeocoderResult result = getAddress(address);
        if (result == null)
            return null;
        return result.getGeometry().getLocation();
    }

}
