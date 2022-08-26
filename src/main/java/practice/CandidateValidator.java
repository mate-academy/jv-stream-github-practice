package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";


    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriod(candidate.getPeriodsInUkr()) >= LIVING_PERIOD;
    }

    private int calculatePeriod(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
