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

### Parameters from TestNG xml in Suite level

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

### Parameters from TestNG xml in Test level

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

### @BeforeTest (Before running tests under test tag in testng.xml)

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

### @BeforeClass (Before running each class of tests under test tag in testng.xml)

You want to perform setup actions once before executing any test methods in a test class.

```java
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTest {

    @BeforeClass
    public void setUp() {
        // Perform setup actions once before executing any test method
        // e.g., initialize database connection, load test data, etc.
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

### @BeforeTest vs @BeforeClass

* @BeforeTest will be executed only once per test tag
* @BeforeClass will be executed once per class

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" >
    <test thread-count="5" name="Test">
        <classes>
            <!-- @BeforeTest will be executed only once per test tag-->
            <!-- @BeforeClass will be executed once per class-->
            <class name="com.bhaskarmantralahub.ChildTest"/>
            <class name="com.bhaskarmantralahub.ParentTest"/>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
```


### What is Factory annotation?

* @Factory defines and creates tests dynamically at runtime.

* A @Factory method returns objects that will be used by TestNG as Test classes. 
TestNG will scan for test methods in these classes and run those tests.
* The factory method can receive parameters just like @Test.
* Factory method should return an array of Object i.e. Object []
```java
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {

    private final String param;

    public FactoryTest(String param) {
        this.param = param;
    }

    @Test(priority = 0)
    public void test() {
        System.out.println("My name is " + this.param);
    }

    @Factory
    public static Object[] factoryMethod() {
        return new FactoryTest[]{new FactoryTest("Hello"), new FactoryTest("Hey"), new FactoryTest("Hola")};
    }

}
```

#### **Note:** Here order of execution is not guaranteed

* To preserve order of execution
```java
@Factory
@Test(dependsOnMethods = "factoryMethodHey")
public static Object[] factoryMethodHello() {
    return new FactoryTest[]{new FactoryTest("Hello")};
}

@Factory
public static Object[] factoryMethodHey() {
        return new FactoryTest[]{new FactoryTest("Hey")};
} 
```

### Dependency Injection

```java
 @BeforeMethod
    public void beforeMethod(ITestResult testResult) {
        System.out.println("Inside Before Method of " + testResult.getMethod().getMethodName());
    }
```

Injecting **ITestResult** object for all listener event methods and hook methods


### Annotations vs Listeners

Annotations:
Annotations in TestNG are built-in markers that you can apply directly to your test classes, test methods, or configuration methods. They provide a declarative way to specify test configurations, dependencies, and behaviors. TestNG offers a wide range of annotations such as @Test, @BeforeMethod, @AfterMethod, @DataProvider, @Parameters, and more.

Annotations are useful for defining test-related configurations in a concise and readable manner. 


Listeners:
Listeners, on the other hand, are custom classes that implement TestNG listener interfaces. These interfaces define callback methods that get invoked at different stages of the test execution lifecycle. By implementing these methods, you can hook into the test execution process and perform custom actions or validations.


