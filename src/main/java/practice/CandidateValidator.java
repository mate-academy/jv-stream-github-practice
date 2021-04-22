package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int RESIDENCE_YEARS = 10;
    private static final String YEARS_SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkrSplit = candidate.getPeriodsInUkr()
                .split(YEARS_SPLIT_REGEX);
        int currentCandidateResidenceYears = Integer.parseInt(periodsInUkrSplit[1])
                - Integer.parseInt(periodsInUkrSplit[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && currentCandidateResidenceYears >= RESIDENCE_YEARS;
    }
}
