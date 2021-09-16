package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS = 10;
    private static final int START = 1;
    private static final int END = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(years[START]) - Integer.parseInt(years[END]) >= YEARS;
    }
}
