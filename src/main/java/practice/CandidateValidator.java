package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN = "Ukrainian";
    public static final int MIN_ELIGIBLE_AGE = 35;
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);

        return candidate.getNationality().equals(UKRAINIAN)
                && (endYear - startYear) >= MIN_YEARS_IN_UKRAINE
                && candidate.getAge() >= MIN_ELIGIBLE_AGE
                && candidate.isAllowedToVote();
    }
}
