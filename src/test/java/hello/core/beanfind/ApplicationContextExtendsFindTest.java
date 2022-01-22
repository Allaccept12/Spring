package hello.core.beanfind;

import hello.core.discount.DiscountPolycy;
import hello.core.discount.FixDiscountPolycy;
import hello.core.discount.RateDiscountPolycy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복오류")
    void findBeanByParentTypeDuplicate() {
        DiscountPolycy bean = ac.getBean(DiscountPolycy.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(DiscountPolycy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 빈 이름을 지정 하면 된다")
    void findBeanByParentTypeBeanName() {
        DiscountPolycy rateDiscountPolycy = ac.getBean("rateDiscountPolycy", DiscountPolycy.class);
        assertThat(rateDiscountPolycy).isInstanceOf(RateDiscountPolycy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountPolycy bean = ac.getBean(RateDiscountPolycy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolycy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanParentType() {
        Map<String, DiscountPolycy> beansOfType = ac.getBeansOfType(DiscountPolycy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "   " + beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolycy rateDiscountPolycy() {
            return new RateDiscountPolycy();
        }

        @Bean
        public DiscountPolycy fixDiscountPolycy() {
            return new FixDiscountPolycy();
        }
    }
}
