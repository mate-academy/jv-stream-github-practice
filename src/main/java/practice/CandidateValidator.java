package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String nationality = "Ukrainian";
        int minAge = 35;
        int minYearsInUkr = 10;
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return candidate.getAge() >= minAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && yearsInUkr >= minYearsInUkr;
    }
}
