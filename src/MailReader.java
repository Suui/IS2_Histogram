import java.io.*;
import java.io.FileReader;
import java.util.*;


public class MailReader {

    private final String filePath;


    public MailReader(String filePath) {
        this.filePath = filePath;
    }


    public String[] readDomains() {
        ArrayList<String> domainList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                if (line.contains("@"))
                    domainList.add(line.split("@")[1]);
                line = reader.readLine();
            }

        } catch (IOException e) { }

        return domainList.toArray(new String[domainList.size()]);
    }
}
