package com.foodmanager.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {

    /**
     * @param link api url, documentation https://developer.edamam.com
     * @return String that can be converted to a JSONArray.
    * */
    public String request(String link){
        StringBuilder result = new StringBuilder();
        Thread thread = new Thread(() -> {
            try {
                final URL url = new URL(link);
                final HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    for (String line; (line = reader.readLine()) != null; ) {
                        result.append(line);
                    }
                }
            } catch (Exception exception){
                exception.printStackTrace();
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
