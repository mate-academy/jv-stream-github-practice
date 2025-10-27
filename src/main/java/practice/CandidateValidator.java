package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_EXPERIENCE = 10;
    private static final String COUNTRY_CANDIDATE_NAME = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && COUNTRY_CANDIDATE_NAME.equalsIgnoreCase(candidate.getNationality())
                && hasEnoughExperience(candidate.getPeriodsInUkr());
    }

    private boolean hasEnoughExperience(String periodsInUkr) {
        if (periodsInUkr == null || !periodsInUkr.contains("-")) {
            return false;
        }
        String[] years = periodsInUkr.split("-");
        try {
            int from = Integer.parseInt(years[0].trim());
            int to = Integer.parseInt(years[1].trim());
            return (to - from) >= MIN_EXPERIENCE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
