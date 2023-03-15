package bankProject;

import bankProject.data.CsvParser;
import bankProject.data.Parser;
import bankProject.data.TsvParser;
import bankProject.service.BankAnalyzer;

import java.io.IOException;

public class Application {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";

    public static void main(String[] args) throws IOException {

        BankAnalyzer bankAnalyzer = new BankAnalyzer();

        // csv 파일, tsv 파일
        Parser csvParser = new CsvParser();
        Parser tsvParser = new TsvParser();

        bankAnalyzer.analyze("bank-simple-data.csv", csvParser);



    }
}
