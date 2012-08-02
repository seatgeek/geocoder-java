package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

@Ignore
public class MassGeocoderIT extends BaseGeocoderIT {

    @Test
    public void testGeocode() throws Exception {
        GeocodeResponse geocoderResponse;

        InputStream file = new FileInputStream("src/test/resources/ATM_partners.xls ");
        try {
            HSSFWorkbook wb = new HSSFWorkbook(file);
            final HSSFSheet sheet = wb.getSheetAt(0);

            for (int i = sheet.getLeftCol(); i < Math.min(2000, sheet.getLastRowNum()); i++) {
                final HSSFRow row = sheet.getRow(i);

                final String street = row.getCell(3).getStringCellValue();
                final String city = row.getCell(1).getStringCellValue();
                final String region = row.getCell(2).getStringCellValue();

                String address = street + ", " + city;
                if (!region.startsWith("м.")) {
                    address += ", " + region + " обл.";
                }

                System.out.println("address = " + address);
                geocoderResponse = geocoder.geocode(new GeocoderRequest(address, "uk"));
                System.out.println("geocoderResponse = " + geocoderResponse);
                Thread.sleep(1000);
            }
        } finally {
            file.close();
        }
    }
}
