package com.atguigu.crowd;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class AdminTest {
    //测试数据源
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;



    /*必须将spring-persist-tx.xml导入进来才不会报错*/
    @Autowired
    private AdminService adminService;



    @Test
    public void testTx(){
        Admin admin = new Admin(null, "jack", "123456", "杰克", "jerry@qq.com", null);
        adminService.saveAdmin(admin);

    }

    @Test
    public void testLog(){
        // 获取日志记录对象
        Logger logger = LoggerFactory.getLogger(AdminTest.class);

        //打印不同级别的日志
        logger.debug("Hello I am Debug level!");
        logger.debug("Hello I am Debug level!");
        logger.debug("Hello I am Debug level!");

        logger.info("Info level!");
        logger.info("Info level!");
        logger.info("Info level!");

        logger.warn("Warn level");
        logger.warn("Warn level");
        logger.warn("Warn level");

        logger.error("Error level");
        logger.error("Error level");
        logger.error("Error level");
    }


    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "marry", "123", "马瑞", "jerry@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响的行数为:"+count);
    }
}
