package com.atguigu.admin.Controller;

import com.atguigu.admin.Service.impl.AccountServiceImpl;
import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountServiceImpl accountService;
//    @PostMapping("/save")
//    @ResponseBody
//    public Account save(Account account){
//        accountService.saveacc(account);
//        return account;
//    }
    @GetMapping("/acc")
    @ResponseBody
    public Account getacc(@RequestParam("id") Integer id){
        return accountService.getacc(id);
    }
    @GetMapping("/sql")
    @ResponseBody
    public String sqltest(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from lianjiatab", Long.class);

        return aLong.toString();
    }
    @GetMapping({"/","login"})
    public String loginpage(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUsername())&&"1234".equals(user.getPassword())){
            session.setAttribute("loginuser",user);

            //登录成功重定向到main页面，重定向防止表单重复提交
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }
    @GetMapping("/main.html")
    public String mainpage(HttpSession session,Model model){
        //是否登录拦截器，过滤器
//        Object msg = session.getAttribute("loginuser");
//        if(msg!=null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录");
//            return "login";
//
//        }
        return "main";

    }
}
