package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_WHICH_CANDIDATE_LIVES = 0;
    private static final int YEAR_IN_WHICH_CANDIDATE_LIVES = 1;
    private static final String YEARS_SEPARATOR = "-";
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_NUMBERS_OF_YEARS = 10;
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsSpentInCountry = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);

        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(yearsSpentInCountry[YEAR_IN_WHICH_CANDIDATE_LIVES])
                - Integer.parseInt(yearsSpentInCountry[YEAR_FROM_WHICH_CANDIDATE_LIVES])
                >= REQUIRED_NUMBERS_OF_YEARS;
    }
}
