package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    final private static String VALID_NATIONALITY = "Ukrainian";
    final private static int VALID_AGE = 35;
    final private static int MIN_YEARS_IN_UKRAINE = 10;
    final private static int DATE_FROM_INDEX = 0;
    final private static int DATE_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && (Integer.parseInt(yearsInUkr[DATE_TO_INDEX])
                - Integer.parseInt(yearsInUkr[DATE_FROM_INDEX])) >= MIN_YEARS_IN_UKRAINE;    }
}
