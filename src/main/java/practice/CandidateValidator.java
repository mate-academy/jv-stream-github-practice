package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String HYPHEN_DELIMITER = "-";
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_INUKR = 10;
    private static final int INITIAL_YEAR_POSITION = 0;
    private static final int FINAL_YEAR_POSITION = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split(HYPHEN_DELIMITER);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Integer.parseInt(yearsInUkr[FINAL_YEAR_POSITION])
                - Integer.parseInt(yearsInUkr[INITIAL_YEAR_POSITION])
                >= REQUIRED_YEARS_INUKR;
    }
}
