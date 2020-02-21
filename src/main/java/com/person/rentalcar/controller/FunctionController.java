package com.person.rentalcar.controller;

import com.person.rentalcar.utils.email.FileUtil;
import com.person.rentalcar.model.OrderExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/18
 */
@RestController
public class FunctionController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/email/send")
    public String send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("825543676@qq.com");
        message.setTo("825543676@qq.com");
        message.setSubject("我来自SpringBoot");
        message.setText("这是一封测试邮件，感谢您的查看");
        javaMailSender.send(message);
        return "发送成功!";
    }

    @RequestMapping("/excel")
    public void excel(HttpServletResponse response) {
        List<OrderExcel> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            OrderExcel user = OrderExcel.builder().userId(i).brand("宝马" + i).carId(i).endTime(new Date()).orderId(i).seriesname(i + "系").startTime(new Date()).status(false).build();
            userList.add(user);
        }
        FileUtil.exportExcel(userList,OrderExcel.class,"商品.xls",response);
        //todo 导出的为流，如果需要生成文件，那么需要新建一个文件把流写进去
    }

    /***
     * @describtion: 文件上传
     * @author: yejun
     * @time: 2020/1/18 15:53
     * @params: * @Param file:
     * @return: * @return: java.lang.String
    */
    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }



    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
