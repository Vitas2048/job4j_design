package ru.job4j.ood.srp.report;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;


class ReportXmlTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report engine = new ReportXml(store);
        String expected1 = "<employee name=\"" + worker.getName() + "\" salary=\"" + worker.getSalary() + "\">";
        String expected2 = "    <hired>"+ parser.parse(worker.getHired()) +"</hired>";
        String expected3 = "    <fired>" + parser.parse(worker.getFired()) + "</fired>";
        String expected4 = "</employee>";
        String expected5 = "";
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected1));
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected2));
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected3));
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected4));
        Assert.assertThat(engine.generate(em -> true), StringContains.containsString(expected5));
    }
}