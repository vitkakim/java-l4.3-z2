package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, Set<String>> app = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void registration(String fileExtention, Set<String> nameProgramm) {
        app.put(fileExtention, nameProgramm);
    }

    public Map<String, Set<String>> findAll() {
        return app;
    }

    public Set<String> findNameApp(String fileExtention) {
        Set<String> result = new HashSet<>();
        if (app.containsKey(fileExtention)) {
           result =  app.get(fileExtention);
        }
        return result;
    }

        public Map<String, Set<String>> remove(String fileExtention) {
        Map<String, Set<String>> result = new HashMap<>();
            if (app.containsKey(fileExtention)) {
                app.remove(fileExtention);
                result = app;
            }
        return result;
    }

    public List<String> findAllFileExtention() {
        List<String> result = new ArrayList<>(app.keySet());
        Collections.sort(result);
        return result;
    }

    public List<String> findAllProgram() {
        Set<String> tmp = new HashSet<>();
        for (Map.Entry<String, Set<String>> pair : app.entrySet()) {
            for (String s : pair.getValue()) {
                tmp.add(s);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        Collections.sort(result);
        return result;
    }
}
