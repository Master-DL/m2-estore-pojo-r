package core.service;

import core.data.Account;
import estorePojo.exceptions.InsufficientBalanceException;

public class AccountService {

    public void credit(Account account, double amount) {
        account.setAmount(account.getAmount()+amount);
    }

    public void withdraw(Account account, double amount) throws InsufficientBalanceException {
        if ( account.getAmount() < amount )
            throw new InsufficientBalanceException(account.getOwner());
        credit(account, -amount);
    }
}
