package com.devkuma.spring.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * SampleEntity
 * 엔티티 클래스에서는 테이블에 포함되는 항목을 그대로 필드로 제공한다.
 * 즉, "테이블=클래스", "컬럼=필드 "라는 느낌으로 정의한다.
 */
@Entity // 이 클래스가 엔터티 클래스임을 나타낸다.
public class SampleEntity {

    @Id     // 기본 키를 나타 내기위한 것이며, 이것을 붙인 필드는 그 테이블의 기본 키 컬럼임을 나타낸다.
    @Column // 테이블의 칼럼을 나타내기 위한 것
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성에 관한 것이다. strategy=GenerationType.AUTO 값을 지정하면 값을 자동으로 설정
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = true)
    private String mail;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "SampleEntity [id=" + id + ", name=" + name + ", mail=" + mail + "]";
    }

    /**
     * shift + spacebar -> constructor
     */
    public SampleEntity() {
        super();
    }

    public SampleEntity(String name, String mail) {
        this();
        this.name = name;
        this.mail = mail;
    }
}