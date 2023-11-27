package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportTest {

    @Test
    void wheGenerateXmlReportWithOnePerson() {
        MemStore store1 = new MemStore();
        Calendar calendar = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store1.add(new Employee("Ivan", calendar, calendar, 100));
        XmlReport report = new XmlReport(store1);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
              +  "<employees>\n"
              +  "    <employee>\n"
              +  "        <name>Ivan</name>\n"
              +  "        <hired>" + parser.parse(calendar) + "</hired>\n"
              +  "        <fired>" + parser.parse(calendar) + "</fired>\n"
              +  "        <salary>100.0</salary>\n"
              +  "    </employee>\n"
              +  "</employees>\n";
        assertThat(report.generate(employee -> true)).isEqualTo(expected);
    }

    @Test
    void wheGenerateXmlReportWithTwoPeople() {
        MemStore store1 = new MemStore();
        Calendar calendar = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store1.add(new Employee("Ivan", calendar, calendar, 100));
        store1.add(new Employee("Anna", calendar, calendar, 200));
        XmlReport report = new XmlReport(store1);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
              +  "<employees>\n"
              +  "    <employee>\n"
              +  "        <name>Ivan</name>\n"
              +  "        <hired>" + parser.parse(calendar) + "</hired>\n"
              +  "        <fired>" + parser.parse(calendar) + "</fired>\n"
              +  "        <salary>100.0</salary>\n"
              +  "    </employee>\n"
              +  "    <employee>\n"
              +  "        <name>Anna</name>\n"
              +  "        <hired>" + parser.parse(calendar) + "</hired>\n"
              +  "        <fired>" + parser.parse(calendar) + "</fired>\n"
              +  "        <salary>200.0</salary>\n"
              +  "    </employee>\n"
              +  "</employees>\n";
        assertThat(report.generate(employee -> true)).isEqualTo(expected);
    }
}