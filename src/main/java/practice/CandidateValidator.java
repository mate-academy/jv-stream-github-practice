package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriod = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(splitedPeriod[END_YEAR_INDEX])
                - Integer.parseInt(splitedPeriod[START_YEAR_INDEX]) >= MIN_PERIOD;
    }
}
