package com.google.code.geocoder;

import java.util.List;

import javax.annotation.PostConstruct;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.GeocoderLocationType;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

public class GeoAddressService implements GeoSearchableAddress{
	
	private static Geocoder geocoder;
	
	@PostConstruct
	public void initializeProperties() {
		geocoder = new Geocoder();
	}
	
	@Override
	public GeocoderResult getAddress(String address) {
		GeocoderRequestBuilder buildQuery = buildQuery(address, null);
		GeocodeResponse geocode = geocoder.geocode(buildQuery.getGeocoderRequest());
		
		 // Filtering geocoding results
		GeocoderResult filteredGeoCodingResult = findMostAccurateGeoCoderResult(geocode);
		
		return filteredGeoCodingResult;
	}

	/**
	 * This method gets address string and uses google service to find more details about this address
	 * using ccTLD
	 * @param address 
	 * @param ccTLD country code top-level domain
	 * @return tmss address object
	 */
	@Override
	public GeocoderResult getAddress(String address, String ccTLD){
		GeocoderRequestBuilder buildQuery = buildQuery(address, ccTLD);
		GeocodeResponse geocode = geocoder.geocode(buildQuery.getGeocoderRequest());
		
		 // Filtering geocoding results
		GeocoderResult filteredGeoCodingResult = findMostAccurateGeoCoderResult(geocode);
        
		return filteredGeoCodingResult;
	}

	private GeocoderRequestBuilder buildQuery(String address, String ccTLD) {
		GeocoderRequestBuilder geocoderRequestBuilder 
			= new GeocoderRequestBuilder().setAddress(address);
        
        // Adding region param
        if(ccTLD != null && !ccTLD.trim().isEmpty()) {
        	geocoderRequestBuilder.setRegion(ccTLD);
        }
        
        return geocoderRequestBuilder;
	}

	private GeocoderResult findMostAccurateGeoCoderResult(GeocodeResponse geocode) {
		GeocoderResult geocodingResultMostAccurate = null;
		
		if (geocode != null && geocode.getStatus() == GeocoderStatus.OK){
			
			List<GeocoderResult> geocodingResults = geocode.getResults();
			
			if(geocodingResults.size() != 0){
				 geocodingResultMostAccurate = geocodingResults.get(0);
				 GeocoderLocationType locationType = getGeometryLocationType(geocodingResultMostAccurate);
				 
				 // Searching all geo coding results
				 for (GeocoderResult geocoderResult : geocodingResults) {
					 GeocoderLocationType newLocationType = getGeometryLocationType(geocoderResult);
					 
					 // Comparing location types based on their oridinals
					 if(newLocationType.compareTo(locationType) > 0) {
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
	 * @param geocodingResult
	 * @return
	 */
	private GeocoderLocationType getGeometryLocationType(GeocoderResult geocoderResult) {
		GeocoderLocationType locationType = null;
		
		GeocoderGeometry geometry = geocoderResult.getGeometry();
		 
		 if(geometry != null && geometry.getLocationType() != null) {
			 locationType = geometry.getLocationType();
		 }
		 
		 return locationType;
	}
	
	/**
	 * This method get address string as param and returns geolocation which contains the 
	 * lattitude and longitude points of the geo location
	 * @param address to be find
	 * @return geo location points
	 */
	@Override
	public LatLng getLatLngPointsByAddress(String address) {
		GeocoderResult result = getAddress(address);
		if (result == null)
			return null;
		return result.getGeometry().getLocation();
	}

}
