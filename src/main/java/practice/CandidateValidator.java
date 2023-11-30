package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_LIFE_PERIOD = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String PERIOD_FIELD_SPLITTER = "-";
    private static final int YEAR_SINCE_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearSince = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_FIELD_SPLITTER)[YEAR_SINCE_INDEX]);
        int yearTo = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_FIELD_SPLITTER)[YEAR_TO_INDEX]);
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && (yearTo - yearSince) > MIN_VALID_LIFE_PERIOD && candidate.isAllowedToVote();
    }

}
