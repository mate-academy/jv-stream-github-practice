package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int INDEX_DATE_FROM = 0;
    private static final int INDEX_DATE_TO = 1;
    private static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] date = candidate.getPeriodsInUkr().split(SPLIT);
        int timeInUkraine = Integer.parseInt(date[INDEX_DATE_TO])
                - Integer.parseInt(date[INDEX_DATE_FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN.equals(candidate.getNationality())
                && timeInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
