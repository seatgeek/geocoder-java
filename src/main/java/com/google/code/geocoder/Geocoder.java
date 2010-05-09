package com.google.code.geocoder;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLEncoder;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class Geocoder {
    private static final String GEOCODE_REQUEST_URL = "http://maps.google.com/maps/api/geocode/json?sensor=false";

    private static Log log = LogFactory.getLog(Geocoder.class);

    public static GeocodeResponseType geocode(GeocoderRequest geocoderRequest) {
        try {
            String address = geocoderRequest.getAddress();
            String language = geocoderRequest.getLanguage();
            String region = geocoderRequest.getRegion();

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
            log.error("url: " + urlString);

            GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            Gson gson = gsonBuilder.create();

            final HttpClient httpClient = new HttpClient();

            final GetMethod getMethod = new GetMethod(urlString);
            try {
                httpClient.executeMethod(getMethod);
                Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());

                return gson.fromJson(reader, GeocodeResponseType.class);
            } finally {
                getMethod.releaseConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            log.error(e.getMessage());
            return null;
        }
    }
}