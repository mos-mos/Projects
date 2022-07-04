package com.construction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @作者: Steel.D虫洞时空
 * @时间: 2021-5-18 16:00
 * @版本 1.0
 * 祖师爷保佑，永无Bug
 */
/*security通用配置类
1、自定义用户业务   UserDetailsService 封装的默认用户业务接口
2、用户名和密码配置
3、密码的解析
4、核心配置
。。。。。
*/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userService;

    /**
     * 配置用户名和密码
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /**
     * @return
     * @Author Steel.D
     * @Description 配置密码解析器
     * @Date 2021-5-19 10:13
     * @Param
     **/
    @Bean
    protected PasswordEncoder passwordEncoder() {
        //base64 md5.....
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                //表单登录
                .formLogin()
                //登录页面
                .loginPage("/login.html")
                //登录访问路径，表单路径
                .loginProcessingUrl("/login")
                //登录成功
                .defaultSuccessUrl("/index.html").permitAll()
                //登录失败
                .failureUrl("/error.html")
                .and()
                //认证配置
                .authorizeRequests()
                .antMatchers("/login.html", "/login").permitAll()  //permitAll() 无条件允许访问
                //配置静态页面可以访问
                .antMatchers("/js/**", "/css/**", "/img/**", "/images/**", "/favicon.ico").permitAll();
                //任何请求
//                .anyRequest()
                //都需要身份验证
//                .authenticated();

        //认证通过之后全部放行（不拦截）
        http.authorizeRequests()
                .anyRequest()
                .authenticated();


        //配置退出
        http.logout()
                //退出路径
                .logoutUrl("/logout")
                //退出跳转路径
                .logoutSuccessUrl("/login.html");

        //        运行页面iframe操作
        http.headers().frameOptions().sameOrigin();
    }
}
