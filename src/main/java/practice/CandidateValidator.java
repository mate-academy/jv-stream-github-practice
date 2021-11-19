package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_YEARS_IN_UKR = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        final int StayInUkraineYear = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((n1, n2) -> n2 - n1)
                .orElseThrow(() -> new NumberFormatException("Can't parse"));

        return (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && StayInUkraineYear >= MIN_YEARS_IN_UKR);
    }
}
