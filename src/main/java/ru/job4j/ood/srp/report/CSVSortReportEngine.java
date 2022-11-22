package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class CSVSortReportEngine implements Report {

    private final Store store;

    private final CurrencyConverter converter;


    public CSVSortReportEngine(Store store, CurrencyConverter converter) {
        this.store = store;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter)
                .stream()
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .toList();
        employees.forEach(x -> x.setSalary(converter.convert(Currency.USD, x.getSalary(), Currency.RUB)));
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
