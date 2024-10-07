package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENCY = 35;
    private static final int MIN_YEARS_LIVED_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        Predicate<Candidate> agePredicate = c -> c.getAge() >= MIN_AGE_FOR_PRESIDENCY;
        Predicate<Candidate> allowedToVotePredicate = Candidate::isAllowedToVote;
        Predicate<Candidate> nationalityPredicate = c -> REQUIRED_NATIONALITY.equals(c.getNationality());
        Predicate<Candidate> livedInUkrainePredicate = c -> hasLivedInUkraineForTenYears(c.getPeriodsInUkr());

        return agePredicate
                .and(allowedToVotePredicate)
                .and(nationalityPredicate)
                .and(livedInUkrainePredicate)
                .test(candidate);
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return (endYear - startYear) >= MIN_YEARS_LIVED_IN_UKRAINE;
    }
}
