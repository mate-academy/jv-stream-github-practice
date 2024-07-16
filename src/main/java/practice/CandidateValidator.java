package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return validateCandidateCanVote(candidate)
                && validateCandidateNationality(candidate)
                && validateCandidateAge(candidate)
                && validateCandidatePeriodInUkr(candidate);
    }

    private boolean validateCandidateNationality(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian");
    }

    private boolean validateCandidateCanVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    private boolean validateCandidateAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    private boolean validateCandidatePeriodInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[YEAR_FROM_INDEX]);
        int toYear = Integer.parseInt(years[YEAR_TO_INDEX]);
        return (toYear - fromYear) >= REQUIRED_YEARS_IN_UKR;
    }
}
