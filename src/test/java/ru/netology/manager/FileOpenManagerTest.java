package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    private Map<String, Set<String>> expected = new HashMap<>();


    @BeforeEach
    public void setUp() {
        manager.registration("Google Chrome", Set.of(".html"));
        manager.registration("Paint", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"));
        manager.registration("Adobe Photoshop", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"));
        manager.registration("FireFox", Set.of(".html"));
    }

    @Test
    void shouldRegister() {
        manager.registration("Adobe Rider", Set.of(".pdf"));

        Map<String, Set<String>> actual = manager.findAll();
        expected.putAll(Map.of("Google Chrome", Set.of(".html"),
                "Paint", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"),
                "Adobe Photoshop", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"),
                "FireFox", Set.of(".html"),
                "Adobe Rider", Set.of(".pdf")));
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldFindName() {
        Set<String> actual = manager.findNameApp(".html");
        expected.putAll(Map.of("Google Chrome", Set.of(".html"),
                "FireFox", Set.of(".html")));
        assertTrue(expected.keySet().equals(actual));

    }
    @Test
    void shouldNotFindForNotExistName() {
        Set<String> actual = manager.findNameApp(".exel");
        expected.putAll(Map.of());
        assertTrue(expected.keySet().equals(actual));

    }

    @Test
    void shouldRemove() {
        Map<String, Set<String>> actual = manager.remove(".jpg");
        expected.putAll(Map.of("Google Chrome", Set.of(".html"),
                "FireFox", Set.of(".html")));
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldNotRemoveForNotExist() {
        Map<String, Set<String>> actual = manager.remove(".exel");
        expected.putAll(Map.of("Google Chrome", Set.of(".html"),
                "Paint", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"),
                "Adobe Photoshop", Set.of(".jpg", ".JPG", ".jpeg", ".JPEG"),
                "FireFox", Set.of(".html")));
        assertTrue(expected.equals(actual));
    }


    @Test
    void shouldAllFileExtention() {
        List<String> actual = manager.findAllFileExtention();
        List<String> expected = new ArrayList<>(List.of(".jpg", ".JPG", ".html", ".jpeg", ".JPEG"));
        Collections.sort(expected);
        assertTrue(expected.containsAll(actual));
    }

    @Test
    void shouldAllPrograms() {
        List<String> actual = manager.findAllProgram();
        List<String> expected = new ArrayList<>(List.of("Adobe Photoshop", "Google Chrome", "Paint", "FireFox"));
        Collections.sort(expected);
        assertTrue(expected.containsAll(actual));
    }

}