package com.atguigu.admin.Controller;

import com.atguigu.admin.Service.CustomersService;
import com.atguigu.admin.Service.UsertabService;
//import com.atguigu.admin.Service.impl.UsertabServiceImpl;
import com.atguigu.admin.Service.impl.CustomersServiceImpl;
import com.atguigu.admin.bean.Customers;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.bean.Usertable;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {

//    @Autowired
//    UsertabServiceImpl usertabService;
    @Autowired
    CustomersServiceImpl customersService;
    @GetMapping("/basic_table")
    public String basic_table(){


        return "table/basic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
//        List<User> users = Arrays.asList(new User("张三", "213"),
//                new User("李四", "678"),
//                new User("韩非", "ccscsa"),
//                new User("小庄", "sadasdas"));
//        model.addAttribute("users",users);
//        return "table/dynamic_table";
//        List<Customers> list = customersService.list();
//        model.addAttribute("customers",list);
        Page<Customers> page = new Page<>(pn,2);
        Page<Customers> page1 = customersService.page(page, null);
        model.addAttribute("page",page1);
        List<Customers> records = page1.getRecords();
        long current = page1.getCurrent();
        long pages = page1.getPages();
        long total = page1.getTotal();
        return "table/dynamic_table";
    }
    @GetMapping("/user/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        boolean result = customersService.removeById(id);
        System.out.println("删除成功");
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("/update")
    public String update(){
        return "Update";
    }
    @GetMapping("/user/update/{id}")
    public String updateById(@PathVariable("id")Integer id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        Customers customers = new Customers();
        customers.setId(id);
        customersService.updateById(customers);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }
}
