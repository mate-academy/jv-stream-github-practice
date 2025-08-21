package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY_FOR_VOTE = "Ukrainian";
    public static final String SEPARATOR_FOR_PERIODS_DATA = "-";
    public static final int MIN_COUNT_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR_FOR_PERIODS_DATA);
        int livedInUkraine = Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_VOTE)
                && livedInUkraine >= MIN_COUNT_YEARS_IN_UKRAINE;
    }
}
