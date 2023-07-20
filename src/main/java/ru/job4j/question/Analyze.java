package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        if (!previous.equals(current)) {
            int changed = 1;
            int deleted = 1;
            Map<Integer, String> cur = current.stream()
                    .collect(Collectors.toMap(User::getId, User::getName));
            for (User user : previous) {
                int id = user.getId();
                if (cur.containsKey(id) && user.getName().equals(cur.get(id))) {
                    cur.remove(id);
                } else if (cur.containsKey(id) && !user.getName().equals(cur.get(id))) {
                    info.setChanged(changed++);
                    cur.remove(id);
                } else {
                    info.setDeleted(deleted++);
                }
            }
            info.setAdded(cur.size());
        }
        return info;
    }
}
