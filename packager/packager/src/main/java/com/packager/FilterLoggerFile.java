package com.packager;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterLoggerFile implements FilterLogger{

    @Override
    public void log(String message) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter writer = new FileWriter("AppFilter.log", true);
            writer.write("\n" + format.format(date)+ message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
