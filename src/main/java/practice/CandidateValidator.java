package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_PERIOD = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");
        int yearsLived =
                Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && yearsLived >= MIN_PERIOD;
    }
}
