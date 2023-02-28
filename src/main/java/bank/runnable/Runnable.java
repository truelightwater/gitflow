package bank.runnable;

import bank.BankManagement;
import bank.readfile.csvReadFile;
import bank.readfile.jsonReadFile;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException, ParseException {
        csvReadFile data = new csvReadFile();
        jsonReadFile jsonReadFile = new jsonReadFile();

        String csvFileName = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";
        String jsonFileName = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.json";

        data.readFile(csvFileName);
        jsonReadFile.readFile(jsonFileName);

        BankManagement bm = new BankManagement();
        bm.sumIncome();             // 총 수입
        bm.sumExpense();            // 총 지출
        bm.sumAmount();             // 총 입출금
        bm.sumMonthly("02");        // 월별 총합
        bm.sumCategory("식료품");     // 카테고리별 총합
        bm.countMonthly("05");      // 월별 입출금 건수
                                    // 지출이 가장 높은 상위 10건
        bm.itemExpense();           // 많이 소비한 항목
        // 데모 데이터를 생성해야 합니다.



    }
}
