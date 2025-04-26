package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        boolean moreThanTenYears = false;
        int[] yearsArray = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
        if (yearsArray[1] - yearsArray[0] >= 10) {
            moreThanTenYears = true;
        }
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && moreThanTenYears) {
            return true;
        }

        return false;
    }
    //write your code here
}
