package com.xuanxie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@Controller
public class FileController {
    @RequestMapping("/uploadFilePage")
    public String uploadFilePage(){
        return "uploadFile";
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if(originalFilename==null||originalFilename.equals("")){
            request.setAttribute("msg","上传文件失败");
            return "redirect:/uploadFilePage";
        }
        System.out.println("上传的文件名为 "+originalFilename);
        /*再war包目录下找目录或文件*/
        String savePath=request.getRealPath("/WEB-INF/upload");
        File realPath=new File(savePath);
        if((!realPath.exists())){
            realPath.mkdir();
        }
        System.out.println("文件的保存目录是: "+realPath);

        InputStream inputStream = file.getInputStream();
        File saveFile = new File(realPath + "\\"+originalFilename);
        FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=inputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,len);
        }
        request.setAttribute("msg","文件上传成功");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/downLoadFile")
    @ResponseBody
    public String downLoadFile(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String filename="TS转MP4 使用方法.txt";
        String realPath = request.getRealPath("/WEB-INF/upload");
        if (realPath.isEmpty()){
            return "未找到文件下载地址";
        }
        File realFile = new File(realPath +"\\"+ filename);
        if(realFile.exists()){
            FileInputStream fileInputStream = new FileInputStream(realFile);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName="+ URLEncoder.encode(filename,"UTF-8"));
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
            return "文件上传成功";
        }
        return "未找到文件下载地址";
    }

}
