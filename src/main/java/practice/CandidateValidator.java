package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        int livedYear = Integer.parseInt(year[1])
                - Integer.parseInt(year[0]);

        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && livedYear >= MIN_YEARS_IN_UKRAINE;
    }
}
