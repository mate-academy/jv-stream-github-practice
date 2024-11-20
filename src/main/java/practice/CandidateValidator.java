package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final Integer MIN_AGE = 35;
    private static final Integer MIN_PERIOD = 10;
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH);
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);
        int period = toYear - fromYear;

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_PERIOD;
    }
}
