package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        IntStream.range(0, 1000).forEach((i) -> executorService.submit(() -> {
            try {
                String url = "http://localhost:8080/ex1?key=" + new Date().getTime() + "&value=" + new Date().getTime();
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();


                // optional default is GET
                con.setRequestProperty("Content-Type", "text/plain");
                con.setRequestMethod("POST");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer responseString = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    responseString.append(inputLine);
                }
                in.close();

                System.out.println(responseString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
