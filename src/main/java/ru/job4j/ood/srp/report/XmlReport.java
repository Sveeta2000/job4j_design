package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.IOException;
import java.io.StringWriter;

import java.util.function.Predicate;

public class XmlReport implements Report {
    private final Store store;

    public XmlReport(Store store) {
        this.store = store;

    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder xml = new StringBuilder();
        Employees employees = new Employees(store.findBy(employee -> true));
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, writer);
            xml.append(writer.getBuffer().toString());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return xml.toString();
    }
}
