package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVED_TEN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isHeHaveEnoughYears = candidate.getAge() >= MINIMAL_AGE;
        boolean isHeHaveCorrectNationality = candidate.getNationality()
                .equals(NATIONALITY);

        int from = 0;
        int to = 1;
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livedInCountry = Integer.parseInt(splitPeriods[to])
                - Integer.parseInt(splitPeriods[from]);
        boolean isHeLivedInCountryEnough = livedInCountry >= LIVED_TEN_YEARS;

        return isHeHaveEnoughYears && isHeHaveCorrectNationality
                && isHeLivedInCountryEnough && candidate.isAllowedToVote();
    }
}
