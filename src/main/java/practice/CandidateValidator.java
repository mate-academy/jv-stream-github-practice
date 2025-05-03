package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String DATE_SPLITTER = "-";
    private static final int MIN_REQUIRED_AGE = 35;
    private static final int MIN_PERIOD_IN_UA = 10;
    private static final int YEAR_START_INDEX = 0;
    private static final int YEAR_END_INDEX = 1;

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(DATE_SPLITTER);
        int periodLength = Integer.parseInt(periodInUkr[YEAR_END_INDEX])
                - Integer.parseInt(periodInUkr[YEAR_START_INDEX]);
        return periodLength >= MIN_PERIOD_IN_UA
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }
}
