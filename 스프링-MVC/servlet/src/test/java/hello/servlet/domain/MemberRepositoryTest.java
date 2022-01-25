package hello.servlet.domain;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //g
        Member member = new Member("hello", 20);
        //w
        Member savedMember = memberRepository.save(member);
        //t
        Member findMember = memberRepository.findById(savedMember.getId());

        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //g
        Member member1 = new Member("member1", 24);
        Member member2 = new Member("member2", 22);
        Member member3 = new Member("member3", 21);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        //w
        List<Member> members = memberRepository.findAll();
        //t
        assertThat(members.size()).isEqualTo(3);
        assertThat(members).contains(member1,member2,member3);

    }
}
