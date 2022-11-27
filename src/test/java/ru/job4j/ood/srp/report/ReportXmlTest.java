package ru.job4j.ood.srp.report;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


class ReportXmlTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report engine = new ReportXml(store);
        String expected = String.format("""
                        <Employees>
                            <employee name="%s" salary="%s">
                                <hired>%s</hired>
                                <fired>%s</fired>
                            </employee>
                        </Employees>""", worker.getName(),
                worker.getSalary(), parser.parse(worker.getHired()), parser.parse(worker.getFired()));
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected));
    }
}