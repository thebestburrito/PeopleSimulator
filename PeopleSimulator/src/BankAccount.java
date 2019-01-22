class BankAccount{
    public int balance = 10;

    public BankAccount(){

    }
//earn's daily income based on the total yearly income
    public void earnDailyIncome(int income){
        //System.out.println(((double)(income/365)));
        balance = balance + ((int)(income/365));
    }
//method to get a balance for a given person
    public int getBalance(){
        return balance;
    }
//inherits money from relative (doesn't do anything)
    public void inheritMoney(int amt){
        balance = balance + amt;
    }
}