package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class Obj_Catalog extends Waitings {

    private final Roboto ROBBY;
    private final Actions ACTIONS;
    private final WebDriver OBJECT_WD;

    public Obj_Catalog(WebDriver wd) {
        super(wd);
        OBJECT_WD = wd;
        ROBBY = new Roboto();
        ACTIONS = new Actions(wd);
        PageFactory.initElements(wd, this);
    }
//====================================================================
//dinamyc-------------------------------------------------

    private WebElement getSearchedSizeInDrop(String size) {

        ArrayList<WebElement> sizesElements = new ArrayList<>();
        sizesElements.addAll(filter_size_first_in_drop.findElements($FILTER_SIZE_FIRST_IN_DROP));
        for (WebElement $sizesElements : sizesElements) {
            if ($sizesElements.getText().contains(size)) {
                return $sizesElements;
            }
        }
        return null;
    }

//String-------------------------------------------------
    private static final String LEFT_MENU_CATEGORIES = "//*[@id=\"catalog-categories\"]//li[@class='active']/a";
    private static final String LEFT_MENU_SECTION_FEMALE = "//*[@id=\"catalog-categories\"]//li[@class='active']/a[@data-mp='Женщинам']";
    private static final String LEFT_MENU_FEMALE_CLOTHER = "//*[@id=\"catalog-categories\"]//li/a/span[text()='Одежда']";
    private static final String LEFT_MENU_FEMALE_SHOES = "//*[@id=\"catalog-categories\"]//li/a/span[text()='Обувь']";
    private static final String PRODUCT_1 = "//*[@id=\"catalog-list\"]/section//div[@data-position='1']";
    private static final String PRODUCT_60 = "//*[@id=\"catalog-list\"]/section//div[@data-position='60']";
    private static final String PRODUCTS_PRICES = "//div[@class='price']";
    private static final String PRODUCTS_PRICES_DISCOUNT = "//div[@class='labels eng']/span[@data-discount]";
    private static final String PRODUCTS_BRANDS = "//div[@class='brand']";
   // private static final String H1 = "//*[@id=\"catalog-list\"]/header/h1";
    private static final String H1 = "//header//h1";
    private static final String BREAD_CRUMBS = "//div[@class='breadcrumb category brands']";
    private static final String QUICK_BUTTON = "//button[@data-js='quick']";//быстрый просмотр
    private static final String FAVOR_ICON = "//div[@class='actions']//button[@data-js='product-subscribe']";//избранное "сердечко'
    private static final String SECOND_PAGE = "//*[@id=\"catalog-list\"]//div[@class='pages']//a[text()='2']";
    private static final String SHOW_MORE_PRODUCTS_BUTTON = "//*[@id=\"catalog-list\"]//div[@class='show-more']//a";
    private static final String SHOW_120_PRODUCTS = "//*[@id=\"catalog-list\"]//div/button[@data-num='120']";
    private static final String FILTERS_PANEL = "//*[@id=\"filters-menu\"]/div[@class='btn-place']";
    private static final String TAG_PANEL = "filter-tags";
    private static final String SORT_LIST = "//*[@id=\"filters-sort\"]//ul[@class='radios']//li//label//span";
    private static final String FILTER_PRICE_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='price']";
    private static final String FILTER_SIZE_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='size']";
    private static final String FILTER_SEASON_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='season']";
    private static final String FILTER_MATERIAL_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='material']";
    private static final String FILTER_COLOR_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='color']";
    private static final String FILTER_COUNTRY_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='country']";
    private static final String FILTER_SPECIAL_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='special']";
    private static final String SORT_FACET = "myfilters-sort";
    private static final String FILTER_SIZE_SEARCH_INPUT = "//*[@id=\"filters-menu\"]//div[@data-facet='size']//div[@class='search-input']/input";
    private static final String FILTER_PRICE_UNDER1000 = "//*[@id=\"filters-menu\"]/div[@data-facet='price']//span[text()='до 1 000']";
    private static final String FILTER_PRICE_RIGHT_FIELD = "//li[@class='price-label__right']/input[@data-js='price-filter-right']";
    private static final String FILTER_PRICE_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='price']//button[@type='submit']";
    private static final String FILTER_SIZE_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='size']//button[@type='submit']";
    private static final String FILTER_BRAND_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='brand']//button[@type='submit']";
    private static final String FILTER_SEASON_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='season']//button[@type='submit']";
    private static final String FILTER_MATERIAL_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='material']//button[@type='submit']";
    private static final String FILTER_COLOR_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='color']//button[@type='submit']";
    private static final String FILTER_COUNTRY_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='country']//button[@type='submit']";
    private static final String FILTER_SPECIAL_APPLY_BUTTON = "//*[@id=\"filters-menu\"]//div[@data-facet='special']//button[@type='submit']";
    private static final String FILTER_BRAND_FACET = "//*[@id=\"filters-menu\"]//div[@data-facet='brand']";
    private static final String FILTER_BRAND_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='brand']//span[@data-num]";
    private static final String FILTER_SEASON_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='season']//span[@data-num]";
    private static final String FILTER_SIZE_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='size']//span[@data-num]";
    private static final String FILTER_COLOR_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='color']//span[@data-num]";
    private static final String FILTER_MATERIAL_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='material']//span[@data-num]";
    private static final String FILTER_COUNTRY_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='country']//span[@data-num]";
    private static final String FILTER_SPECIAL_FIRST_IN_DROP = "//*[@id=\"filters-menu\"]//div[@data-facet='special']//span[@data-num]";
    private static final String SORT_PA_DROP = "//*[@id=\"filters-sort\"]//span[text()='Цена по возрастанию']";
    private static final String SORT_PD_DROP = "//*[@id=\"filters-sort\"]//span[text()='Цена по убыванию']";
    private static final String SORT_DD_DROP = "//*[@id=\"filters-sort\"]//span[text()='По размеру скидки']";
    private static final String BRAND_BANNERS_AREA = "catalog-row";
    private static final String NO_COUPONS_INFO = "//div[text()='Действие купонов и промокодов на данный бренд не распространяется, "
            + "кроме персональных предложений.']";

//By--------------------------------------------------------------------
    private final By $H1 = By.xpath(H1);
    private final By $QUICK_BUTTON = By.xpath(QUICK_BUTTON);
    private final By $PRODUCTS_PRICES = By.xpath(PRODUCTS_PRICES);
    private final By $PRODUCTS_PRICES_DISCOUNT = By.xpath(PRODUCTS_PRICES_DISCOUNT);
    private final By $PRODUCTS_BRANDS = By.xpath(PRODUCTS_BRANDS);
    private final By $FAVOR_ICON = By.xpath(FAVOR_ICON);
    private final By $FILTERS_PANEL = By.xpath(FILTERS_PANEL);
    private final By $TAG_PANEL = By.id(TAG_PANEL);
    private final By $BRANDBANNERSAREA = By.id(BRAND_BANNERS_AREA);
    private final By $SORT_LIST = By.xpath(SORT_LIST);
    private final By $LEFT_MENU_CATEGORIES = By.xpath(LEFT_MENU_CATEGORIES);
    private final By $FILTER_PRICE_APPLY_BUTTON = By.xpath(FILTER_PRICE_APPLY_BUTTON);
    private final By $FILTER_SIZE_APPLY_BUTTON = By.xpath(FILTER_SIZE_APPLY_BUTTON);
    private final By $FILTER_BRAND_APPLY_BUTTON = By.xpath(FILTER_BRAND_APPLY_BUTTON);
    private final By $FILTER_SEASON_APPLY_BUTTON = By.xpath(FILTER_SEASON_APPLY_BUTTON);
    private final By $FILTER_MATERIAL_APPLY_BUTTON = By.xpath(FILTER_MATERIAL_APPLY_BUTTON);
    private final By $FILTER_COLOR_APPLY_BUTTON = By.xpath(FILTER_COLOR_APPLY_BUTTON);
    private final By $FILTER_SPECIAL_FIRST_SPECIAL_DROP = By.xpath(FILTER_SPECIAL_FIRST_IN_DROP);
    private final By $FILTER_COUNTRY_FIRST_COUNTRY_DROP = By.xpath(FILTER_COUNTRY_FIRST_IN_DROP);
    private final By $NO_COUPONS_INFO = By.xpath(NO_COUPONS_INFO);
    private final By $BREADCRUMBS = By.xpath(BREAD_CRUMBS);
    private final By $FILTER_SIZE_FIRST_IN_DROP = By.xpath(FILTER_SIZE_FIRST_IN_DROP);

//Find---------------------------------------------------------------------------
    @FindBy(xpath = LEFT_MENU_SECTION_FEMALE)
    private WebElement left_menu_section_female;

    @FindBy(xpath = LEFT_MENU_FEMALE_CLOTHER)
    private WebElement left_menu_female_clother;

    @FindBy(xpath = LEFT_MENU_FEMALE_SHOES)
    private WebElement left_menu_female_shoes;

    @FindBy(xpath = LEFT_MENU_CATEGORIES)
    private WebElement left_menu_categories;

    @FindBy(xpath = FILTERS_PANEL)
    private WebElement filters_panel;

    @FindBy(xpath = SORT_LIST)
    private WebElement sort_list;

    @FindBy(xpath = PRODUCTS_PRICES)
    private WebElement products_prices;

    @FindBy(xpath = PRODUCTS_PRICES_DISCOUNT)
    private WebElement products_prices_discount;

    @FindBy(xpath = PRODUCTS_BRANDS)
    private WebElement products_brands;

    @FindBy(xpath = FILTER_PRICE_APPLY_BUTTON)
    private WebElement filter_price_apply_button;

    @FindBy(xpath = FILTER_SIZE_APPLY_BUTTON)
    private WebElement filter_size_apply_button;

    @FindBy(xpath = FILTER_BRAND_APPLY_BUTTON)
    private WebElement filter_brand_apply_button;

    @FindBy(xpath = FILTER_SEASON_APPLY_BUTTON)
    private WebElement filter_season_apply_button;

    @FindBy(xpath = FILTER_MATERIAL_APPLY_BUTTON)
    private WebElement filter_material_apply_button;

    @FindBy(xpath = FILTER_COLOR_APPLY_BUTTON)
    private WebElement filter_color_apply_button;

    @FindBy(xpath = FILTER_COUNTRY_APPLY_BUTTON)
    private WebElement filter_country_apply_button;

    @FindBy(xpath = FILTER_SPECIAL_APPLY_BUTTON)
    private WebElement filter_special_apply_button;

    @FindBy(xpath = FILTER_PRICE_FACET)
    private WebElement filter_price_facet;

    @FindBy(xpath = FILTER_SIZE_FACET)
    private WebElement filter_size_facet;

    @FindBy(xpath = FILTER_SEASON_FACET)
    private WebElement filter_season_facet;

    @FindBy(xpath = FILTER_MATERIAL_FACET)
    private WebElement filter_material_facet;

    @FindBy(xpath = FILTER_BRAND_FACET)
    private WebElement filter_brand_facet;

    @FindBy(xpath = FILTER_COLOR_FACET)
    private WebElement filter_color_facet;

    @FindBy(xpath = FILTER_COUNTRY_FACET)
    private WebElement filter_country_facet;

    @FindBy(xpath = FILTER_SPECIAL_FACET)
    private WebElement filter_special_facet;

    @FindBy(id = SORT_FACET)
    private WebElement sort_facet;

    @FindBy(xpath = SORT_PA_DROP)
    private WebElement sort_pa_drop;

    @FindBy(xpath = SORT_PD_DROP)
    private WebElement sort_pd_drop;

    @FindBy(xpath = SORT_DD_DROP)
    private WebElement sort_dd_drop;

    @FindBy(xpath = FILTER_SIZE_SEARCH_INPUT)
    private WebElement filter_size_search_input;

    @FindBy(xpath = FILTER_PRICE_UNDER1000)
    private WebElement filter_price_under1000;

    @FindBy(xpath = FILTER_BRAND_FIRST_IN_DROP)
    private WebElement filter_brand_first_in_drop;

    @FindBy(xpath = FILTER_SEASON_FIRST_IN_DROP)
    private WebElement filter_season_first_in_drop;

    @FindBy(xpath = FILTER_SIZE_FIRST_IN_DROP)
    private WebElement filter_size_first_in_drop;

    @FindBy(xpath = FILTER_MATERIAL_FIRST_IN_DROP)
    private WebElement filter_material_first_in_drop;

    @FindBy(xpath = FILTER_COUNTRY_FIRST_IN_DROP)
    private WebElement filter_country_first_in_drop;

    @FindBy(xpath = FILTER_COLOR_FIRST_IN_DROP)
    private WebElement filter_color_first_in_drop;

    @FindBy(xpath = FILTER_SPECIAL_FIRST_IN_DROP)
    private WebElement filter_special_first_in_drop;

    @FindBy(xpath = FILTER_PRICE_RIGHT_FIELD)
    private WebElement filter_price_right_field;

    @FindBy(xpath = PRODUCT_1)
    private WebElement product_1;

    @FindBy(xpath = PRODUCT_60)
    private WebElement product_60;

    @FindBy(xpath = FAVOR_ICON)
    private WebElement favor_icon;

    @FindBy(xpath = SECOND_PAGE)
    private WebElement second_page;

    @FindBy(xpath = SHOW_MORE_PRODUCTS_BUTTON)
    private WebElement show_more_products_button;

    @FindBy(xpath = SHOW_120_PRODUCTS)
    private WebElement show_120_products;

    @FindBy(xpath = QUICK_BUTTON)
    private WebElement quick_button;

    @FindBy(id = BRAND_BANNERS_AREA)
    private WebElement brand_banners_area;

    @FindBy(xpath = NO_COUPONS_INFO)
    private WebElement no_coupons_info;
//=======================================================

    public ArrayList<String> countLeftMenuCategories() {
        ArrayList<WebElement> $categories = (ArrayList) left_menu_categories.findElements($LEFT_MENU_CATEGORIES);
        ArrayList<String> categories = new ArrayList<>();
        for (WebElement category : $categories) {
            categories.add((category.getText()));
        }
        return categories;
    }

    public ArrayList<String> getSizesFromProduct(int productLocation) {
        String sizes = "//div[@data-position=" + "'" + String.valueOf(productLocation) + "']//div[@class='sizes']//button";
        By $sizes = By.xpath(sizes);
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> $$sizes = (ArrayList) $sizes.findElements(OBJECT_WD);
        ArrayList<String> textSizes = new ArrayList();

        for (WebElement size : $$sizes) {
            textSizes.add(size.getAttribute("data-text"));
        }
        return textSizes;
    }

    public ArrayList<Integer> getPricesFromAllProducts() {
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> productsPriceContains = (ArrayList) products_prices.findElements($PRODUCTS_PRICES);
        ArrayList<Integer> productPrice = new ArrayList<>();
        for (WebElement price : productsPriceContains) {
            productPrice.add(Integer.parseInt(price.getText().replaceAll("\\s", "").replaceAll("[^0-9]", "")));
        }
        return productPrice;
    }

    public ArrayList<Integer> getDiscountPricesFromAllProducts() {
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> productsPriceDiscountContains = (ArrayList) products_prices_discount.findElements($PRODUCTS_PRICES_DISCOUNT);
        ArrayList<Integer> productPriceDiscount = new ArrayList<>();
        for (WebElement priceDiscount : productsPriceDiscountContains) {
            productPriceDiscount.add(Integer.parseInt(priceDiscount.getAttribute("data-discount").replaceAll("[^0-9]", "")));
        }
        return productPriceDiscount;
    }

    public ArrayList<String> getBrandFromAllProducts() {
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> productsBrandContains = (ArrayList) products_brands.findElements($PRODUCTS_BRANDS);
        ArrayList<String> productBrand = new ArrayList<>();
        for (WebElement brand : productsBrandContains) {
            productBrand.add((brand.getText()));
        }
        return productBrand;
    }

    public ArrayList<String> getAllFiltersNames() {
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> filters_panel_contain = (ArrayList) filters_panel.findElements($FILTERS_PANEL);
        ArrayList<String> filtersName = new ArrayList<>();
        for (WebElement filter : filters_panel_contain) {
            String currentF = filter.getText();
            if (!currentF.isEmpty()) {
                filtersName.add(currentF);
            }
        }
        return filtersName;
    }

    public ArrayList<String> getAllSortNames() {
        @SuppressWarnings("unchecked")
        ArrayList<WebElement> sortListContains = (ArrayList) sort_list.findElements($SORT_LIST);
        ArrayList<String> sortName = new ArrayList<>();
        for (WebElement sort : sortListContains) {
            sortName.add(sort.getText());
        }
        return sortName;
    }

    public boolean clickFilterPriceFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_price_facet.click();
                return super.visibility(time, $FILTER_PRICE_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterMaterialFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_material_facet.click();
                return super.visibility(time, $FILTER_MATERIAL_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterSeasonFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_season_facet.click();
                return super.visibility(time, $FILTER_SEASON_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterSizeFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_size_facet.click();
                return super.visibility(time, $FILTER_SIZE_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterBrandFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_brand_facet.click();
                return super.visibility(time, $FILTER_BRAND_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterColorFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_color_facet.click();
                return super.visibility(time, $FILTER_COLOR_APPLY_BUTTON);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterCountryFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_country_facet.click();
                return super.visibility(time, $FILTER_COUNTRY_FIRST_COUNTRY_DROP);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public boolean clickFilterSpecialFacet(int time) {
        for (int i = 0; i < 10; i++) {
            try {
                filter_special_facet.click();
                return super.visibility(time, $FILTER_SPECIAL_FIRST_SPECIAL_DROP);
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
        return false;
    }

    public void clickSortFacet() {
        for (int i = 0; i < 10; i++) {
            try {
                sort_facet.click();
                break;
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(3000);
            }
        }
    }

    public void clickFilterPriceApply_button() {
        ROBBY.rob.delay(100);
        filter_price_apply_button.click();
    }

    public void clickFilterSizeApply_button() {
        ROBBY.rob.delay(100);
        filter_size_apply_button.click();
    }

    public void clickFilterBrandApply_button() {
        ROBBY.rob.delay(100);
        filter_brand_apply_button.click();
    }

    public void clickFilterSeasonApply_button() {
        ROBBY.rob.delay(100);
        filter_season_apply_button.click();
    }

    public void clickFilterMaterialApply_button() {
        ROBBY.rob.delay(100);
        filter_material_apply_button.click();
    }

    public void clickFilterColorApply_button() {
        ROBBY.rob.delay(100);
        filter_color_apply_button.click();
    }

    public void clickFilterCountryApply_button() {
        ROBBY.rob.delay(100);
        filter_country_apply_button.click();
    }

    public void clickFilterSpecialApply_button() {
        ROBBY.rob.delay(100);
        filter_special_apply_button.click();
    }

    public void sendKeysInDropsSearchInputAndSelectSizeInDrop(String size) {
        filter_size_search_input.clear();
        filter_size_search_input.sendKeys(size);
        ROBBY.rob.delay(200);
        this.getSearchedSizeInDrop(size).click();
    }

    public void sendFilterToRightPriceField(String userFilter) {
        filter_price_right_field.clear();
        filter_price_right_field.sendKeys(userFilter);
    }

    public void clickFilterPriceUnder1000() {
        filter_price_under1000.click();
    }

    public String clickFirstBrandInDrop() {
        ROBBY.rob.delay(200);
        filter_brand_first_in_drop.click();
        return filter_brand_first_in_drop.getText();
    }

    public String clickFirstSeasonInDrop() {
        ROBBY.rob.delay(200);
        filter_season_first_in_drop.click();
        return filter_season_first_in_drop.getText();
    }

    public String clickFirstMaterialInDrop() {
        ROBBY.rob.delay(200);
        filter_material_first_in_drop.click();
        return filter_material_first_in_drop.getText();
    }

    public String clickFirstColorInDrop() {
        ROBBY.rob.delay(200);
        filter_color_first_in_drop.click();
        return filter_color_first_in_drop.getText();
    }

    public String clickFirstCountryInDrop() {
        ROBBY.rob.delay(200);
        filter_country_first_in_drop.click();
        return filter_country_first_in_drop.getText();
    }

    public String clickFirstSpecialInDrop() {
        ROBBY.rob.delay(200);
        filter_special_first_in_drop.click();
        return filter_special_first_in_drop.getText();
    }

    public void clickSortPaDrop() {
        ROBBY.rob.delay(200);
        sort_pa_drop.click();
    }

    public void clickSortPdDrop() {
        ROBBY.rob.delay(200);
        sort_pd_drop.click();
    }

    public void clickSortDdDrop() {
        ROBBY.rob.delay(200);
        sort_dd_drop.click();
    }

    public void clickQuickModal_button() {
        quick_button.click();
    }

    public void clickFirstProduct() {
        product_1.click();
    }

    public void moveToFirstProduct() {
        ACTIONS.moveToElement(product_1).build().perform();
    }

    public void moveToSixtiethProduct() {
        ACTIONS.moveToElement(product_60).build().perform();
    }

    public void clickFavorIcon() {
        favor_icon.click();
    }

    public void clickSecondPage() {
        second_page.click();
    }

    public void clickShowMoreProductsButton() {
        show_more_products_button.click();
    }

    public void clickShow120Products() {
        show_120_products.click();
    }

    public boolean clickLeftMenuSectionFemale(int time) {
        left_menu_section_female.click();
        return w_ApplyFilterInH1(time, "Женские товары");
    }

    public boolean clickLeftMenuFemaleClother(int time) {
        left_menu_female_clother.click();
        return w_ApplyFilterInH1(time, "Женская одежда");
    }

    public boolean clickLeftMenuFemaleShoes(int time) {
        left_menu_female_shoes.click();
        return w_ApplyFilterInH1(time, "Женская обувь");
    }

    public boolean getBrandBannersArea() {
        try {
            brand_banners_area.findElement($BRANDBANNERSAREA);
            return true;
        } catch (WebDriverException ignore) {
        }
        return false;
    }

    public boolean w_TagPanel_visibility(int time) {
        return super.visibility(time, $TAG_PANEL);
    }

    public boolean w_FavorIcon_visibility(int time) {
        return super.visibility(time, $FAVOR_ICON);
    }

    public boolean w_QuickButton_visibility(int time) {
        return super.visibility(time, $QUICK_BUTTON);
    }

    public boolean w_ApplyFilterInH1(int time, String text) {
        return super.textMatches(time, text, $H1);
    }

    public boolean w_ApplyBreadCrumbs(int time, String text) {
        return super.textMatches(time, text, $BREADCRUMBS);
    }

    public boolean w_urlSortPa(int time) {
        return super.urlContains(time, "sort=pa");
    }

    public boolean w_urlSortPd(int time) {
        return super.urlContains(time, "sort=pd");
    }

    public boolean w_urlSortDd(int time) {
        return super.urlContains(time, "sort=dd");
    }

    public boolean w_urlSecondPage(int time) {
        return super.urlContains(time, "page=2");
    }

    public boolean w_url120PerPage(int time) {
        return super.urlContains(time, "quantity_per_page=120");
    }

    public boolean w_NoCouponsInfo(int time) {
        return super.visibility(time, $NO_COUPONS_INFO);
    }
}
