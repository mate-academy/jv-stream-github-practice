package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int NEEDED_YEARS_IN_UKRAINE = 10;
    public static final int NEEDED_AGE = 35;
    public static final String NEEDED_NATIONALITY = "Ukrainian";

    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return yearsInUkraine >= NEEDED_YEARS_IN_UKRAINE
                && candidate.getAge() >= NEEDED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY);
    }
}
