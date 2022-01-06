package com.atguigu.admin.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class formtestcontroller {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "Form/form_layouts";
    }

    /**
     * 文件上传
     * @param email
     * @param username
     * @param header
     * @param photos
     * @return
     * @throws IOException
     */
    @PostMapping("/loadup")
    public String loadup(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerimg")MultipartFile header,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息 email={},username={},header={},photos={}",email,username,header.getSize(),photos.length);
        if(!header.isEmpty()){
            String originalFilename = header.getOriginalFilename();
            header.transferTo(new File("D:\\SpringBoot2\\photos\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\SpringBoot2\\photos\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
