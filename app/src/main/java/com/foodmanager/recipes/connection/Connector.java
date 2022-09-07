package com.foodmanager.recipes.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {

    public Connector() {
            connect();
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    final URL url = new URL("https://api.edamam.com/api/recipes/v2?type=public&q=chicken&app_id=e2abb6d5&app_key=a9cd491d59f73f78e05d0ace2cd929ae");
                    final HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                        for (String line; (line = reader.readLine()) != null; )
                            result.append(line);
                    }
                    System.out.println(result);
                } catch (Exception exception){
                    System.out.println(exception + "____________");
                }
            }
        });

        thread.start();
    }
}
