package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ReportJsonTest {

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report engine = new ReportJson(store);
        String expected = String.format("[{\"name\":\"%s\",\"hired\":{\"year\":%s,\"month\":%s,\"dayOfMonth\":%s," +
                        "\"hourOfDay\":%s,\"minute\":%s,\"second\":%s},\"fired\":{\"year\":%s,\"month\":%s," +
                        "\"dayOfMonth\":%s,\"hourOfDay\":%s,\"minute\":%s,\"second\":%s},\"salary\":%s}]",
                worker.getName(), worker.getHired().get(Calendar.YEAR), worker.getHired().get(Calendar.MONTH),
                worker.getHired().get(Calendar.DAY_OF_MONTH), worker.getHired().get(Calendar.HOUR_OF_DAY),
                worker.getHired().get(Calendar.MINUTE), worker.getHired().get(Calendar.SECOND),
                worker.getFired().get(Calendar.YEAR), worker.getFired().get(Calendar.MONTH),
                worker.getFired().get(Calendar.DAY_OF_MONTH), worker.getFired().get(Calendar.HOUR_OF_DAY),
                worker.getFired().get(Calendar.MINUTE), worker.getFired().get(Calendar.SECOND), worker.getSalary());
        assertEquals(expected, engine.generate(em -> true));
    }
}