package com.example;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<String> findUsernames();
    Optional<Account> findByUsername(String username);
    List<Account> findAccounts();
    boolean createAccount(Account account);
    boolean updatePassword(int id, String password);
    boolean deleteAccount(int id);
}
