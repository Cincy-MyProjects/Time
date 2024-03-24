public class Time {
    private int hours, minutes, seconds;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void increment(int secondsToAdd) {
        this.seconds += secondsToAdd;
        this.minutes += this.seconds / 60;
        this.seconds %= 60;
        this.hours += this.minutes / 60;
        this.minutes %= 60;
        this.hours %= 24;
    }

    public void print(boolean military) {
        if (military) {
            System.out.printf("Time in 24 hour format :%d:%02d:%02d \n", this.hours, this.minutes, this.seconds);

        } else {
            String period = (this.hours < 12) ? "AM" : "PM";
            int hours12 = (this.hours == 0 || this.hours == 12) ? 12 : this.hours % 12;
            System.out.printf("Time in 12 hour format :%d:%02d:%02d %s \n", hours12, this.minutes, this.seconds, period);
        }
    }

    public static Time fromString(String timeString) {
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return new Time(hours, minutes, seconds);
    }
}
