package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.tests.SystemPropertiesTest;

import java.util.Map;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.browser = SystemPropertiesTest.browserProperty;
    Configuration.browserSize = SystemPropertiesTest.browserSizeProperty;
    Configuration.browserVersion = SystemPropertiesTest.browserVersionProperty;
    Configuration.baseUrl = SystemPropertiesTest.baseUrlProperty;
    Configuration.remote = SystemPropertiesTest.remoteSelenoidProperty;
    Configuration.pageLoadStrategy = "eager";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true
    ));

    Configuration.browserCapabilities = capabilities;
  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }
}

