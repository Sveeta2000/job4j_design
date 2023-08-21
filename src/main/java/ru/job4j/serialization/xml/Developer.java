package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "developer")
public class Developer {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String country;

    public Developer() { }

    public Developer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Developer{"
                + "name='" + name + '\''
                + ", country='" + country + '\''
                + '}';
    }
}
