package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_LIVING_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getLivingYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_LIVING_PERIOD;
    }

    private static int getLivingYearsInUkraine(String period) {
        String[] livingYears = period.split("-");
        return Integer.parseInt(Arrays.stream(livingYears)
                .reduce((year1, year2) -> String.valueOf(Integer.parseInt(year2)
                        - Integer.parseInt(year1)))
                .get());
    }
}
