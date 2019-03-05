package com.devkuma.spring01demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

// import com.devkuma.spring.SampleBeanConfig;
//import com.devkuma.spring.BeanHolder;
//import com.devkuma.spring.SampleBeanConfig;
import com.devkuma.spring.aop.SampleAopBean;
import com.devkuma.spring.aop.SampleAspectConfig;
import com.devkuma.spring.db.SampleEntity;
import com.devkuma.spring.db.SampleEntityConfig;
import com.devkuma.spring.db.SampleEntityRepository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 인터페이스를 정의하고 구현 클래스를 여러 준비해두면 간단히 속성 값을 설정할 뿐만 아니라, 그 속성의 처리 방법 등을 자유롭게 변경할 수 있게 되었다.
 * 사용하는 클래스 및 속성 값은 코드를 전혀 건드리지 않고 변경할 수 있다.
 * Bean 인스턴스를 설정 파일에서 자동으로 생성한다
 */
public class App 
{
    private static EntityManager manager;
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

        /**
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
        */

        // ApplicationContext app = new ClassPathXmlApplicationContext("aopbean.xml");
        // ApplicationContext app = new AnnotationConfigApplicationContext(SampleAspectConfig.class);

        // SampleAopBean bean = (SampleAopBean) app.getBean("sampleAopBean");
        
        // // 각 메소드를 호출 할 때마다 출력됨
        // String msg = bean.getMessage();
        // bean.setMessage("<<" + msg + ">>");
        // bean.printMessage();

        // // ((ClassPathXmlApplicationContext) app).close();
        // ((AnnotationConfigApplicationContext) app).close();

        // // ApplicationContext app = new ClassPathXmlApplicationContext("dbbean.xml");
        // ApplicationContext app = new AnnotationConfigApplicationContext(SampleEntityConfig.class);

        // // Bean 설정 파일에 준비해 놓은 엔티티 관리자 팩토리 Bean을 얻어 온다.
        // EntityManagerFactory factory = app.getBean(EntityManagerFactory.class);
        // // EntityManager manager = factory.createEntityManager();
        // manager = factory.createEntityManager();

        // makeDummyData(manager);

        // updateEntityData(1L);
        // deleteEntityData(2L);

        // /**
        //  * "Query"라는 클래스의 인스턴스를 만들고, 해당 메서드를 호출하여 전체 엔터티 목록을 검색한다. 
        //  * Query라는 것은 SQL 쿼리 문장의 단순화 된 버전과 같은 문장을 사용하여 데이터베이스에 액세스하기 위한 것
        //  * 인스턴스 생성은 new 대신 "createQuery"라는 메소드를 이용한다. 
        //  * 인수는 "from SampleEntity" 텍스트을 넣었다. 이것이 SampleEntity 엔티티를 모두 취득하는 것을 나타내는 구문
        //  */
        // // Query query = manager.createQuery("from SampleEntity");
        // // https://stackoverflow.com/questions/13700565/jpa-query-getresultlist-use-in-a-generic-way
        // TypedQuery<SampleEntity> query = manager.createQuery("from SampleEntity where name like '%Up%'", SampleEntity.class);
        // /**
        //  * "getResultList"을 호출하면, 가져온 엔티티를 목록으로 얻을 수 있다. 
        //  * 그 다음, l결과 목록(list)에서 부터 차례로 엔티티를 꺼내 처리하면 된다.
        //  */
        // // List list = query.getResultList();
        // List<SampleEntity> list = query.getResultList();
        // printList(list);

        // System.out.println("Ok....");
        
        // ApplicationContext app = new ClassPathXmlApplicationContext("dbbean.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SampleEntityConfig.class);

        EntityManagerFactory factory = app.getBean(EntityManagerFactory.class);
        manager = factory.createEntityManager();

        makeDummyDataUseRepository();

        SampleEntityRepository repository = app.getBean(SampleEntityRepository.class);

        List list1 = repository.findByNameLike("%y1");
        System.out.println("*Find By Name*");
        printList(list1);
        List list2 = repository.findByMailEndingWith(".com");
        System.out.println("*Find By Mail");
        printList(list2);

        // List list = repository.findAll();
        // printList(list);

        System.out.println("OK...!!");
    }

    private static void makeDummyDataUseRepository() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(new SampleEntity("repostory1", "repository1@mail.com"));
        manager.persist(new SampleEntity("repostory2", "repository2@mail.com"));
        manager.flush();
        transaction.commit();
    }

    private static void deleteEntityData(long id) {
        SampleEntity entity = manager.find(SampleEntity.class, id);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(entity);
        manager.flush();
        transaction.commit();
    }

    private static void updateEntityData(long id) {
        SampleEntity entity = manager.find(SampleEntity.class, id);
        entity.setName("**Update Name**");
        entity.setMail("**Update Mail**");
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(entity);
        manager.flush();
        transaction.commit();
    }

    private static void printList(List list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    private static void makeDummyData(EntityManager manager) {
        // 엔티티 클래스의 인스턴스를 만들고 EntityManager에 있는 저장용의 메소드를 호출하기만 하면 된다.
        /**
         * 데이터베이스 조작은 단순히 데이터를 읽기만 한다면 간단하지만 데이터를 갱신하는 경우에는 주의가 필요하다.
         * 데이터베이스는 동시에 여러 곳에서 액세스되는 경우도 있다.
         * 따라서 다른 데이터가 액세스되는 동안에 데이터가 갱신이 되거나 한다면 문제가 일어날 수 있다.
         * 따라서 데이터의 갱신이 필요한 경우에는 "트랜잭션"이라는 것을 사용해야 한다.
         * 트랜잭션은 여러 처리를모와서 실행 할 수 있도록하는 기능이다.
         * 트랜잭션을 지정하는 동안에는 그 처리를 실시하고 있는 해당 데이터에 대해서, 외부에서 액세스를 할 수 없게 된다.
         * 트랜잭션 처리가 완료된 후에는 외부에서 부터 데이터 액세스 가능해 진다.
         */
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(new SampleEntity("park", "park@mail.com"));
        manager.persist(new SampleEntity("kim", "kim@mail.com"));
        /**
         * EntityManager의 'flush'을 호출해서 버퍼를 비우고,
         * EntityTransaction의 "commit"메서드를 호출하여 커밋하면
         * persist한 엔티티가 전부 데이터베이스에 저장된다.
         * 커밋을 하면 바로 트랜잭션 처리는 종료되고, 데이터베이스는 개방된다.
         */
        manager.flush();
        
        transaction.commit();
    }
}
