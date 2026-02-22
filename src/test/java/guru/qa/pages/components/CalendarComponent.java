package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static guru.qa.utils.RandomUtils.formatDayWithLeadingZero;

public class CalendarComponent {

    public void setDate(int day, int month, int year){
        $(".react-datepicker__month-select").click();
        int monthSelector = month - 1;
        $(".react-datepicker__month-select option[value='" + monthSelector + "']").click();

        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));

        $(".react-datepicker__day.react-datepicker__day--0" + formatDayWithLeadingZero(day) + ":not(.react-datepicker__day--outside-month)").click();
    }
}

