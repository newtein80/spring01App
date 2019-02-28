package com.devkuma.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SampleAspectConfig
 */
@Configuration
@EnableAspectJAutoProxy // Bean 정의 파일에 넣었던 <aop:aspectj-autoproxy/> 태그에 해당하는 것. AspectJ의 자동 프록시 기능이 ON이 되고, 자동으로 Aspect 클래스의 메소드 삽입이 이루어지게 된다.
public class SampleAspectConfig {

    @Bean
    public SampleAopBean sampleAopBean() {
        return new SampleAopBean("this is AspectJ bean.");
    }

    @Bean
    public SampleAspect sampleAspect() {
        return new SampleAspect();
    }
}