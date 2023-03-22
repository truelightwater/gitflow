package bankProject.export;

import java.util.IntSummaryStatistics;

public class SummaryStatistics {

    private final long sum;
    private final int max;
    private final int min;
    private final double average;

    public SummaryStatistics(IntSummaryStatistics intSummaryStatistics) {
        this.sum = intSummaryStatistics.getSum();
        this.max = intSummaryStatistics.getMax();
        this.min = intSummaryStatistics.getMin();
        this.average = intSummaryStatistics.getAverage();
    }

    public long getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }
}
