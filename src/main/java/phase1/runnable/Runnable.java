package phase1.runnable;

import phase1.BankManagement;
import phase1.ReadFile;

public class Runnable {

    public static void main(String[] args) {
        ReadFile data = new ReadFile();
        String filename = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";
        data.csvRead(filename);

        BankManagement bm = new BankManagement();
        bm.sumIncome();             // 총 수입
        bm.sumExpense();            // 총 지출
        bm.sumAmount();             // 총 입출금
        bm.sumMonthly("02");        // 월별 총합
        bm.sumCategory("식료품");     // 카테고리별 총합
        bm.countMonthly("05");      // 월별 입출금 건수
        // 지출이 가장 높은 상위 10건
        bm.itemExpense();           // 많이 소비한 항목
    }


}
