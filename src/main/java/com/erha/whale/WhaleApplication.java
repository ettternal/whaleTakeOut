package com.erha.whale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
代码逻辑
编写Controller类接收请求参数  --->Service  实现业务逻辑 ----> Mapper类查询数据库
 */

@Slf4j  //lombok提供，可以省去实体类中get，set方法的书写通过注解代替，可以直接使用log输出info的日志
@SpringBootApplication
public class WhaleApplication {
    public static void main(String[] args) {
        SpringApplication.run(WhaleApplication.class,args);
        //在类上使用Slf4j就可以在方法中使用log.info在控制台输出日志
        log.info("项目启动成功！！！");
    }
}
