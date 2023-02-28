package phase1;

import java.util.*;

public class BankManagement {

    private static final String filename = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";
    final int month_index = 1;
    final int amount_index = 2;
    final int category_index = 3;

    ReadFile readFile = new ReadFile();
    ArrayList<ArrayList<String>> arrayLists = readFile.csvRead(filename);

    public int sumIncome() {
         int incomeSum = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {

                if (loop == amount_index && 0 < Integer.valueOf(arrayLists.get(index).get(loop))) {
                    incomeSum += Integer.valueOf(arrayLists.get(index).get(loop));
                }
            }
        }
        System.out.println("총 수입 : " +incomeSum+ " 원");
        return incomeSum;
    }

    public int sumExpense() {
        int ExpenseSum = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {

                if (loop == amount_index && 0 > Integer.valueOf(arrayLists.get(index).get(loop))) {
                    ExpenseSum += Integer.valueOf(arrayLists.get(index).get(loop));
                }
            }
        }
        System.out.println("총 지출 : "+ExpenseSum+ " 원");
        return ExpenseSum;
    }

    public int sumAmount() {
        int total = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {
                if (loop == amount_index) {
                    total += Integer.valueOf(arrayLists.get(index).get(loop));
                }
            }
        }
        System.out.println("입출금 총합 : "+total+ " 원");
        return total;
    }

    public int sumMonthly(String month) {
        int sum = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {
                if (loop == month_index) {

                    String str = arrayLists.get(index).get(loop);
                    String[] num = str.split("-");

                    if (month.equals(num[0])) {
                        sum += Integer.parseInt(arrayLists.get(index).get(loop+1));
                    }
                }
            }
        }
        System.out.println("월별 총합 : "+sum+ " 원");
        return sum;
    }

    public int sumCategory(String category) {
        int sum = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {
                if (loop == category_index) {
                    if (category.equals(arrayLists.get(index).get(loop))) {
                        sum += Integer.parseInt(arrayLists.get(index).get(loop-1));
                    }

                }
            }
        }
        System.out.println(category+" 별 총합 : "+sum+ " 원");
        return sum;
    }

    public int countMonthly(String month) {
        int count = 0;

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {
                if (loop == month_index) {

                    String str = arrayLists.get(index).get(loop);
                    String[] num = str.split("-");

                    if (month.equals(num[0])) {
                        count++;
                    }
                }
            }
        }
        System.out.println("월별 입출금 건수 : "+count+ " 건");
        return count;
    }

    // 지출이 가장 높은 상위 10건 (샘플 데이터는 7건)

    public String itemExpense() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int index = 0; index < arrayLists.size(); index++) {
            for (int loop = 0; loop < arrayLists.get(index).size(); loop++) {
                if (loop == category_index) {
                    map.put(arrayLists.get(index).get(loop), Integer.parseInt(arrayLists.get(index).get(loop-1)));
                }
            }
        }
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Map.Entry<String, Integer> minEntry = Collections.min(map.entrySet(), comparator);
        System.out.println("가장 많이 소비한 항목 : "+minEntry.getKey());

        return minEntry.getKey();
    }
}
