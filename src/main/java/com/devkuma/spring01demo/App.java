package com.devkuma.spring01demo;

import com.devkuma.spring.SampleBeanConfig;
//import com.devkuma.spring.BeanHolder;
//import com.devkuma.spring.SampleBeanConfig;
import com.devkuma.spring.aop.SampleAopBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        /**
        // Bean 설정 파일에서 ApplicationContext를 생성한다. ApplicationContext : 어플리케이션의 Context를 관리
        // ClassPathXmlApplicationContext의 서브 클래스에서 XML 파일을 처리하는 기능
        // ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        // Bean 설정 클래스를 이용하여 ApplicationConfig을 생성하기 위한 것
        ApplicationContext app = new AnnotationConfigApplicationContext(SampleBeanConfig.class);
        // Context Bean 관리 ApplicationContext 에서 bean1 의 이름을 가진 bean을 꺼냄 (인스턴스와 같이 동일하게 사용가능)
        // Bean 으로 가져온 bean1 은 SampleBeanInterface 를 구현한 클래스이므로 변환
        // SampleBeanInterface bean1 = (SampleBeanInterface) app.getBean("bean1");
        // SampleBeanInterface bean1 = (SampleBeanInterface) app.getBean(SampleBeanInterface.class);
        BeanHolder holder = app.getBean(BeanHolder.class);
        // System.out.println( "Hello World!" );
        // System.out.println(bean1);
        holder.showMessage();

        // Resource leak: 'app' is never closed
        ((AnnotationConfigApplicationContext) app).close();
         */

        /**
         * 여기에서는 AnnotationConfigApplicationContext 인스턴스를 생성 한 후, getBean에서 "BeanHolder.class"를 인수로 지정해서 BeanHolder 인스턴스를 얻었다.
         * BeanHolder는 Bean 설정 클래스 (SampleBeanConfig)에 기술되어 있지 않았다. 하지만 제대로 getBean에서 꺼낼 수 있다.
         * 이것은 Bean 설정 파일 @ComponentScan로 부터 @Component로 지정된 클래스가 검색되어 그 인스턴스가 ApplicationContext에 등록되어 있기 때문이다.
         * 또한 그 내부에서는 @Autowired로 인해 SampleBean이 자동으로 필드에 설정되어 있었으므로, 그 값이 showMessage에서 출력되어 있었다는 것이다.
         */

        // AOP 사용부분
        // ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SampleBeanConfig.class);
        
        SampleAopBean bean1 = (SampleAopBean) app.getBean("sampleAopBean");
        bean1.printMessage();
        
        System.out.println("--------------------");
        
        // Bean은 target 속성에 지정된 Bean으로 얻어 올 수 있는 것이 가능
        // 두 번째 SampleAopBean는 printMessage의 실행 전후에 SampleMethodAdvice 클래스에 제공되는 before / afterReturning의 실행 결과가 삽입되어 있는 것을 알 수 있다.
        // 메소드의 실행 전후에 자동으로 다른 처리가 추가되어 있는 것이다.
        SampleAopBean bean2 = (SampleAopBean) app.getBean("proxyFactoryBean");
        bean2.printMessage();

        ((AnnotationConfigApplicationContext) app).close();
    }
}
