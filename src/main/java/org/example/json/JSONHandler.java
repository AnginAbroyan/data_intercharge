package org.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JSONHandler {

    private void serializeObject(Actor actor) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("src/main/resources/json_files/actor_demo.json");
        writer.write(gson.toJson(actor));
        writer.close();
    }


    private Actor deserializeObject() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/main/resources/json_files/actor.json"));

        Actor actor = gson.fromJson(bufferedReader, Actor.class);
        return actor;
    }

    public static void main(String[] args) {
        JSONHandler jsonHandler = new JSONHandler();



        Actor actor  = new Actor("John Joseph Travolta", "John Travolta",
                null, new String[]{"oil", "famous"});
        try {
            jsonHandler.serializeObject(actor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            System.out.println(jsonHandler.deserializeObject());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
