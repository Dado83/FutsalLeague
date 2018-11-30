package dp.futsal.ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;


@Service
public class FTP {

    FTPClient ftp;
    String[] loggonData = new String[2];
    InputStream inputStream;

    public FTP() {

    }

    public void uploadFile(String remoteFile, String uploadFile) {
        ftp = new FTPClient();
        try {
            inputStream = new FileInputStream(uploadFile);
            ftp.connect("files.000webhost.com");

            BufferedReader reader = new BufferedReader(new FileReader(new File("C:/ftp.txt")));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                loggonData[i] = line;
                i++;
            }

            ftp.login(loggonData[0], loggonData[1]);
            ftp.storeFile(remoteFile, inputStream);

            inputStream.close();
            if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }
        } catch (IOException ex) {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
