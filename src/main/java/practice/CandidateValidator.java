package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int LIVING_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(SPLITTER);
        int fromYear = Integer.parseInt(periodsInUkr[0]);
        int toYear = Integer.parseInt(periodsInUkr[periodsInUkr.length - 1]);
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (toYear - fromYear >= LIVING_YEARS);
    }
}
