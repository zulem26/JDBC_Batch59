package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags="@DBUtils",
        dryRun = false
)
public class TestRunner {
    /*
        Bir framework de bir tek TestRunner class i yeterli olabilir
        TestRunner class inda class body sinde hic bir sey olmaz
        TestRunner class imizi onemli yapan 2 adet annotation vardir
        @RunWith(Cucumber.class)  notasyonu TestRunner class ina calisma ozelligi katar
        Bu notasyon oldugu icin Cucumber framework umuzde JUnit kullanmayi tercih ediyoruz

        features: TestRunner dosyasinin feature dosyalarini nereden bulacagini tarif eder
        glue : step definitions dosyalarini nerede bulacagimizi gosterir
        tags : o an hangi tag i calistirmak istiyorsak onu belli eder

        dryRun : iki secenek var
        dryRun=true; yazdigimizda Testimizi calistirmadan sadece eksik adimlari bize verir
        dryRun=false yazdigimizda testlerimizi calistirir
     */
}
