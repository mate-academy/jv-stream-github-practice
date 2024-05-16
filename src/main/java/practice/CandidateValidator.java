package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMAL_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_RESIDENCY_YEARS = 10;
    private static final int FROM = 0;
    private static final int TO = 1;

    @Override
    public boolean test(Candidate candidate) {

        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livedInCountry = Integer.parseInt(splitPeriods[TO])
                - Integer.parseInt(splitPeriods[FROM]);
        boolean isHeLivedInCountryEnough = livedInCountry >= MINIMUM_RESIDENCY_YEARS;

        return candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isHeLivedInCountryEnough
                && candidate.isAllowedToVote();
    }
}
