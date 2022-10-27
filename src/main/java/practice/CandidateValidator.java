package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) > REQUIRED_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    public static void main(String[] args) {
        String period = "1990-2007";
        String[] periods = period.split("-");
        System.out.println(Integer.valueOf(periods[1]) - Integer.valueOf(periods[0]));
    }

    private int getPeriodInUkraine(String period) {
        String[] periods = period.split("-");
        return Integer.valueOf(periods[1]) - Integer.valueOf(periods[0]);
    }
}
