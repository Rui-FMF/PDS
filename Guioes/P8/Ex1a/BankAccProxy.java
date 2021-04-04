public class BankAccProxy implements BankAccount {
    private BankAccountImpl bank;

    BankAccProxy(String bank, Double initialDeposit) {
        this.bank = new BankAccountImpl(bank, initialDeposit);
    }

    public String getBank() {
        return bank.getBank();
    }

    @Override
    public void deposit(Double amount) {
        bank.deposit(amount);
    }

    // The 2 functions we want to limit access to://

    @Override
    public boolean withdraw(Double amount) {
        if (Company.user == User.OWNER) // Check if the Company's accessing or the owner
            return bank.withdraw(amount);
        else
            return false;
    }

    @Override
    public Double balance() {
        if (Company.user == User.OWNER) // Check if the Company's accessing or the owner
            return bank.balance();
        else {
            return null;
        }
    }

}