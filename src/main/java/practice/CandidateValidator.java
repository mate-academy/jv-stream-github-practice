package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLived = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        int livedInCountry = Integer.parseInt(yearsLived[1]) - Integer.parseInt(yearsLived[0]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && livedInCountry >= REQUIRED_YEARS_PERIOD;
    }
}
