package com.lei.tool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(HttpServletRequest request,@RequestParam(value = "file", required = true) MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        try {
            String name = file.getOriginalFilename();
        } catch (Exception e) {
            result.put("errcode","1");
            return  result;
        }
        return result;
    }
}
