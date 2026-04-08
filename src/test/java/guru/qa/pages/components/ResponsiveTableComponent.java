package guru.qa.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResponsiveTableComponent {

    @Step("Проверка результирующей таблицы, что поле {key} содержит {value}")
    public void checkTable(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                        .shouldHave(text(value));
    }
}
