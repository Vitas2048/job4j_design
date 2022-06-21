package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleIsMentor() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mentor"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Mentor"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleIsPupil() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.add(new Role("1", "CodeReviewer"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Pupil"));
    }

    @Test
    public void whenReplaceThenRoleIsMentor() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.replace("1", new Role("1", "Mentor"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Mentor"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.replace("10", new Role("10", "CodeReviewer"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Pupil"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleIsPupil() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Pupil"));
    }

    @Test
    public void whenDeleteRoleAndAddNewThenRoleIsTester() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Pupil"));
        store.delete("1");
        store.add(new Role("1", "Tester"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Tester"));
    }

    @Test
    public void whenFewRolesChangeRoleAndAddNewThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "CodeReviewer"));
        store.add(new Role("2", "Tester"));
        store.add(new Role("3", "Mentor"));
        store.replace("2", new Role("2", "Admin"));
        Role result = store.findById("2");
        assertThat(result.getRole(), is("Admin"));
    }

}