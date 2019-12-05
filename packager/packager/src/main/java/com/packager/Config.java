package com.packager;
import org.ini4j.Wini;
import java.io.File;
public class Config {
    void sample01(String filename) {
        try {
            Wini ini = new Wini(new File(filename));
            String inputDir = ini.get("general", "inputDir");
            String outputDir = ini.get("general", "outputDir");
            String logFile = ini.get("general", "logFile");
            String content = ini.get("filters", "content");
            System.out.println("   ------ " +inputDir + "----------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}