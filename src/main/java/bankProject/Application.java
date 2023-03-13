package bankProject;

import bankProject.data.CsvParser;
import bankProject.data.Parser;
import bankProject.data.TsvParser;
import bankProject.service.BankAnalyzer;

import java.io.IOException;


public class Application {

    public static void main(String[] args)  {

        BankAnalyzer bankAnalyzer = new BankAnalyzer();

        // csv 파일, tsv 파일
        Parser csvParser = new CsvParser();
        Parser tsvParser = new TsvParser();

        bankAnalyzer.analyze("bank-simple-data.csv", csvParser);


    }
}
