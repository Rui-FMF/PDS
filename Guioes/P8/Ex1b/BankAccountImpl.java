class BankAccountImpl implements BankAccount {
    private String bank;
    private Double balance;

    BankAccountImpl(String bank, Double initialDeposit) {
        this.bank = bank;
        balance = initialDeposit;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public void deposit(Double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(Double amount) {
        if (amount > balance)
            return false;
        balance -= amount;
        return true;
    }
    

    @Override
    public Double balance() {
        return balance;
    }
}