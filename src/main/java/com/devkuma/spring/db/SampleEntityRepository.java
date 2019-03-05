package com.devkuma.spring.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SampleEntityRepository
 * 엔티티 클래스 이름과 ID 필드 타입이 지정된다. 
 * 주의할 점은 "기본형의 경우, 래퍼 클래스를 지정한다는 점이다. 
 * 샘플 SampleEntity 클래스는 long 형을 ID를 지정하고 있기 때문에, 여기에서는 <SampleEntity, Long>라고 작성을 한다.
 */
@Repository
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long>{

    /**
     *
    Like / NotLike
        "퍼지 검색"에 관한 것이다. Like를 붙이면, 인수에 지정된 텍스트를 포함하는 엔티티를 검색한다.
        또한 NotLike을 쓰면 인수의 텍스트를 포함하지 않는 것을 검색한다.
        "findByNameLike"이라면, name에서 인수의 텍스트를 퍼지 검색한다.

    StartingWith / EndingWith
        텍스트 값에서 인수에 지정된 텍스트로 시작하거나 끝나는 것을 검색하기 위한 것이다.
        findByNameStartingWith("A")이라면, name의 값이 "A"로 시작하는 항목을 검색한다.

    IsNull / IsNotNull
        값이 null이 거나, 혹은 null이 아닌 것을 검색한다.
        인수는 필요없다. "findByNameIsNull()"이라면, name의 값이 null의 것만 검색한다.

    True / False
        부울 값으로 true 인 것, 혹은 false 인 것을 검색한다.
        인수는 필요없다. "findByCheckTrue()"이라면, check라는 항목이 true 인 것만을 검색한다.

    Before / After
        시간 값으로 사용한다. 인수에 지정한 값보다 이전의 것, 혹은 이후 것을 검색한다.
        "findByCreateBefore(new Date())"라고 하면, create라는 항목의 값이 현재보다 이전의 것만을 찾는다 (create가 Date 인 경우).

    LessThan / GreaterThan
        숫자 값으로 사용한다. 그 항목의 값이 인수보다 작거나 큰 것을 검색한다.
        "findByAgeLessThan(20)"이라면, age의 값이 20보다 작은 것을 찾는다.

    Between
        두 값을 인수로 가지고 그 두 값 사이의 것을 검색한다.
        예를 들어, "findByAgeBetween(10, 20)"라고 한다면 age 값이 10 이상 20 이하인 것을 검색한다.
        수치뿐만 아니라 시간의 항목 등에도 사용할 수 있다.
     */
    public List<SampleEntity> findByNameLike(String name);
    public List<SampleEntity> findByMailEndingWith(String mail);
}