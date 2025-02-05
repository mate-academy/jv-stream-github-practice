package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static int MIN_AGE = 35;
    private static int MIN_AGES_IN_UKRAINE = 10;
    private static String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr()
                .split("-");
        int agesInUkr = Integer.valueOf(ages[1]) - Integer.valueOf(ages[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && agesInUkr >= MIN_AGES_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY);
    }
}
