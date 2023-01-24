package core.service;

import core.data.Account;
import core.service.interfaces.IBankService;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.UnknownAccountException;

import java.util.List;

public class BankService implements IBankService {
    @Override
    public void trasnfert(Account sender, Account receiver, double amount) {
        withdraw(sender, amount);
        credit(receiver, amount);
    }

    @Override
    public void credit(Account account, double amount) {
        account.setAmount(account.getAmount()+amount);
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.setAmount(account.getAmount()-amount);
    }
}
