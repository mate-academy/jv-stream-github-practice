package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR_START_POS = 0;
    private static final int FIRST_YEAR_END_POS = 4;
    private static final int END_YEAR_START_POS = 5;
    private static final int END_YEAR_END_POS = 9;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int livedInUkraine(String periodsInUrk) {
        return Integer.parseInt(periodsInUrk
                .substring(END_YEAR_START_POS, END_YEAR_END_POS))
                - Integer.parseInt(periodsInUrk
                .substring(FIRST_YEAR_START_POS, FIRST_YEAR_END_POS));
    }
}
