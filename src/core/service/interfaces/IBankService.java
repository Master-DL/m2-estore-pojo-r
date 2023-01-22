package core.service.interfaces;

import core.data.Account;

public interface IBankService {

    void trasnfert(Account sender, Account receiver);

    void credit(Account account, double amount);

    void withdraw(Account account, double amount);

}
