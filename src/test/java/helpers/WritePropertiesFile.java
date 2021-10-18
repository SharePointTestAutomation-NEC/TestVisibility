package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WritePropertiesFile {

    public void WritePropertiesFile(String key, String data,String Url) {
        FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties configProperty = new Properties();

            File file = new File(Url);
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty(key, data);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, "sample properties");

        } catch (Exception ex) {
            Logger.getLogger(WritePropertiesFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(WritePropertiesFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}