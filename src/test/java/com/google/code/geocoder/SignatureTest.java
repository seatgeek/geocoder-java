package com.google.code.geocoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignatureTest extends Geocoder {

    @Test
    public void testSignature() throws Exception {
        Geocoder geocoder = new Geocoder("clientID", "vNIXE0xscrmjlyV-12Nj_BvUPaw=");
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-000"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-001"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-002"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-003"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-004"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-005"));

        StringBuilder url = new StringBuilder("/maps/api/geocode/json?address=New+York&sensor=false");
        geocoder.addClientIdAndSignURL(url);
        assertEquals("/maps/api/geocode/json?address=New+York&sensor=false&client=clientID&signature=KrU1TzVQM7Ur0i8i7K3huiw3MsA=", url.toString());
    }


    @Test
    public void testAdvSignature() throws Exception {
        Geocoder geocoder = new AdvancedGeoCoder("clientID", "vNIXE0xscrmjlyV-12Nj_BvUPaw=");
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-000"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-001"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-002"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-003"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-004"));
        geocoder.addClientIdAndSignURL(new StringBuilder("Some data to test re-usage of signer: bla-bla-005"));

        StringBuilder url = new StringBuilder("/maps/api/geocode/json?address=New+York&sensor=false");
        geocoder.addClientIdAndSignURL(url);
        assertEquals("/maps/api/geocode/json?address=New+York&sensor=false&client=clientID&signature=KrU1TzVQM7Ur0i8i7K3huiw3MsA=", url.toString());
    }
}