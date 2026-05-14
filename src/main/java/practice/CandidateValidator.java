package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int MIN_LIVE_PERIOD = 10;

    private int getYearsInUkraine(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        int years = Math.abs(
                Integer.parseInt(period.split("-")[0])
                        - Integer.parseInt(period.split("-")[1])
        );
        return years;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getYearsInUkraine(candidate) >= MIN_LIVE_PERIOD;
    }
}

