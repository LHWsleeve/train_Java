package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.File;
import java.io.IOException;


@Controller

public class upLoadContorller {

    @RequestMapping("/upload")
    public String upload(Model model, String username,
                         @RequestParam("headering") MultipartFile file){
        System.out.format("文件上传的信息");
        System.out.format("文件项名："+file.getName());
        System.out.format("文件的真实名字："+ file.getOriginalFilename());
        //文件保存
        try {
            file.transferTo(new File("D:\\",file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg","文件上传失败,"+e.getMessage());

        }


        return "forward:/index.jsp";
    }

}
