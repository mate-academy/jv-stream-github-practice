package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int MIN_AGE = 35;
    private final static String NEEDED_NATIONALITY = "Ukrainian";
    private final static int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && timeSpentInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int timeSpentInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
