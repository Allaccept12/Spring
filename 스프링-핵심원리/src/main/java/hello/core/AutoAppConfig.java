package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(////컴퍼넌트 어노테이션이 붙은 곳에서 ComponentScan붙어있으면 빈으로 다 등록시켜주는 스캐너
        //제외시키는 필터 / 타입은 어노테이션, Configuration붙은 어노테이션 클래스는 다 제외 -> 예제코드 살기기 위해서
         excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
