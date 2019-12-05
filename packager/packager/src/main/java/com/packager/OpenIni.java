package com.packager;
import org.ini4j.Ini;
import org.ini4j.Wini;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenIni {

    public List<String> openIni(String filePath) throws FilterException {

        File file2 = new File(filePath);
        try {
            Wini ini = new Wini(new File(filePath));
            String dirIn = ini.get("general", "inputDir");
            String dirOut = ini.get("general", "outputDir");
            String logFile = ini.get("general", "logFile");
            String filterArgs = ini.get("filters", "content");

            List<String> listIni = new ArrayList<>();
            listIni.add(dirIn);
            listIni.add(dirOut);
            listIni.add(filterArgs);
            listIni.add(logFile);

            return listIni;
        }catch (Exception e){
             throw new FilterException("can't open the selected file");
        }
    }
}
