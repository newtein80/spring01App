package com.devkuma.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * SampleAspect
 */
@Aspect
public class SampleAspect {

    /**
     * 메소드의 실행 전에 삽입하는 처리임을 나타내는 어노테이션이다. Spring AOP에 있는 "before"과 유사한 것으로 생각해도 된다.
     * ("execution (...... 할당되는 메소드의 지정 ...)") : 어떤 메소드에 이 메소드 삽입 할 것인지를 지정
     * 패키지 이름부터 제대로 정확하게 메소드를 지정해야 한다.
     * 와일드 카드(*)를 사용할 수 있기 때문에, 그것을 이용하여 특정 패키지와 클래스의 모든 메소드 등을 지정할 수 있다.
     * 또한 지정하는 메소드의 인수도 ".." 기호로 불특정 인수를 지정할 수 있다.
     * 
     * XX com.devkuma.spring.aop.SampleAopBean.XX(XX)
     * 맨 처음에있는 XX는 public이나 private 같은 것이 지정된 경우를 생각하여 붙여 있다.
     * 그리고 SampleAopBean의 후에 붙은 XX는 이 클래스 내에 있는 어떤 방법도 모두 대상으로 지정하는 것이다.
     * 또, (XX)는 인수가 어떤 형태여도 해당되도록 하기 위한 것
     */
    @Before("execution(* com.devkuma.spring.aop.SampleAopBean.*(..))")
    public void before() {
        System.out.println("[Aspectj] before:");
    }

    /**
     * 메소드의 실행 후에 삽입되는 처리인 것을 나타내는 어노테이션이다. Spring AOP에 있는 "afterRunning"에 해당하는 것으로 생각하면 된다.
     * ("execution (...... 할당되는 메소드의 지정 ...)") : 어떤 메소드에 이 메소드 삽입 할 것인지를 지정
     * 패키지 이름부터 제대로 정확하게 메소드를 지정해야 한다.
     * 와일드 카드(*)를 사용할 수 있기 때문에, 그것을 이용하여 특정 패키지와 클래스의 모든 메소드 등을 지정할 수 있다.
     * 또한 지정하는 메소드의 인수도 ".." 기호로 불특정 인수를 지정할 수 있다.
     * XX com.devkuma.spring.aop.SampleAopBean.XX(XX)
     * 맨 처음에있는 XX는 public이나 private 같은 것이 지정된 경우를 생각하여 붙여 있다.
     * 그리고 SampleAopBean의 후에 붙은 XX는 이 클래스 내에 있는 어떤 방법도 모두 대상으로 지정하는 것이다.
     * 또, (XX)는 인수가 어떤 형태여도 해당되도록 하기 위한 것
     */
    @After("execution(* com.devkuma.spring.aop.SampleAopBean.*(..))")
    public void after() {
        System.out.println("[Aspectj] after:");
    }
}