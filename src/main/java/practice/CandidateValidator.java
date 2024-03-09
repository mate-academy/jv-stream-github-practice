package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int minAge = 35;
    private static final int minYearsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        String nationality = "Ukrainian";
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return candidate.getAge() >= minAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && yearsInUkr >= minYearsInUkr;
    }
}
