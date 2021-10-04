package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.ParamData;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author rookie
 * @create 2021-10-03-12:18
 */
@Controller
public class TestHandler {
    @Autowired
    public AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @ResponseBody
    @RequestMapping("/send/compose/object.json")
    public ResultEntity<Student> testReceviceComposeObject(@RequestBody Student student, HttpServletRequest request){
        boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
        logger.info("judgeRequestType="+judgeRequestType);

        logger.info(student.toString());
        //将 "查询"到的Student
        ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);

        return resultEntity;
    }



    @RequestMapping("/send/array/one.html")
    public @ResponseBody String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array){

        for (Integer number :array){
            System.out.println("number: " + number);
        }
        return "Success1";
    }
    @RequestMapping("/send/array/two.html")
    public @ResponseBody String testReceiveArrayTwo(ParamData paramData){

        List<Integer> array = paramData.getArray();
        for (Integer number :array){
            System.out.println("number: " + number);
        }
        return "Success2";
    }
    @RequestMapping("/send/array/three.html")
    public @ResponseBody String testReceiveArrayThree(@RequestBody List<Integer> array){


        for (Integer number :array){
            logger.info("number: " + number);
            System.out.println("number: " + number);
        }
        return "Success3";
    }


    @RequestMapping("/test/ssm.html")
    public String testssm(Model model, HttpServletRequest request) {
        boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
        logger.info("judgeRequestType="+judgeRequestType);

        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList", adminList);

        /*异常信息*/
        System.out.println(10 / 0);

        //空指针异常
//        String A = null;
//        System.out.println(A.length());
        return "targe";
    }


}
