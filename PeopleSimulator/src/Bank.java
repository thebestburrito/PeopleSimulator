
class Bank {
    public double balance;
    public int debt;
    public int accountNumber;
    public int deposit;

public Bank(int accountNumber, double balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
}

    public void updateBalance(){

    }
    //Will updatethe balance of the account
    public int getAccountNumber(){
        return accountNumber;
    }
    //Returns the account number for a person

    public double getBalance(){
        return balance;
    }
}