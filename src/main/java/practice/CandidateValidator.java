package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        int yearsInUkraine = Stream.of(candidate.getPeriodsInUkr())
                .map(period -> period.split("-"))
                .mapToInt(arr -> Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]))
                .sum();
        
        return yearsInUkraine >= 10;
    }
}
