package bankProject;

import bankProject.data.CsvParser;
import bankProject.data.Parser;
import bankProject.data.TsvParser;
import bankProject.service.BankAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Application {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private String logTest() {
        String name = "Spring";

        log.trace("trace log = {}", name);
        log.debug("debug log = {} ", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log ={}", name);

        return "ok";
    }

    public static void main(String[] args)  {

        Application ap = new Application();
        ap.logTest();

        BankAnalyzer bankAnalyzer = new BankAnalyzer();

        // csv 파일, tsv 파일
        Parser csvParser = new CsvParser();
        Parser tsvParser = new TsvParser();

        try {
            bankAnalyzer.analyze("bank-simple-data.csv", csvParser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bankAnalyzer.analyze("bank-simple-data.tsv", tsvParser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
