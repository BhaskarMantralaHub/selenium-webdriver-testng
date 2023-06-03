# Selenium WebDriver TestNG Java

### What is Surefire plugin?

The Surefire Plugin is used during the test phase of the build lifecycle to execute the unit tests of an application.

It generates reports in two different file formats:

* Plain text files (*.txt)
* XML files (.xml) By default, these files are generated in

```
${basedir}/target/surefire-reports/TEST-.xml.
```

### Maven Profiles

```maven
<profiles>
    <profile>
      <id>dev</id>
      <build>
        <pluginManagement>
          <plugins>
            <plugin>
              <artifactId>maven-surefire-plugin</artifactId>
              <configuration>
                <suiteXmlFiles>
                  <suiteXmlFile>testng_dev.xml</suiteXmlFile>
                </suiteXmlFiles>
              </configuration>
            </plugin>
          </plugins>
        </pluginManagement>
      </build>
    </profile>
  </profiles>
```

```run
mvn clean install -Pdev

#dev is profile ID

(OR)

mvn clean install -P dev
```

### Property Values from Surefire plugin

Property values can be sent to tests from surefire plugin

```maven
<profile>
      <id>dev</id>
      <build>
        <pluginManagement>
          <plugins>
            <plugin>
              <artifactId>maven-surefire-plugin</artifactId>
              <configuration>
                <suiteXmlFiles>
                  <suiteXmlFile>testng_dev.xml</suiteXmlFile>
                </suiteXmlFiles>
                <systemPropertyVariables>
                  <current.env>dev environment</current.env>
                </systemPropertyVariables>
              </configuration>
            </plugin>
          </plugins>
        </pluginManagement>
      </build>
    </profile>
```

Access property values below from test:

```
System.getProperty("current.env");
```

### Parameters from TestNG xml to Suite level

```
<suite name="Suite" >
    <parameter name="customer_name" value="Bhaskar">
    </parameter>
    <test> </test>
</suite> 
```

```
@Test(groups = "sanity")
@Parameters({"customer_name"})
public void test(String customerName) {
  System.out.println(customerName); //Bhaskar
}
```

### Parameters from TestNG xml to Test level

```
<suite name="Suite" >
    <parameter name="customer_name" value="Bhaskar">
    </parameter>
    <test> 
        <parameter name="customer_name" value="Sarma">
        </parameter>
    </test>
</suite> 
```

```
@Test(groups = "sanity")
@Parameters({"customer_name"})
public void test(String customerName) {
  System.out.println(customerName); //Sarma from Test level
}
```

### Optional parameters

```
@Test(groups = "sanity")
@Parameters({"customer_name"})
public void test(@Optional("optional name") String customerName) {
    //logic
}
```

### @BeforeTest

You want to set up some common preconditions before executing a group of tests belonging to a specific <test> tag in your TestNG XML file.

Example:
* initialize WebDriver
* open the browser
* login, etc.

```java
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {

    @BeforeTest
    public void setUp() {
        // Perform setup actions before executing tests in this <test> tag
        // e.g., initialize WebDriver, open the browser, login, etc.
    }

    @Test
    public void test1() {
        // Test case 1
    }

    @Test
    public void test2() {
        // Test case 2
    }
}

```

### @BeforeMethod

You need to perform some setup actions before each test method in a test class.

```java
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTest {

    @BeforeMethod
    public void setUp() {
        // Perform setup actions before each test method
        // e.g., initialize data, reset state, etc.
    }

    @Test
    public void test1() {
        // Test case 1
    }

    @Test
    public void test2() {
        // Test case 2
    }
}

```


