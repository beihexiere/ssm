package com.bei.controller;

import com.bei.domain.Account;
import com.bei.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/21 - 17:16
 *
 * 账户web
 */
@Controller
@RequestMapping(path="/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户...");
        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping(path = "/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.out.println("表现层：保存一个用户...");
        //调用service方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
