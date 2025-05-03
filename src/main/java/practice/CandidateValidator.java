package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int CANDIDATE_AGE = 35;
    private static final int PERIOD_IF_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isLivingTenYears(candidate.getPeriodsInUkr());
    }

    private boolean isLivingTenYears(String livingYears) {
        String[] splitLivingYears = livingYears.split(REGEX);
        return (Integer.parseInt(splitLivingYears[1])
                - Integer.parseInt(splitLivingYears[0])) >= PERIOD_IF_YEARS;
    }
}
