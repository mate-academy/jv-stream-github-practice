package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int LIVED_IN_COUNTRY = 10;
    private static final int SECOND_YEAR = 1;
    private static final int FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(year[SECOND_YEAR])
                - Integer.parseInt(year[FIRST_YEAR]) >= LIVED_IN_COUNTRY;
    }
}
