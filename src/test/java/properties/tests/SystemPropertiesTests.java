package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {
    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser);// null
    }
    @Test
    void systemProperties1Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");

        System.out.println(browser);// chrome
    }
    @Test
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);// mozilla
    }
    @Test
    void systemProperties3Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);// chrome
    }

    @Test
    @Tag("property")
    void systemProperties4Test() {
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);
        // gradle property_test = mozilla

        // gradle property_test -Dbrowzer=opera  = opera (после добавления в build.gradle "systemProperties(System.getProperties())"), чтобы игнорировать дефолтный chrome!
    }

    @Test
    @Tag("hello")
    void systemProperties5Test() {
        String name = System.getProperty("browser", "default student");
        String message = format("Hello, %s!", name);

        System.out.println(message);
        // gradle hello_test = Hello, default student!
        // gradle hello_test -Dname="Alex Egorov"
        // gradle hello_test "-Dname=Alex Egorov"

    }
}
