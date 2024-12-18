package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_LIVING_YEARS = 10;
    private static final int PRESIDENT_ELIGIBILITY_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String COMMA = ",";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= PRESIDENT_ELIGIBILITY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(COMMA);
        int totalYearInUkraine = Arrays.stream(periods)
                .mapToInt(period -> {
                    String[] range = period.trim().split(DASH);
                    int startYear = Integer.parseInt(range[0]);
                    int endYear = Integer.parseInt(range[1]);
                    return endYear - startYear;
                })
                .sum();
        return totalYearInUkraine >= MINIMAL_LIVING_YEARS;
    }

}
