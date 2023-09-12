package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";
    private static final int END_DATE_INDEX = 1;
    private static final int START_DATE_INDEX = 0;

    @Override
    public boolean test(Candidate o) {
        Candidate candidate = o;
        String[] livingPeriod = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int periodInUkr = Integer.parseInt(livingPeriod[END_DATE_INDEX])
                - Integer.parseInt(livingPeriod[START_DATE_INDEX]);
        return (candidate.getAge() >= MIN_VALID_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && periodInUkr >= MIN_LIVING_PERIOD);
    }
}
