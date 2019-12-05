package com.packager;
import java.io.FileWriter;
import java.io.IOException;

public class FilterLoggerFile implements FilterLogger{

    @Override
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter("AppFilter.log", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
