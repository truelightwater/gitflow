package phase1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public ArrayList<ArrayList<String>> csvRead(String fileName) {

        ArrayList<ArrayList<String>> arr2List = new ArrayList<ArrayList<String>>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;

                String[] temp = line.split(",");
                ArrayList<String> arrline = new ArrayList<>();

                for (int i = 0; i < temp.length; i++) {
                    arrline.add(temp[i].trim());
                }
                arr2List.add(arrline);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

        return arr2List;
    }
}
