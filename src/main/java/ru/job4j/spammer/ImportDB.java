package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            return rd.lines()
                    .map(l -> l.split(";", 2))
                    .peek(this::checkValid)
                    .map(rsl -> new User(rsl[0], rsl[1]))
                    .collect(Collectors.toList());
        }
    }

    private void checkValid(String[] array) {
        if (array.length != 2 || array[0].isEmpty() || array[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users(name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("spamapp.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}