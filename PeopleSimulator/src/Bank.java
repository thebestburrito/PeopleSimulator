
class Bank {
    public int checkings;
    public int savings;
    public int debt;
    public int accountNumber;

    public Bank(int accountNumber,int checkings, int savings){
        this.accountNumber = accountNumber;
        this.checkings = checkings;
        this.savings = savings;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    //Account number for each person 16 or older as names can be the same
    public int getCheckings(){
        return checkings;
    }
    public int getSavings(){
        return savings;
    }
}