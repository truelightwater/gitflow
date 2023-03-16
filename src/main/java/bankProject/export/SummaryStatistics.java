package bankProject.export;

public class SummaryStatistics {

    private final long sum;
    private final int max;
    private final int min;
    private final double average;

    public SummaryStatistics(long sum, int max, int min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
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
