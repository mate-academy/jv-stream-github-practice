package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == "Ukrainian"
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((year1, year2) -> year2 - year1).getAsInt();
    }
}
