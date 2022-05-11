package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final int INDEX_OF_FIRST_DATE_OF_PERIOD = 0;
    private static final int INDEX_OF_SECOND_DATE_OF_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");
        return (candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
               && candidate.getNationality().equals(REQUIRED_NATIONALITY)
               && (Integer.parseInt(years[INDEX_OF_SECOND_DATE_OF_PERIOD])
                - Integer.parseInt(years[INDEX_OF_FIRST_DATE_OF_PERIOD]))
               >= REQUIRED_PERIOD_IN_COUNTRY);
    }
}
