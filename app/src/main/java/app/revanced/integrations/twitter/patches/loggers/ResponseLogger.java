package app.revanced.integrations.twitter.patches.loggers;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.Environment;

import app.revanced.integrations.twitter.Pref;
import app.revanced.integrations.twitter.Utils;

public class ResponseLogger {
    private static boolean LOG_RES;
    static{
        LOG_RES = Pref.serverResponseLogging();
        if(Pref.serverResponseLoggingOverwriteFile()){
            writeFile("".getBytes(),false);
//            Utils.logger("Cleared response log file!!!");
        }
    }

    public static InputStream saveInputStream(InputStream inputStream)  throws Exception {
        if(!LOG_RES) return inputStream;

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        sb.append("\n");
        inputStream.close();
        byte[] contentBytes = sb.toString().getBytes();
        if(!(sb.indexOf("session_token") == 2 || sb.indexOf("guest_token") == 2)){
            writeFile(contentBytes,true);
         }

        return new ByteArrayInputStream(contentBytes);
    }

    private static boolean writeFile(byte[] data,boolean append){
        try {
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File pikoDir = new File(downloadsDir, "Piko");

            if (!pikoDir.exists()) {
                pikoDir.mkdirs();
            }

            File outputFile = new File(pikoDir, "Server-Response-Log.txt");
            return Utils.writeFile(outputFile,data,append);
        }catch (Exception e){
            Utils.logger(e.toString());
        }

        return false;
    }

}