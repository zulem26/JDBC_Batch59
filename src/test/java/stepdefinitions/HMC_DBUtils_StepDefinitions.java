package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_StepDefinitions {

    @Given("kullanici DBUtils ile HMC veri tabanina baglanir")
    public void kullanici_db_utils_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();
    }

    @Given("kullanici DBUtils ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utils_ile_tablosundaki_verilerini_alir(String table, String field) {
        String query = "Select "+ field +" from "+table;
        DBUtils.executeQuery(query);
    }

    @Given("kullanici DBUtils ile {string} sutunundaki verileri okur")
    public void kullanici_db_utils_ile_sutunundaki_verileri_okur(String field) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field));
    }


    @And("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        // 1.ders te while loop ile nex() kullanarak liste yazdirmistik
        // simdi de for loop ile liste yazdiralim

        DBUtils.getResultset().last();
        int sonSatirNo = DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();

        for (int i = 1; i <=sonSatirNo ; i++) {
            System.out.println(i + ". ci kayit " + DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }
    }

    @Then("DBUtil ile {int} {string} in {int} oldugunu test eder")
    public void dbutilIleInOldugunuTestEder(int isetenenSiraNo, String field, int expectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(isetenenSiraNo);
        double actualDeger = DBUtils.getResultset().getDouble(field);
        System.out.println("expected deger : " + expectedDeger);
        System.out.println("actual deger : " + actualDeger);

        Assert.assertTrue(actualDeger==expectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {

        String updateQuery = "UPDATE tHOTEL SET Email = '"+yeniEmail+"' WHERE IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);
    }
}
