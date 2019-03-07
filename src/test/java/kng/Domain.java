package kng;

public class Domain {

    private static String domain;
    private final static String DEV = "https://dev.web.kupivip.local";
    private final static String PROD = "https://www.kupivip.ru";
    private final static String PRE = "https://pre.web.kupivip.local";

    public Domain() {
    }

    Domain(String $domain) {
        domain = $domain;

    }

    public static void setDEV() {
        new Domain(DEV);
    }

    public static void setPre() {
        new Domain(PRE);
    }

    public static void setProd() {
        new Domain(PROD);
    }

    protected static String getDomain() {
        return domain;
    }
}
