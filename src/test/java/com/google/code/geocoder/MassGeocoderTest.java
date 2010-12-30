package com.google.code.geocoder;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.*;

import java.io.FileInputStream;
import java.io.InputStream;

@Ignore
public class MassGeocoderTest extends Assert {
    private static Geocoder geocoder;
    private static InputStream file;
    private static HSSFWorkbook wb;


    @BeforeClass
    public static void beforeClass() {
        geocoder = new Geocoder();

        try {
            file = new FileInputStream("src/test/resources/ATM_partners.xls ");
            wb = new HSSFWorkbook(file);

            /*
            final HSSFSheet sheet = wb.getSheetAt(0);
            for (int i = sheet.getLeftCol(); i < sheet.getLastRowNum(); i++) {
                final HSSFRow row = sheet.getRow(i);
                System.out.print(i);
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    final HSSFCell cell = row.getCell(j);
                    System.out.print("[" + cell.getStringCellValue() + "]");

                }
                System.out.println(";");
                String address = row.getCell(3).getStringCellValue();
                address += ", " + row.getCell(1).getStringCellValue();
                address += ", " + row.getCell(2).getStringCellValue();

                System.out.println("address = " + address);
            }
            */
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @AfterClass
    public static void afterClass() {
        try {
            if (wb != null) {
                wb = null;
            }
            if (file != null) {
                file.close();
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGeocode() throws Exception {
        GeocodeResponse geocoderResponse;
        final HSSFSheet sheet = wb.getSheetAt(0);
        for (int i = sheet.getLeftCol(); i < Math.min(2000, sheet.getLastRowNum()); i++) {

            final HSSFRow row = sheet.getRow(i);

            final String street = row.getCell(3).getStringCellValue();
            final String city = row.getCell(1).getStringCellValue();
            final String region = row.getCell(2).getStringCellValue();

            String address = street + ", "
                    + city;
            if (!region.startsWith("м.")) {
                address += ", " + region + " обл.";
            }

            System.out.println("address = " + address);
            geocoderResponse = geocoder.geocode(new GeocoderRequest(address, "uk"));
            System.out.println("geocoderResponse = " + geocoderResponse);
            Thread.sleep(1000);
        }
    }
}
