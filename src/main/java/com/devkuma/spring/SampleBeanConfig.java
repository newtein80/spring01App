package com.devkuma.spring;

import com.devkuma.spring.aop.SampleAopBean;
import com.devkuma.spring.aop.SampleMethodAdvice;
// import com.devkuma.spring01demo.SampleBean;
// import com.devkuma.spring01demo.SampleBeanInterface;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration 어노테이션을 붙여 SampleAopConfig 클래스를 선언하고, Bean 인스턴스를 반환하는 메서드에 @Bean 어노테이션 붙여서 Bean을 취득할 수 있도록 하고 있다.
 */
/**
 * SampleBeanConfig (POJO Class)
 */
@Configuration // 해당 클래스가 Bean의 설정을 할 것이라는 것
// @ComponentScan // 컨포넌트를 검색하여 인스턴스를 생성하여 ApplicationContext에 등록하는 것이다. 컨포넌트(@Component를 붙인 클래스)를 이용할 경우에는 설정 클래스에 반드시 이 어노테이션을 꼭 추가해야 한다. 이렇게 하면 컨포넌트가 자동으로 인스턴스화되고 사용할 수 있게 된다.
public class SampleBeanConfig {

    /**
    // 메소드를 Bean 인스턴스 생성을 위한 것으로 인식한다. 이것을 붙인 메소드는 반드시 Bean 인스턴스를 반환 값으로 지정해야 한다.
    // SampleBeanInterface 인스턴스를 Bean으로 생성하기 위한 설정 클래스를 정의하고 있다는 의미가 된다.
    // SampleBeanConfig 클래스의 @Bean 지정된 메서드 (sampleBean)로 new를 이용해서 인스턴스를 얻을 수 있고, 이를 이용되고 있는 것을 알 수 있을 것이다.
    @Bean
    public SampleBeanInterface sampleBean(){
        return new SampleBean("설정 클래스에서 만든 인스턴스입니다.");
    }
     */

    private SampleAopBean sampleAopBean = new SampleAopBean("this is message bean.");
    private SampleMethodAdvice sampleMethodAdvice = new SampleMethodAdvice();

    @Bean
    public SampleAopBean sampleAopBean() {
        return sampleAopBean;
    }

    @Bean
    public SampleMethodAdvice sampleMethodAdvice() {
        return sampleMethodAdvice;
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean() {
        /**
         * "setTarget"과 "setInterceptorNames"가
         * 먼저 bean.xml에서 기술하고 있었던 <property name="target">와 <property name="interceptorNames">에 해당하는 처리한다는 것
         */
        ProxyFactoryBean fBean = new ProxyFactoryBean();
        fBean.setTarget(sampleAopBean);
        fBean.setInterceptorNames("sampleMethodAdvice");
        return fBean;
    }
}