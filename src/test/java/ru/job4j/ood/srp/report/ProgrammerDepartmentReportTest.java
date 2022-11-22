package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ProgrammerDepartmentReportTest {

    @Test
    public void whenForProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Mike", now, now, 120);
        Employee worker2 = new Employee("Susan", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ProgammerDepartmentReport(store, converter);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(converter.convert(Currency.USD, worker2.getSalary(), Currency.RUB))
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(converter.convert(Currency.USD, worker1.getSalary(), Currency.RUB))
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(converter.convert(Currency.USD, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

}