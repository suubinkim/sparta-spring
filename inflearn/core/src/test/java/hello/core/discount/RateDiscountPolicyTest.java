package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    //정말 10% 할인이 되는지 테스트

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인 적용 되어야 함")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip아니면 할인 적용X")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberBISIC", Grade.BISIC);

        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}