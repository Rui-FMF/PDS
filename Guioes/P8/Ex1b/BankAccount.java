interface BankAccount {
    void deposit(Double amount);

    boolean withdraw(Double amount);

    Double balance();
}