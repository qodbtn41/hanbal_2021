package hello_spring.hello_spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello_spring.hello_spring.domain.Member;
import hello_spring.hello_spring.repository.MemoryMemberRepository;

public class MemberServiceTest {
    MemberService memberService;

    @AfterEach
    public void afterEach() {
        MemoryMemberRepository memoryRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryRepository);
    }

    @Test
    public void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        /*
         * try { memberService.join(member2); fail(); } catch (Exception e) {
         * assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); }
         */
        // then

    }

    @Test
    public void findMembers() {

    }

    @Test
    public void findOne() {

    }
}
