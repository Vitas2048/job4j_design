package ru.job4j.ood.srp.report;

import com.puppycrawl.tools.checkstyle.checks.LineSeparatorOption;
import ru.job4j.io.serialization.xml.Monitor;
import ru.job4j.ood.srp.formatter.DateAdapter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXml implements Report {

    private final Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var xml = "";
        try {
            var context = JAXBContext.newInstance(Employee.class);
            var marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setAdapter(new DateAdapter());
            StringWriter writer = new StringWriter();
            for (Employee employee:store.findBy(filter)) {
                marshaller.marshal(employee, writer);
                writer.append(System.lineSeparator());
                xml = writer.getBuffer().toString();
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
