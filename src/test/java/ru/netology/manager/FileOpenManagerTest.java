package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    private Map<Set<String>, Set<String>> expected = new HashMap<>();


    @BeforeEach
    public void setUp() {
        manager.registration(Set.of(".html"), Set.of("Google Chrome", "FireFox"));
        manager.registration(Set.of(".jpg", ".JPG"), Set.of("Paint", "Adobe Photoshop"));
        manager.registration(Set.of(".jpeg", ".JPEG"), Set.of("Paint", "Adobe Photoshop"));
    }

    @Test
    void shouldRegister() {
        manager.registration(Set.of(".pdf"), Set.of("Adobe Rider"));

        Map<Set<String>, Set<String>> actual = manager.findAll();
        expected.putAll(Map.of(Set.of(".html"), Set.of("Google Chrome", "FireFox"),
                Set.of(".jpg", ".JPG"), Set.of("Paint", "Adobe Photoshop"),
                Set.of(".jpeg", ".JPEG"), Set.of("Paint", "Adobe Photoshop"),
                Set.of(".pdf"), Set.of("Adobe Rider")));
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldFindName() {
        Set<String> actual = manager.findNameApp(".html");
        Set<String> expected = new HashSet<>(Set.of("Google Chrome", "FireFox"));
        assertTrue(expected.equals(actual));

    }
    @Test
    void shouldNotFindForNotExistName() {
        Set<String> actual = manager.findNameApp(".exel");
        Set<String> expected = new HashSet<>();
        assertTrue(expected.equals(actual));

    }

    @Test
    void shouldRemove() {
        Map<Set<String>, Set<String>> actual = manager.remove(".jpg");
        expected.putAll(Map.of(Set.of(".html"), Set.of("Google Chrome", "FireFox"),
                Set.of(".jpeg", ".JPEG"), Set.of("Paint", "Adobe Photoshop")));
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldNotRemoveForNotExist() {
        Map<Set<String>, Set<String>> actual = manager.remove(".exel");
        expected.putAll(Map.of(Set.of(".html"), Set.of("Google Chrome", "FireFox"),
                Set.of(".jpg", ".JPG"), Set.of("Paint", "Adobe Photoshop"),
                Set.of(".jpeg", ".JPEG"), Set.of("Paint", "Adobe Photoshop")));
        assertTrue(expected.equals(actual));
    }


    @Test
    void shouldFindAllFileExtention() {
        List<String> actual = manager.findAllFileExtention();
        List<String> expected = new ArrayList<>(List.of(".jpg", ".JPG", ".html", ".jpeg", ".JPEG"));
        Collections.sort(expected);
        assertTrue(expected.containsAll(actual));
    }

    @Test
    void shouldFindAllPrograms() {
        List<String> actual = manager.findAllProgram();
        List<String> expected = new ArrayList<>(List.of("Adobe Photoshop", "Google Chrome", "Paint", "FireFox"));
        Collections.sort(expected);
        assertTrue(expected.containsAll(actual));
    }

}