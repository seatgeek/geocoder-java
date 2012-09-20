package com.google.code.geocoder;

import com.google.code.geocoder.model.LatLng;

public interface GeoSearchableAddress {
	
	
	public abstract Object getAddress(String address);
	
	/**
	 * This method receives address as string input and  
	 * country code top-level domain (ccTLD) that is used for region
	 * @param address
	 * @param ccTld - country code top-level domain
	 * @return
	 */
	public abstract Object getAddress(String address, String ccTld);
	
	public abstract LatLng getLatLngPointsByAddress(String address);

}
