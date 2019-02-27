package com.devkuma.spring01demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 인터페이스를 정의하고 구현 클래스를 여러 준비해두면 간단히 속성 값을 설정할 뿐만 아니라, 그 속성의 처리 방법 등을 자유롭게 변경할 수 있게 되었다.
 * 사용하는 클래스 및 속성 값은 코드를 전혀 건드리지 않고 변경할 수 있다.
 * Bean 인스턴스를 설정 파일에서 자동으로 생성한다
 */
public class App 
{
    public static void main( String[] args )
    {
        // Bean 설정 파일에서 ApplicationContext를 생성한다. ApplicationContext : 어플리케이션의 Context를 관리
        // ClassPathXmlApplicationContext의 서브 클래스에서 XML 파일을 처리하는 기능
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        // Context Bean 관리 ApplicationContext 에서 bean1 의 이름을 가진 bean을 꺼냄 (인스턴스와 같이 동일하게 사용가능)
        // Bean 으로 가져온 bean1 은 SampleBeanInterface 를 구현한 클래스이므로 변환
        SampleBeanInterface bean1 = (SampleBeanInterface) app.getBean("bean1");
        // System.out.println( "Hello World!" );
        System.out.println(bean1);
    }
}
