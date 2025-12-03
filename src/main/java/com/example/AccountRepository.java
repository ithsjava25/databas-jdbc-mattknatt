package com.example;

import java.util.List;

public interface AccountRepository {
    List<String> findUsernames();
    List<String> findPasswords();
}
