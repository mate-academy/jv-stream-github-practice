package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMUM_ELIGIBLE_AGE = 35;
    private static final int REQUIRED_PRESENCE_TIMESPAN = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_ELIGIBLE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int start = Integer.parseInt(years[START_YEAR_INDEX]);
        int end = Integer.parseInt(years[END_YEAR_INDEX]);
        return (end - start) >= REQUIRED_PRESENCE_TIMESPAN;
    }
}
