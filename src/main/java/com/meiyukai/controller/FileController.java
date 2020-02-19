package com.meiyukai.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class FileController {


    /**
     *传统方式实现文件上传
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/commonUpload")
    public String commonUpload(MultipartFile upload) throws Exception{

        if(upload!=null){
            String path = "/Users/meiyukai/Documents/test_upload/";
            String originName =  upload.getOriginalFilename();
            String newName = UUID.randomUUID().toString().replace("-","");
            String suffix = originName.substring(originName.lastIndexOf("."));
            File file   =   new File(path,newName+suffix);
            upload.transferTo(file);
        }else{
            System.out.println("--------upload 为空！-----------");
        }
        return "success";
    }

    /**
     * 跨服务器实现文件上传
     */

    @RequestMapping(value = "/betweenServers")
   public String betweenServersUpload(MultipartFile upload) throws Exception{
        String path = "http://localhost:9090/uploads/";
        String originName  = upload.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replace("-","");
        String suffix = originName.substring(originName.lastIndexOf("." ));
        Client client = Client.create();
        //和服务器建立连接
        WebResource webResource = client.resource(path + newName + suffix);
        //上传文件
        webResource.put(upload.getBytes());
//        webResource.put(upload);   需要转换为字节流上传


        return "success";
   }






}
