package ladder.domain.ladder;

import ladder.vo.LadderSize;
import ladder.vo.Length;
import org.junit.Test;

public class LadderGeneratorTest {
    @Test
    public void Ladder_객체_정상_생성() {
        // given
        Length width = new Length(3);
        Length height = new Length(3);

        // when
        // then
        LadderGenerator.generateLadder(new LadderSize(width, height));
    }

    @Test
    public void Line_객체_정상_생성() {
        LadderGenerator.makeLine(new Length(3));
    }
}
