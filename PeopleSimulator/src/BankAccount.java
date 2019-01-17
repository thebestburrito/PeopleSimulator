class BankAccount{
    public int balance = 10;

    public BankAccount(){

    }

    public void earnDailyIncome(int income){
        balance = balance + income/365;
    }

    public int getBalance(){
        return balance;
    }

    public void inheritMoney(int amt){
        balance = balance + amt;
    }
}