package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == REQUIRED_NATIONALITY
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((yearFrom, yearTo) -> yearTo - yearFrom).getAsInt();
    }
}
