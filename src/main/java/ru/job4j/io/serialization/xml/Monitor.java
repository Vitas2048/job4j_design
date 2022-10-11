package ru.job4j.io.serialization.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "monitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Monitor {
    @XmlAttribute
    private boolean gamesupport;
    @XmlAttribute
    private int frequency;
    @XmlAttribute
    private String company;
    private Contact contact;
    @XmlElementWrapper
    @XmlElement(name = "shop")
    private String[] shops;

    public Monitor() { }

    public Monitor(boolean gamesupport, int frequency, String company, Contact contact, String[] shops) {
        this.gamesupport = gamesupport;
        this.frequency = frequency;
        this.company = company;
        this.contact = contact;
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "monitor{"
                + "gamesupprot: " + gamesupport
                + ", frequency: " + frequency
                + ", company: " + company
                + ", contact: " + contact.toString()
                + ", shops: " + Arrays.toString(shops);
    }

    public static void main(String[] args) throws Exception {
        Monitor monitor = new Monitor(true, 144, "Asus", new Contact("88005553535"), new String[] {"DNS", "MVIDEO"});
        JAXBContext context = JAXBContext.newInstance(Monitor.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()){
            marshaller.marshal(monitor, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Monitor res = (Monitor) unmarshaller.unmarshal(reader);
            System.out.println(res);
        }
    }
}
