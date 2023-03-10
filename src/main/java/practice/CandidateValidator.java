package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && countYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int countYearsInUkraine(String years) {
        String[] splitYears = years.split("-");
        return Integer.parseInt(splitYears[1]) - Integer.parseInt(splitYears[0]);
    }
}

