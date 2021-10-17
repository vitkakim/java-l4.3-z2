package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, Set<String>> app = new HashMap<>();


    public void registration(String nameProgramm, Set<String> fileExtention) {
        app.put(nameProgramm, fileExtention);
    }

    public Map<String, Set<String>> findAll() {
        return app;
    }

    public Set<String> findNameApp(String fileExtention) {
        Set<String> result = new HashSet<>();
        for (Map.Entry<String, Set<String>> pair : entrySet()) {
            if (pair.getValue().contains(fileExtention)) {
                result.add(pair.getKey());
            }
        }
        return result;
    }

    public Map<String, Set<String>> remove(String fileExtention) {
        Map<String, Set<String>> result = new HashMap<>();
        for (Map.Entry<String, Set<String>> pair : entrySet()) {
            if (pair.getValue().contains(fileExtention)) {
            } else {
                result.put(pair.getKey(), pair.getValue());
            }
        }
        return result;
    }

    public List<String> findAllFileExtention() {
        Set<String> tmp = new HashSet<>();
        for (Map.Entry<String, Set<String>> pair : entrySet()) {
            for (String s : pair.getValue()) {
                tmp.add(s);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        Collections.sort(result);
        return result;
    }

    public List<String> findAllProgram() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> pair : entrySet()) {
            result.add(pair.getKey());
        }
        Collections.sort(result);
        return result;
    }


    public Iterable<? extends Map.Entry<String, Set<String>>> entrySet() {
        return app.entrySet();
    }
}
