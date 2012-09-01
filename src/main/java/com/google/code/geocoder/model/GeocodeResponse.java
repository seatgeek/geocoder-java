package com.google.code.geocoder.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:panchmp@gmail.com">Michael Panchenko</a>
 */
public class GeocodeResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private GeocoderStatus status;
    private List<GeocoderResult> results;

    public GeocodeResponse() {
    }

    public GeocoderStatus getStatus() {
        return status;
    }

    public void setStatus(GeocoderStatus status) {
        this.status = status;
    }

    public List<GeocoderResult> getResults() {
        return results;
    }

    public void setResults(List<GeocoderResult> result) {
        this.results = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeocodeResponse that = (GeocodeResponse) o;

        if (results != null ? !results.equals(that.results) : that.results != null) return false;
        if (status != that.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (results != null ? results.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeocodeResponse{" +
                "status=" + status +
                ", results=" + results +
                '}';
    }
}