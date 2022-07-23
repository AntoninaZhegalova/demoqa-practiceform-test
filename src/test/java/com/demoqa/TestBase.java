package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PagePracticeForm;

public class TestBase {
    PagePracticeForm pagePracticeForm = new PagePracticeForm();
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = System.getProperty("BASE_URL");
        Configuration.browser = System.getProperty("TEST_BROWSER");
        Configuration.browserVersion = System.getProperty("VERSION");
        Configuration.browserSize = System.getProperty("SIZE_BROWSER");
        String remoteUrl = System.getProperty("REMOTE_URL");
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteUrl);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

