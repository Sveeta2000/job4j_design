package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsJuniorDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior Developer"));
        Role rsl = store.findById("1");
        assertThat(rsl.getRoleName()).isEqualTo("Junior Developer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior Developer"));
        Role rsl = store.findById("2");
        assertThat(rsl).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        store.add(new Role("1", "QA"));
        Role rsl = store.findById("1");
        assertThat(rsl.getRoleName()).isNotNull()
                .isEqualTo("Developer");
    }

    @Test
    void whenReplaceThenRoleNameIsQA() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        store.replace("1", new Role("1", "QA"));
        Role rsl = store.findById("1");
        assertThat(rsl.getRoleName()).isNotNull()
                .isEqualTo("QA");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        store.replace("10", new Role("10", "QA"));
        Role rsl = store.findById("1");
        assertThat(rsl.getRoleName()).isNotNull()
                .isEqualTo("Developer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        boolean rsl = store.replace("1", new Role("1", "QA"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        boolean rsl = store.replace("10", new Role("10", "QA"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        store.delete("1");
        Role rsl = store.findById("1");
        assertThat(rsl).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        store.delete("2");
        Role rsl = store.findById("1");
        assertThat(rsl.getRoleName()).isNotNull()
                .isEqualTo("Developer");
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenNoDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Developer"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}