package kng.navigation;

import kng.Domain;

public class URLs extends Domain {

    public static final String MAINPAGE = Domain.getDomain();
    public static final String CATALOG_BASIC = MAINPAGE + "/search?q=";
    public static final String CATALOG_FOR_NO_EURO_ORDER_UNDER_4999 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=ekspress_dostavka&tsena=500_1000";
    public static final String CATALOG_FOR_NO_EURO_ORDER_UP_4999 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=ekspress_dostavka&tsena=5000_7000";
    public static final String CATALOG_FOR_EURO_ORDER_UP_4999 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=tovary_iz_evropy&tsena=5000_7000";
    public static final String CATALOG_FOR_EURO_ORDER_UNDER_4999 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=tovary_iz_evropy&tsena=500_4999";
    public static final String CATALOG_FOR_EURO_ORDER_UNDER_3000 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=tovary_iz_evropy&tsena=500_2999";
    public static final String CATALOG_FOR_EURO_ORDER_UP_50000 = MAINPAGE + "/search?razmer=bez_razmera&sort=pa&tip=tovary_iz_evropy&tsena=50000_100000";
    public static final String CATALOG_FOR_LETUAL_ORDER = MAINPAGE + "/search?sort=pa&tip=l_etual&tsena=do_1000";
    public static final String ACCOUNT_PERSONAL_DATA = MAINPAGE + "/account/personal-data";
    public static final String ACCOUNT_ORDERS = MAINPAGE + "/account/orders/";
    public static final String ACCOUNT_ORDER_ID = MAINPAGE + "/account/orders?id=";
    public static final String ACCOUNT_ORDER_CANCEL = MAINPAGE + "/account/orders/cancel/";
    public static final String ACCOUNT_BONUS_PAGE = MAINPAGE + "/account/bonus";
    public static final String ACCOUNT_MY_BRANDS = MAINPAGE + "/account/brands";
    public static final String ACCOUNT_MY_FAVORIT = MAINPAGE + "/account/favorites";
    public static final String ACCOUNT_OPEN_ORDER = MAINPAGE + "/account/orders?id=";
    public static final String ORDER_REVIEW = MAINPAGE + "/orderReview/";
    public static final String RETAIL_REG_FORM = MAINPAGE + "/protected/admin/retail_registration/reg";
    public static final String RETAIL_CONFIRM_FORM = MAINPAGE + "/protected/admin/retail_registration/confirm?fields=true";
    public static final String ALL_BRAND_PAGE = MAINPAGE + "/brands";
    public static final String PRODUCT_WITH_MANY_COMMENTS = MAINPAGE + "/product/g16061517156/awama-plate";
    public static final String PRODUCT_FOR_BAD_COMMENTS = MAINPAGE + "/product/w17012290592/art_parfyum-alibi_strong_95_ml";
    public static final String PRODUCT_FOR_GOOD_COMMENTS = MAINPAGE + "/product/w11081782282/gucci-guilty_pour_homme_edt_50_ml";
    public static final String SMS_SERVICE = "https://qealty.ru/";

    public static String catalogPagingForFindProductWarehouse(int pageNumer) {
        String s = Integer.toString(pageNumer);
        return MAINPAGE + "/search?sort=pa&tip=ekspress_dostavka&tsena=3000_4000&page=" + s + "&quantity_per_page=60";
    }

    public static String catalogPagingForFindProductSupplier(int pageNumer) {
        String s = Integer.toString(pageNumer);
        return MAINPAGE + "/search?sort=pa&tsena=2500_4000&page=" + s + "&quantity_per_page=60";
    }

}
