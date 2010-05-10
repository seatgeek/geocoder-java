package com.google.code.geocoder;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class Geocoder {
    private Log log = LogFactory.getLog(Geocoder.class);

    private static final String GEOCODE_REQUEST_URL = "http://maps.google.com/maps/api/geocode/json?sensor=false";
    private static final HttpClient HTTP_CLIENT = new HttpClient(new MultiThreadedHttpConnectionManager());

    public HttpClientParams getHttpClientParams() {
        return HTTP_CLIENT.getParams();
    }

    public void setHttpClientParams(final HttpClientParams httpClientParams) {
        HTTP_CLIENT.setParams(httpClientParams);
    }

    public GeocodeResponse geocode(final GeocoderRequest geocoderRequest) {
        try {
            final String urlString = getURL(geocoderRequest);

            final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            final GetMethod getMethod = new GetMethod(urlString);
            try {
                HTTP_CLIENT.executeMethod(getMethod);
                final Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());

                return gson.fromJson(reader, GeocodeResponse.class);
            } finally {
                getMethod.releaseConnection();
            }
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private String getURL(final GeocoderRequest geocoderRequest) throws UnsupportedEncodingException {
        final String address = geocoderRequest.getAddress();
        final String language = geocoderRequest.getLanguage();
        final String region = geocoderRequest.getRegion();

        String urlString = GEOCODE_REQUEST_URL;
        if (StringUtils.isNotBlank(address)) {
            urlString += "&address=" + URLEncoder.encode(address, "UTF-8");
        }
        if (StringUtils.isNotBlank(language)) {
            urlString += "&language=" + URLEncoder.encode(language, "UTF-8");
        }
        if (StringUtils.isNotBlank(region)) {
            urlString += "&region =" + URLEncoder.encode(region, "UTF-8");
        }
        log.debug("url: " + urlString);
        return urlString;
    }
}