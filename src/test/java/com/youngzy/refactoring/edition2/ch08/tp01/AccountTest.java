package com.youngzy.refactoring.edition2.ch08.tp01;

import com.youngzy.refactoring.edition2.ch08.tp01.v01.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getBankCharge() {
        AccountType type = new AccountType(true);
        Account account = new Account(10, type);

        assertEquals(17, account.getBankCharge(), 0.1);
    }
}