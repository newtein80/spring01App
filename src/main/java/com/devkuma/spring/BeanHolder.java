package com.devkuma.spring;

import com.devkuma.spring01demo.SampleBeanInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BeanHolder
 * 이전의 Bean 설정 클래스으로 작성한 Bean을 필드에 저장하고 그것을 이용한 메소드가 작성
 */
@Component
public class BeanHolder {

    // 이 클래스에는 SampleBeanInterface를 필드에 존재하고 있다.
    // 이 필드에는 @ Autowired 어노테이션이 붙여져 있다.
    // 이것은 Bean 설정 클래스 (또는 파일)에 의해 자동 생성된 Bean 인스턴스를 자동으로 바인딩하기 위한 것
    // 생성된 Bean들 중에서 SampleBeanInterface 인스턴스 찾고 이 bean 필드에 자동으로 할당하는 것
    @Autowired
    private SampleBeanInterface bean;

    public void showMessage() {
        System.out.println("*print by BeanHolder*");
        System.out.println(bean);
        System.out.println("*end*");
    }
}