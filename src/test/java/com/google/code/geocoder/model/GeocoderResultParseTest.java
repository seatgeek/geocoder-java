package com.google.code.geocoder.model;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeocoderResultParseTest extends Assert {

	@Test
	public void testDeseralization() throws Exception {
		GeocodeResponse expected = new GeocodeResponse();
		expected.setStatus(GeocoderStatus.OK);
		
		GeocoderResult result = new GeocoderResult();
		result.setPartialMatch(true);
		result.setTypes(Arrays.asList("street_address"));
		result.setAddressComponents(Arrays.asList(
				newComponent("17200", "17200", "street_number")
				,newComponent("Farm to Market 3005", "Farm to Market 3005", "route")
				,newComponent("Galveston", "Galveston", "locality", "political")
				,newComponent("Galveston", "Galveston", "administrative_area_level_2", "political")
				,newComponent("TX", "Texas", "administrative_area_level_1", "political")
				,newComponent("US", "United States", "country", "political")
				,newComponent("77554", "77554", "postal_code")
				));
		result.setFormattedAddress("17200 Farm to Market 3005, Galveston, TX 77554, USA");
		GeocoderGeometry geometry = new GeocoderGeometry();
		geometry.setLocationType(GeocoderLocationType.RANGE_INTERPOLATED);
		geometry.setLocation(new LatLng("29.25060640", "-94.85419549999999"));
		geometry.setBounds(new LatLngBounds(new LatLng("29.25059310", "-94.85419549999999"), new LatLng("29.25060640", "-94.85418519999999")));
		geometry.setViewport(new LatLngBounds(new LatLng("29.24925076970850", "-94.85553933029151"), new LatLng("29.25194873029150", "-94.85284136970850")));
		result.setGeometry(geometry);

		expected.setResults(Arrays.asList(result));
		
		assertParsedResponse("src/test/resources/gavelston.json", expected);
	}

	private void assertParsedResponse(String filename, GeocodeResponse expected) throws Exception {
		InputStreamReader file = new InputStreamReader(new FileInputStream(filename), "UTF-8");
		final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		GeocodeResponse response = gson.fromJson(file, GeocodeResponse.class);
		assertNotNull(response);
		assertEquals(expected, response);
	}
	
	private GeocoderAddressComponent newComponent(String shortName, String longName, String ... types) {
		GeocoderAddressComponent c = new GeocoderAddressComponent();
		c.setShortName(shortName);
		c.setLongName(longName);
		c.setTypes(Arrays.asList(types));
		return c;
	}
}
