package com.iwms.server.controller;

import com.iwms.server.base.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.iwms.server.util.Util.createNewDir;
import static com.iwms.server.util.Util.getFileNameNew;


@RestController
@CrossOrigin
@RequestMapping("/advert")
public class AdvertController {

    //Value注解里面是虚拟路径
    @Value("F:\\myJavaWorkspace\\Iwms\\Lgdb\\src\\main\\resources\\myStatic\\images")
    private String uploadAbsolutePath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response upload(@RequestParam("upload") MultipartFile multipartFile) {
        Response response = null;
        if (!multipartFile.isEmpty()) {
            try {
//                byte[] bytes = multipartFile.getOriginalFilename().getBytes("utf-8");
//                multipartFile.transferTo(new File(uploadAbsolutePath + "\\" + bytes));
//                String s_utf8 = new String(bytes,"utf-8");
//                String url = "http://localhost:3000/myStatic/images/" + s_utf8;
                multipartFile.transferTo(new File(uploadAbsolutePath + "\\" + multipartFile.getOriginalFilename()));
                String url = "http://localhost:3000/myStatic/images/" + multipartFile.getOriginalFilename();
                response = new Response(0, "上传成功", url);
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response(-1, "网络异常", "");
            }
        } else {
            response = new Response(-1, "上传失败", "");
        }
        return response;
    }
}
