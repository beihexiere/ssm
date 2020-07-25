package com.bei;

import com.bei.dao.AccountDao;
import com.bei.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/22 - 15:49
 */
public class TestMyBatis {
    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession openSession = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = openSession.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list=accountDao.findAll();
        for(Account account:list){
            System.out.println(account);
        }
        openSession.close();
        in.close();
    }
    @Test
    public void run2() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession openSession = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = openSession.getMapper(AccountDao.class);
        //存入一个Account
        Account account=new Account();
        account.setName("ariana");
        account.setMoney(200);
        accountDao.saveAccount(account);
        //提交事务
        openSession.commit();
        openSession.close();
        in.close();
    }
}
