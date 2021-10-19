package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<Set<String>, Set<String>> app = new HashMap<>();


    public void registration(Set<String> fileExtention, Set<String> nameProgramm) {
        app.put(fileExtention, nameProgramm);
    }

    public Map<Set<String>, Set<String>> findAll() {
        return app;
    }

    public Set<String> findNameApp(String fileExtention) {
        Set<String> result = new HashSet<>();
        for (Map.Entry<Set<String>, Set<String>> pair : entrySet()) {
            if (pair.getKey().contains(fileExtention)) {
                for (String s : pair.getValue()) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    public Map<Set<String>, Set<String>> remove(String fileExtention) {
        Map<Set<String>, Set<String>> result = new HashMap<>();
        for (Map.Entry<Set<String>, Set<String>> pair : entrySet()) {
            if (pair.getKey().contains(fileExtention)) {
            } else {
                result.put(pair.getKey(), pair.getValue());
            }
        }
        return result;
    }

    public List<String> findAllFileExtention() {
        Set<String> tmp = new HashSet<>();
        for (Map.Entry<Set<String>, Set<String>> pair : entrySet()) {
            for (String s : pair.getKey()) {
                tmp.add(s);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        Collections.sort(result);
        return result;
    }

    public List<String> findAllProgram() {
        Set<String> tmp = new HashSet<>();
        for (Map.Entry<Set<String>, Set<String>> pair : entrySet()) {
            for (String s : pair.getValue()) {
                tmp.add(s);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        Collections.sort(result);
        return result;
    }


    public Iterable<? extends Map.Entry<Set<String>, Set<String>>> entrySet() {
        return app.entrySet();
    }
}
