package com.bhaskarmantralahub.config;

import java.io.*;

public class LogAppender {

    public static FileOutputStream fileOutputStream;
    public static PrintStream filePrintStream;

    public static void saveSystemLogsToFile() {
        File logFile = new File("logs/console.log");

        try {
            if (!logFile.exists()) {
                // Create a new file if it doesn't exist
                boolean created = logFile.createNewFile();

                if (created) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("Unable to create the file.");
                }
            }
            // Create a FileOutputStream for the log file
            fileOutputStream = new FileOutputStream(logFile, true);

            // Create a custom PrintStream that writes to the log file
            filePrintStream = new PrintStream(fileOutputStream);

            // Set the custom PrintStream as the value of System.out
            System.setOut(filePrintStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStream() {
        if (fileOutputStream != null && filePrintStream != null) {
            // Flush and close the filePrintStream when done
            filePrintStream.flush();
            filePrintStream.close();
        }
    }

}
