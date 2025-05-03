package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCE_AGE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && NATIONALITY.equals(candidate.getNationality())
                && Integer.parseInt(periods[END_YEAR]) - Integer.parseInt(periods[START_YEAR])
                >= MIN_RESIDENCE_AGE;
    }
}
