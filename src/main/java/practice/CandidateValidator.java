package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE_OF_CANDIATE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_YEAR_LIVING = 10;
    private static final int FINISH_LIVING_DATE_INDEX = 1;
    private static final int START_LIVING_DATE_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= VALID_AGE_OF_CANDIATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && Integer.parseInt(years[FINISH_LIVING_DATE_INDEX])
                - Integer.parseInt(years[START_LIVING_DATE_INDEX]) >= MIN_YEAR_LIVING;
    }
}
