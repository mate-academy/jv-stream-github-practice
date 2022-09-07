package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SIGN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == REQUIRED_NATIONALITY
                && getPeriodsInUkr(candidate) >= REQUIRED_PERIOD_IN_COUNTRY;
    }

    private int getPeriodsInUkr(Candidate candidate) {
        String[] splitedData = candidate.getPeriodsInUkr().split(SPLIT_SIGN);
        return Integer.parseInt(splitedData[splitedData.length - 1])
                - Integer.parseInt(splitedData[0]);
    }
}
