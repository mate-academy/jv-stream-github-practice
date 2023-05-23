package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERSON_FROM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_LIVING = 10;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int years = periodInUkr(candidate.getPeriodsInUkr());
        return candidate.getAge() >= PERSON_FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= PERIOD_OF_LIVING;
    }

    private int periodInUkr(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[END_INDEX]) - Integer.parseInt(years[START_INDEX]);
    }
}
