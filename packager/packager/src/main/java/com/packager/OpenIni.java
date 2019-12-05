package com.packager;
import org.ini4j.Ini;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OpenIni {

    public void openIni() throws IOException {
        File file2 = new File("packager/src/config.ini");
        Ini config = new Ini();
        config.load(new FileReader(file2));

    }


}
