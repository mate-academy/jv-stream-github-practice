package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String HYPHEN = "-";
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        int yearsInUkraine = Stream.of(candidate.getPeriodsInUkr())
                .map(period -> period.split(HYPHEN))
                .mapToInt(arr -> Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]))
                .sum();
        
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
