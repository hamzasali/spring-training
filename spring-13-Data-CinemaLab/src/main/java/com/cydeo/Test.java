package com.cydeo;

import com.cydeo.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {
    private final AccountRepository accountRepository;

    public Test(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(accountRepository.findByOrderByAge());



    }
}
