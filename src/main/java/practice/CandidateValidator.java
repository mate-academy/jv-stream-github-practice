package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DIVIDE_STRING_YEARS = "-";
    private static final int COEFFICIENT_YEARS_FROM = 0;
    private static final int COEFFICIENT_YEARS_TO = 1;
    private static final int MINIMUM_YEARS_IN_THE_COUNTRY = 10;
    private static final int MINIMUM_VOTING_AGE = 35;
    private static final String CITIZEN_OF_UKRAINE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MINIMUM_VOTING_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CITIZEN_OF_UKRAINE))
                && validCandidateAgeInCountry(candidate);
    }

    public boolean validCandidateAgeInCountry(Candidate candidate) {
        String[] arrayPeriodsInUkr = candidate.getPeriodsInUkr().split(DIVIDE_STRING_YEARS);
        int periodsInUkrFrom = Integer.parseInt(arrayPeriodsInUkr[COEFFICIENT_YEARS_FROM]);
        int periodsInUkrTo = Integer.parseInt(arrayPeriodsInUkr[COEFFICIENT_YEARS_TO]);
        return (periodsInUkrTo - periodsInUkrFrom) >= MINIMUM_YEARS_IN_THE_COUNTRY;
    }
}
