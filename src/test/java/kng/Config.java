package kng;

import java.io.File;

public class Config {

    private static final File file = new File("src\\test\\resources\\temporaryfiles");
    private static final File fileNoCouponsBrands = new File("src\\test\\resources\\dataFiles\\brands.txt");
    
    public static final String CHROM_DRIVER_PATH = "src\\test\\resources\\chromedriver.exe";
    public static final String SAVED_DOCS_PATH = file.getAbsolutePath();
    public static final String NO_COUPONS_BRANDS_PATH = fileNoCouponsBrands.getAbsolutePath();
}
