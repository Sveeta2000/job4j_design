package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {
    @XmlAttribute
    private boolean multiplayer;
    @XmlAttribute
    private int numberOfPlayers;
    @XmlAttribute
    private String gameTitle;
    private Developer developer;
    @XmlElementWrapper(name = "accessTypes")
    @XmlElement(name = "accessType")
    private String[] accessTypes;

    public Game() { }

    public Game(boolean multiplayer, int numberOfPlayers, String gameTitle, Developer developer, String... accessTypes) {
        this.multiplayer = multiplayer;
        this.numberOfPlayers = numberOfPlayers;
        this.gameTitle = gameTitle;
        this.developer = developer;
        this.accessTypes = accessTypes;
    }

    @Override
    public String toString() {
        return "Game{"
                + "multiplayer=" + multiplayer
                + ", numberOfPlayers=" + numberOfPlayers
                + ", gameTitle='" + gameTitle + '\''
                + ", developer=" + developer
                + ", accessTypes=" + Arrays.toString(accessTypes)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Game game = new Game(true, 4, "Splendor",
                new Developer("Space Cowboys", "UK"), "Steam", "Offline");
        JAXBContext context = JAXBContext.newInstance(Game.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(game, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            Game gameFromXml = (Game) unmarshaller.unmarshal(reader);
            System.out.println(gameFromXml);
        }
    }
}
