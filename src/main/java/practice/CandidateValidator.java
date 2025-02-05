package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_AGES_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int SINCE_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr()
                .split("-");
        int agesInUkr = Integer.parseInt(ages[SINCE_YEAR_INDEX])
                - Integer.parseInt(ages[FROM_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && agesInUkr >= MIN_AGES_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY);
    }
}
