package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultOutput {
  public void verifyResult(String key, String value) {
    String id = String.format("#output #%s", key);
    $(id).shouldHave(text(value));
  }
}
