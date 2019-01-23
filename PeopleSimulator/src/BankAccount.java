class BankAccount{
    public double balance = 0;

    public BankAccount(){

    }
//earn's daily income based on the total yearly income
    public void earnDailyIncome(double income){
        balance = (int)(balance + ((income/365)));
    }
//method to get a balance for a given person
    public double getBalance(){
        return balance;
    }
//inherits money from relative (doesn't do anything)
    public void inheritMoney(int amt){
        balance = balance + amt;
    }
}