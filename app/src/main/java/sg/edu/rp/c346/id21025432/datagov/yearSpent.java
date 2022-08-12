package sg.edu.rp.c346.id21025432.datagov;

public class yearSpent {
    private int year;
    private int totalSpent;

    public yearSpent(int year, int totalSpent) {
        this.year = year;
        this.totalSpent = totalSpent;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }

    @Override
    public String toString() {
        return
                "Year: " + year + "\n"+ "\n"+
                "Total Money Spent on Education: $" + totalSpent + "\n";
    }
}
