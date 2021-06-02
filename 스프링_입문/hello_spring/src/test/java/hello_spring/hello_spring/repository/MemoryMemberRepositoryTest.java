package hello_spring.hello_spring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello_spring.hello_spring.domain.Member;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Optional<Member> result = repository.findById(member.getId());

    if (result.isPresent()) {
      assertEquals(result.get().getName(), member.getName());
      assertThat(result.get().getName()).isEqualTo(member.getName());
    }
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
    // assertThat(result).isEqualTo(member2);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> allMember = repository.findAll();
    assertThat(allMember.size()).isEqualTo(2);
  }
}
