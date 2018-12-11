

class Date {


 private int month;
 private int day;
 private int year;
 private int dayCount;

 public Date (int month, int day, int year, int dayCount) {
   this.month = month;
   this.day = day;
   this.year = year;
   this.dayCount = dayCount;
 }

 public void newDate () {
    day++;
    dayCount++;
    if(month == 2 && day == 29) {
      month++;
      day = 1;
    } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month ==  8 || month == 10 || month == 12) && day == 32) {
      month++;
      day = 1;
    } else if ((month != 1 || month != 3 || month != 5 || month != 7 || month != 8 || month != 10 || month != 12) && day == 31) {
      month++;
      day = 1;
    }
    if(month == 13){
      year++;
      month = 1;
      day = 1;
    }
  }

 public String getDate () {
   return this.month + "/" + this.day + "/" + this.year + "; The amount of days that have elapsed are: " +dayCount;
 }
}

