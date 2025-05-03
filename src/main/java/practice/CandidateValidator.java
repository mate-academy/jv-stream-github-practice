package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    public boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        if (arr.length == 0) {
            throw new RuntimeException("The format of period living in Ukraine is invalid"
                    + "expected startYear-endYear, but you provide empty string");
        }
        if (arr.length == 1) {
            throw new RuntimeException("The format of period living in Ukraine is invalid"
                    + "expected startYear-endYear, but you provide only one year");
        }
        int periodLivingInUkraine = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);
        if (periodLivingInUkraine >= MIN_PERIOD) {
            return true;
        }
        return false;
    }
}
