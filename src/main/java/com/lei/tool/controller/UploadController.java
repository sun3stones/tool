package com.lei.tool.controller;

import com.sun.imageio.plugins.common.ImageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(HttpServletRequest request,@RequestParam(value = "file", required = true) MultipartFile file,String type) {
        Map<String, Object> result = new HashMap<>();
        try {
            StringBuilder filename = new StringBuilder(file.getOriginalFilename());
            filename.insert(filename.lastIndexOf("."),"_"+System.currentTimeMillis());
            String path = uploadFolder+type+"/";
            File folder = new File(path);
            if(!folder.exists()){
                folder.mkdirs();
            }
            path += filename.toString();
            FileOutputStream outFile = new FileOutputStream(path);
            InputStream in = file.getInputStream();
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = in.read(buffer)) != -1) {
                outFile.write(buffer, 0, i);
            }
            outFile.flush();
            outFile.close();
            result.put("errcode",0);
            result.put("msg","文件上传成功");
            result.put("filename",filename);
        } catch (Exception e) {
            result.put("errcode",1);
            result.put("msg","文件上传失败");
            return  result;
        }
        return result;
    }
}
