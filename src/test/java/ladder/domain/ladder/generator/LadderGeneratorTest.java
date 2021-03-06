package ladder.domain.ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGeneratorTest {
    private static final Logger log = LoggerFactory.getLogger(LadderGeneratorTest.class);

    @Test
    public void 사다리의_높이가_1_미만일_경우_IllegalArgumentException() {
        // given
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(directionGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        int height = 0;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> ladderGenerator.generateLadder(memberGroup, height));
    }

    @Test
    public void Ladder_객체_정상_생성() {
        // given
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(directionGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        int height = 3;

        // when
        Ladder ladder = ladderGenerator.generateLadder(memberGroup, height);

        // then
        assertThat(ladder.getWidth()).isEqualTo(memberGroup.getNumberOfMembers() - 1);
        assertThat(ladder.getHeight()).isEqualTo(height);

        log.debug("ladder\n", ladder);
    }
}
