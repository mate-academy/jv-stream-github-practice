package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int APPROVED_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);

        return candidate.getAge() >= APPROVED_AGE
            && candidate.isAllowedToVote()
            && NATIONALITY.equals(candidate.getNationality())
            && toYear - fromYear >= MIN_YEARS_IN_UKRAINE;
    }

}
