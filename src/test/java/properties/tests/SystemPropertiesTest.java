package properties.tests;

public class SystemPropertiesTest {
  public static String browserProperty = System.getProperty("browser", "chrome"),
          browserSizeProperty = System.getProperty("browserSize", "1920x1080"),
          browserVersionProperty = System.getProperty("browserVersion", "100"),
          baseUrlProperty = System.getProperty("baseUrl", "https://demoqa.com"),
          remoteSelenoidProperty = System.getProperty("remoteSelenoidUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
}
