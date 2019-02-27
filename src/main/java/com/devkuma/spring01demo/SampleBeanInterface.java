package com.devkuma.spring01demo;

/**
 * SampleBeanInterface : bean 의 내용을 정의
 * 단, Bean의 일반적인 사용법이 이미지될 수 있도록, 이번에는 인터페이스부터 만들어 두었다.
 */
public interface SampleBeanInterface {

    public String getMessage();
    public void setMessage(String message);
}