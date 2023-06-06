package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int validAge = 35;
    private static final int requirementYears = 10;
    private static final String validNationality = "Ukrainian";

    private boolean wasLivingTenYearsInCountry(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= requirementYears;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= validAge && candidate.isAllowedToVote()
                && candidate.getNationality().equals(validNationality)
                && wasLivingTenYearsInCountry(candidate.getPeriodsInUkr());
    }
}
