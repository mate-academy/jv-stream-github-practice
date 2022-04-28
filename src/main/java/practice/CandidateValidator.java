package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int INDEX_DATE_FROM = 1;
    private static final int INDEX_DATE_TO = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(split[INDEX_DATE_FROM]) - Integer.parseInt(split[INDEX_DATE_TO])
                >= REQUIRED_PERIOD;
    }
    //write your code here
}
