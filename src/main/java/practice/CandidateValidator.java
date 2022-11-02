package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final int INDEX_BEGIN = 0;
    private static final int INDEX_LAST = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(periods[INDEX_LAST])
                - Integer.parseInt(periods[INDEX_BEGIN]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine >= MIN_YEARS;
    }
}
