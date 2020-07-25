package com.bei.service;

import com.bei.domain.Account;

import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/21 - 17:11
 */
public interface AccountService {
    //查询所有信息
    List<Account> findAll();
    //查询单个信息
    void saveAccount(Account account);
}
