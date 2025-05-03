package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE_FOR_ELECTION = 35;
    private static final int PERIOD_IN_COUNTRY = 10;
    private static final String DELIMITER_DASH = "-";

    private static final int INDEX_LAST_YEAR = 1;
    private static final int INDEX_FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_ELECTION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodOfStay(candidate.getPeriodsInUkr()) >= PERIOD_IN_COUNTRY;
    }

    private int periodOfStay(String periodsInUkr) {
        if (periodsInUkr == null) {
            return 0;
        }
        String[] years = periodsInUkr.split(DELIMITER_DASH);
        return Integer.parseInt(years[INDEX_LAST_YEAR]) - Integer.parseInt(years[INDEX_FIRST_YEAR]);
    }

}
