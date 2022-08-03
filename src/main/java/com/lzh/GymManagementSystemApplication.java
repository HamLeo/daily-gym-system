package com.lzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

//@SpringBootApplication标注这个类是一个spring boot的应用
@SpringBootApplication
public class GymManagementSystemApplication {

    //将springboot应用启动
    public static void main(String[] args) {
        SpringApplication.run(GymManagementSystemApplication.class, args);
    }

}
