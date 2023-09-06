package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    static int maxAge = 35;

    public int getMaxAge() {
        return maxAge;
    }

    static int yearsInUkraine = 10;

    public int getYearsInUkraine() {
        return yearsInUkraine;
    }

    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int years = yearsInUkraine[1] - yearsInUkraine[0];
        return candidate.getAge() >= getMaxAge()
                && candidate.getNationality().equals("Ukrainian")
                && years >= getYearsInUkraine()
                && candidate.isAllowedToVote();
    }
}
