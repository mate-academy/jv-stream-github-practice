package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == REQUIRED_NATIONALITY
                && getPeriodsInUkr(candidate) >= REQUIRED_PERIOD_IN_COUNTRY;
    }

    private int getPeriodsInUkr(Candidate candidate) {
        String[] splitedData = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitedData[1]) - Integer.parseInt(splitedData[0]);
    }
}
