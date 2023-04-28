package hello.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("idA","memberA");
        repository.initTable();
        repository.save(member);

        Member findMember = repository.find(member.getMemberId());

        assertThat(member.getMemberId()).isEqualTo(findMember.getMemberId());
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

}