package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        return validateAge(candidate.getAge())
                && candidate.isAllowedToVote()
                && validateNationality(candidate.getNationality())
                && validatePeriondsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean validateAge(int age) {
        return age >= 35;
    }

    private boolean validateNationality(String nationality) {
        return nationality.equals("Ukrainian");
    }

    private boolean validatePeriondsInUkr(String periodsInUkr) {
        Integer[] value = Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return Math.abs(value[0] - value[1]) >= 10;
    }
}
