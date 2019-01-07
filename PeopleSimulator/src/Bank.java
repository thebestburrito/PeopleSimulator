
class Bank {
    public int checkings;
    public int savings;
    public int debt;
    public int accountNumber;
    public int deposit;
    public double tax;

    public Bank(int accountNumber,int checkings, int savings){
        this.accountNumber = accountNumber;
        this.checkings = checkings;
        this.savings = savings;
    }

    public void updateCheckings(){
    //takes other 80 (?) percent of deposits
    }

    public void updateSavings(){
    //take 20 (?) percent of deposits
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
    public double tax(){
        return tax;
    }
}