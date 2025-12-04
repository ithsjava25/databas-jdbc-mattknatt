package com.example;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<String> findUsernames();
    List<String> findPasswords();
    Optional<Account> findByUsername(String username);
    List<Account> findAccounts();
    boolean createAccount(Account account);
    int countAccounts();
    boolean updatePassword(int id, String password);
    boolean deleteAccount(int id);
}
