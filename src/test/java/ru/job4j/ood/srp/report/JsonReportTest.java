package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportTest {

    @Test
    void whenGenerateJsonReport() {
        MemStore store1 = new MemStore();
        Calendar calendar = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store1.add(new Employee("Ivan", calendar, calendar, 100));
        JsonReport j = new JsonReport(store1, new ReportDateTimeParser());
        String expected = "[\n"
              +  "  {\n"
              +  "    \"fired\": \"" + parser.parse(calendar) + "\",\n"
              +  "    \"name\": \"Ivan\",\n"
              +  "    \"hired\": \"" + parser.parse(calendar) + "\",\n"
              +  "    \"salary\": 100.0\n"
              +  "  }\n"
              +  "]";
        assertThat(j.generate(employee -> true)).isEqualTo(expected);
    }
}