package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    public void setUp() {
        manager.registration(".html", Set.of("Google Chrome", "FireFox"));
        manager.registration(".jpg", Set.of("Paint", "Adobe Photoshop"));
        manager.registration(".JPG", Set.of("Paint", "Adobe Photoshop"));
        manager.registration(".jpeg", Set.of("Paint", "Adobe Photoshop"));
    }

    @Test
    void shouldRegister() {
        manager.registration(".pdf", Set.of("Adobe Rider"));
        Map<String, Set<String>> actual = manager.findAll();
        Map<String, Set<String>> expected = new HashMap<>(Map.of(".html", Set.of("Google Chrome", "FireFox"),
                ".jpg", Set.of("Paint", "Adobe Photoshop"),
                ".jpeg", Set.of("Paint", "Adobe Photoshop"),
                ".pdf", Set.of("Adobe Rider")));
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldFindName() {
        Set<String> actual = manager.findNameApp(".html");
        Set<String> expected = new HashSet<>(Set.of("Google Chrome", "FireFox"));
        assertEquals(expected, actual);

    }

    @Test
    void shouldFindNameWithDifferentRegister() {
        Set<String> actual = manager.findNameApp(".JPG");
        Set<String> expected = new HashSet<>(Set.of("Paint", "Adobe Photoshop"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindForNotExistName() {
        Set<String> actual = manager.findNameApp(".exel");
        Set<String> expected = new HashSet<>();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemove() {
        Map<String, Set<String>> actual = manager.remove(".jpg");
        Map<String, Set<String>> expected = new HashMap<>(Map.of(".html", Set.of("Google Chrome", "FireFox"),
                ".jpeg", Set.of("Paint", "Adobe Photoshop")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveWithDifferentRegister() {
        Map<String, Set<String>> actual = manager.remove(".HTML");
        Map<String, Set<String>> expected = new HashMap<>(Map.of(".jpg", Set.of("Paint", "Adobe Photoshop"),
                ".jpeg", Set.of("Paint", "Adobe Photoshop")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveForNotExist() {
        Map<String, Set<String>> actual = manager.remove(".exel");
        Map<String, Set<String>> expected = new HashMap<>();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAllFileExtention() {
        List<String> actual = manager.findAllFileExtention();
        List<String> expected = new ArrayList<>(List.of(".jpg", ".html", ".jpeg"));
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