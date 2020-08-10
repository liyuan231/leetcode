package algorithm;

public class SmartDate implements Comparable<SmartDate> {
    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] DAYOFTHEWEEK = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday",};
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int year, int month, int day) {
        if (!isValid(year, month, day)) {
            throw new IllegalArgumentException("日期非法！");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public SmartDate(String date) {
        String[] fields = date.split("-");
        if (fields.length != 3) {
            throw new IllegalArgumentException("日期格式非法，应为YYYY-mm-DD");
        }
        year = Integer.parseInt(fields[0]);
        month = Integer.parseInt(fields[1]);
        day = Integer.parseInt(fields[2]);
        if (!isValid(year, month, day)) {
            throw new IllegalArgumentException("日期非法！");
        }
    }

    private boolean isValid(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > DAYS[month]) {
            return false;
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            return false;
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public int year() {
        return year;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public SmartDate next() {
        if (isValid(year, month, day + 1)) {
            return new SmartDate(year, month, day + 1);
        } else if (isValid(year, month + 1, day)) {
            return new SmartDate(year, month + 1, day);
        } else {
            return new SmartDate(year + 1, month, day);
        }
    }

    public boolean isAfter(SmartDate that) {
        return compareTo(that) > 0;
    }

    public boolean isBefore(SmartDate that) {
        return compareTo(that) < 0;
    }

    @Override
    public int compareTo(SmartDate that) {
        if (this.year < that.year) {
            return -1;
        }
        if (this.year > that.year) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.day < that.day) {
            return -1;
        }
        if (this.day > that.day) {
            return 1;
        }
        return 0;
    }

    public String dayOfTheWeek() {
        int m = month;
        int y = year;
        int d = day;
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }
        int c = year / 100;
        y = y - c * 100;
        int w = y + y / 4 + c / 4 - 2 * c + 26 * (m + 1) / 10 + d - 1;
        while (w < 0) {
            w += 7;
        }
        System.out.println(w%7);
        return DAYOFTHEWEEK[w%7];
    }

    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(2020, 12, 25);
        System.out.println(smartDate.dayOfTheWeek());
    }

    @Override
    public String toString() {
        return "SmartDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object other) {
//        return super.equals(obj);
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        SmartDate that = (SmartDate) other;
        return (this.year == that.year) && (this.month == that.month) && (this.day == that.day);
    }
}
