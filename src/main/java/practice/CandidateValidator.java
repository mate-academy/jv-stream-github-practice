package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_OF_STAY = 10;
    private static final String NECESSARY_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean mostRequirements = candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NECESSARY_NATIONALITY);
        if (!mostRequirements) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);
        return toYear - fromYear >= MIN_PERIOD_OF_STAY;
    }
}
