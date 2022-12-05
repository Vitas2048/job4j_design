package ru.job4j.ood.dip.bankexample;

import java.util.HashSet;

public class User {
    HashSet<Bank> banks = new HashSet<>();

    public boolean addAcc(Bank bank) {
        return banks.add(bank);
    }

    public void checkMoney(Bank bank) {
        for (Bank userBank : banks) {
            if (userBank.equals(bank)) {
                bank.check();
            }
        }
    }
}
