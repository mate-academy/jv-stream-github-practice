package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;
import model.Person;

import javax.print.attribute.standard.MediaSize;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS = 10;
    private static final int MIN_AGE = 35;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT = "-";


    @Override
    public boolean test(Candidate candidate) {
        int[] period = Arrays.stream(candidate.getPeriodsInUkr().split(SPLIT))
                .mapToInt(Integer::parseInt)
                .toArray();
        int isMoreThenTen = period[TO_YEAR] - period[FROM_YEAR];
        return isMoreThenTen >= MIN_YEARS
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                &&candidate.getNationality().equals(NATIONALITY);
    }
}
