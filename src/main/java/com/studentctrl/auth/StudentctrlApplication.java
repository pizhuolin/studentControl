package com.studentctrl.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.studentctrl.auth.mapper")
@SpringBootApplication
public class StudentctrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentctrlApplication.class, args);
    }

}

//public class StudentctrlApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(StudentctrlApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(StudentctrlApplication.class, args);
//    }
//}