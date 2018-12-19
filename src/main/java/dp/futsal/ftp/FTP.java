package dp.futsal.ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;


@Service
public class FTP {

    private static final Logger LOGGER = Logger.getLogger(FTP.class.getName());

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

    public void uploadToServer(String remote, String data) {
        ftp = new FTPClient();
        String appDataServerDir = "public_html/futsal/";
        try {
            ftp.connect("files.000webhost.com");
            LOGGER.info("connected to server");

            if (ftp.login("app-1542391754", "fpliga2014")) {
                LOGGER.info("logged to server");

                try (OutputStream outputStream = ftp.storeFileStream(appDataServerDir + remote);
                        Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8").newEncoder());
                        Writer bufferedWriter = new BufferedWriter(writer);) {
                    bufferedWriter.write(data);
                }
                LOGGER.info("Upload done?..." + ftp.completePendingCommand());
            }

            if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
                LOGGER.info("logged out & disconnected from server");
            }
        } catch (IOException ex) {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
