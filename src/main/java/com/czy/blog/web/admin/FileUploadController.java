package com.czy.blog.web.admin;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;


/**
 * 本地图片上传
 */
@Controller
@RequestMapping("/img")
public class FileUploadController {
    @RequestMapping("/imgUpLoad")
    public void imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                            HttpServletRequest request, HttpServletResponse response) throws JSONException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wirte = null;
        JSONObject json = new JSONObject();
        try {
            wirte = response.getWriter();
            //文件存放的路径
            //得到工程的路径：
            System.out.println("得到工程的路径："+System.getProperty("user.dir"));//user.dir指定了当前的路径
            //得到工程目录：
            System.out.println( "得到工程目录："+request.getSession().getServletContext().getRealPath("")); //参数可具体到包名
            //得到IE地址栏地址  request.getRequestURL()
            System.out.println( "得到IE地址栏地址  :"+ request.getRequestURL());
            // 得到相对地址：request.getRequestURI()
            System.out.println( "得到相对地址："+ request.getRequestURI());
            // String path=request.getServletContext().getRealPath("")+"uploaded";
            String path=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";
            String fileName = file.getOriginalFilename();
            fileName= UUID.randomUUID()+fileName.substring(fileName.indexOf("."),fileName.length());
            String destFileName=path+fileName;
            System.out.println("path:"+path);

            File destFile = new File(destFileName);
            if(!destFile.exists()){
                destFile.getParentFile().mkdirs();
            }

            //String url =destFileName;
            //file.transferTo(destFile);
            String url = "http://localhost:8080"
                    + "//upload/"
                    + fileName;
            System.out.println("url:"+url);
            file.transferTo(destFile);
            json.put("success", 1);
            json.put("message", "上传成功");
            json.put("url", url);
        } catch (IllegalStateException | IOException | JSONException e) {
            json.put("success", 0);
            json.put("message", "上传失败");
        }finally{
            wirte.print(json);
            wirte.flush();
            wirte.close();
        }
    }
}

