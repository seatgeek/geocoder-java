package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.InvalidKeyException;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class AdvancedGeoCoder extends Geocoder {
    private static HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());

    public AdvancedGeoCoder() {
    }

    public AdvancedGeoCoder(final String clientId, final String clientKey) throws InvalidKeyException {
        super(clientId, clientKey);
    }

    public synchronized HttpClient getHttpClient() {
        return httpClient;
    }

    protected GeocodeResponse request(Gson gson, String urlString) throws IOException {
        final GetMethod getMethod = new GetMethod(urlString);
        try {
            httpClient.executeMethod(getMethod);
            final Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());

            return gson.fromJson(reader, GeocodeResponse.class);
        } finally {
            getMethod.releaseConnection();
        }
    }
}