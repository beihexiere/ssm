package com.bei.dao;

import com.bei.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/21 - 17:06
 *
 * 账户dao接口
 */
@Repository
public interface AccountDao {
    //查询所有信息
    @Select("select * from account")
    List<Account> findAll();
    //查询单个信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);
}
