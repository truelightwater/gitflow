import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class InformationDAO {

    private static LinkedHashMap<Integer, Information> infoMap;

    public InformationDAO() {
        if (infoMap == null) {
            readData();
        }
    }

    public LinkedHashMap<Integer, Information> getInfoMap() {
        return infoMap;
    }

    public void readData() {
        String filePath = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";
        InputStream is = InformationDAO.class.getResourceAsStream(filePath);
        if (is == null) {
            System.out.println("No data in " + filePath);
            return ;
        }

        infoMap = new LinkedHashMap<>();

        String[] vars;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            while ((line = br.readLine()) != null) {
                vars = line.split(",");

                String id = vars[0].trim();
                String date = vars[1].trim();
                int amount = Integer.parseInt(vars[2].trim());
                String info = vars[3].trim();

                infoMap.put(Integer.valueOf(id), new Information(id, date, amount, info));
                System.out.println(infoMap);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        InformationDAO sample = new InformationDAO();
        sample.readData();

    }
}
