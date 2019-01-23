class Time {
    private int month;
    private int day;
    private int year;
    private int dayCount;

    public Time (int month, int day, int year, int dayCount) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.dayCount = dayCount;
    }

    public void incrementTime () {
        incrementDay();
        if(month == 2 && day == 29) {
            incrementMonth();
        } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month ==  8 || month == 10 || month == 12) && day == 32) {
            incrementMonth();
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            incrementMonth();
        }
        if(month == 13){
            incrementYear();
        }
    }
    private void incrementDay() {
        day++;
        dayCount++;
    }
  

 private void incrementMonth()
 {
     month++;
     day = 1;
 }
 private void incrementYear()
 {
     year++;
     month = 1;
     day = 1;
 }
 public int getDay()
 {
     return day;
 }
 public int getMonth()
 {
     return month;
 }
 public int getYear()
 {
     return year;
 }
 public int getDayCount()
 {
     return dayCount;
 }
 public String dateToString()
 {
     return (month+"/"+day+"/"+year);
 }

 public String getSeason(){
     if(month == 12 || month == 1 || month == 2){
         return "winter";
     }
     else if(month == 3 || month == 4 || month == 5){
         return "spring";
     }
     else if(month == 6 || month == 7 || month == 8){
         return "summer";
     }
     else{
         return "fall";
     }
 }
}

