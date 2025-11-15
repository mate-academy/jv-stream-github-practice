package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return validateAge(candidate) && validateNationality(candidate)
                && validateVote(candidate) && validatePeriod(candidate);
    }

    public boolean validateAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    public boolean validateNationality(Candidate candidate) {
        return candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }

    public boolean validateVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    public boolean validatePeriod(Candidate candidate) {
        int index = candidate.getPeriodsInUkr().indexOf("-");
        int start = Integer.parseInt(candidate.getPeriodsInUkr().substring(0, index));
        int end = Integer.parseInt(candidate.getPeriodsInUkr().substring(index + 1));
        return end - start >= MIN_YEARS_IN_UKRAINE;
    }
}
