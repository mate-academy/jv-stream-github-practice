package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_TIME_IN_UKRAINE = 10;
    private static final char DASH_CHARACTER = '-';
    private static final String UKR_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int indexOfDash = candidate.getPeriodsInUkr()
                .indexOf(DASH_CHARACTER);
        int toInUkraineYear = Integer.parseInt(candidate
                        .getPeriodsInUkr()
                        .substring(indexOfDash + 1));
        int fromInUkraineYear = Integer.parseInt(candidate
                        .getPeriodsInUkr()
                        .substring(0, indexOfDash));
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality() != null
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && toInUkraineYear - fromInUkraineYear >= MIN_TIME_IN_UKRAINE;
    }
}
