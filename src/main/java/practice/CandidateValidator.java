package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATINALITY = "Ukrainian";

    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
            && candidate.getNationality().equals(REQUIRED_NATINALITY)
            && (end - start) >= YEARS_IN_UKRAINE;
    }
}
