package com.ithei.reggie.controller;

import com.ithei.reggie.common.R;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
* 文件上传下载
* */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;
    /*
    * 文件上传
    * */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){//参数名必须和前端保持一致
        //file是一个临时文件，需要转存，否则本次操作结束图片就消失
        //原始文件名
        String originalFilename = file.getOriginalFilename();//abc.jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新生成文件名，防止重名文件覆盖
        String fillName = UUID.randomUUID().toString() + suffix;
        //创建一个目录对象
        File dir = new File(basePath);
        //判断当前目录是否存在
        if(!dir.exists()){
            //目录不存在需要创建
            dir.mkdirs();
        }
        try {
            //将时文件转存
            file.transferTo(new File(basePath + fillName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(file.toString());
        return R.success(fillName);
    }
}
