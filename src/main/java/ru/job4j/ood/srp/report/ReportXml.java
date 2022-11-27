package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateAdapter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXml implements Report {

    private final Store store;

    private JAXBContext context;

    private Marshaller marshaller;

    public ReportXml(Store store) {
        this.store = store;
        try {
            context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var xml = "";
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setAdapter(new DateAdapter());
            StringWriter writer = new StringWriter();
            Employees employees = new Employees(store.findBy(filter));
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
