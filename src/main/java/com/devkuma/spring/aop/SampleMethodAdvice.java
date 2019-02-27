package com.devkuma.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * SampleMethodAdvice
 * MethodBeforeAdvice: 메소드가 실행하기 전에 처리를 삽입하기 위한 인터페이스
 * AfterReturningAdvice: 메소드의 실행이 끝나고, 호출을 하고 원래대로 돌아오게 될 때 삽입하는 처리의 인터페이스
 */
public class SampleMethodAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * 메소드의 실행이 끝나고, 호출을 하고 원래대로 돌아오게 될 때 삽입하는 처리의 인터페이스
     * public void afterReturning (Object returnValue, Method method, Object [] args, Object target) throws Throwable
     * 메소드의 반환 값, 메소드, 메소드에 전달된 인수, 대상 인스턴스가 인수로 전달된다. 반환 값 이외는 위 before와 동일하므로 거의 같은 감각으로 처리하는 것이 가능하다.
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("* after:" + method.getName() + "[" + target + "]");
    }

    /**
     * 메소드가 실행하기 전에 처리를 삽입하기 위한 인터페이스
     * public void before (Method method, Object [] args, Object target) throws Throwable
     * Method는 대상 메소드, args는 그에 대한 인수, target은 대상이 되는 객체(인스턴스)가 각각 전달된다.
     * 이러한 인수들은 어떤 인스턴스의 어떤 메서드를 호출하기 전에 이 처리를 수행했는지를 알 수 있다.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("* before:" + method.getName() + "[" + target + "]");
    }
}