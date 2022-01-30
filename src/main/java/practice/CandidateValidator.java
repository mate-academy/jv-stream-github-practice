package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MinAge = 35;
    private static final int MinLivingAge = 10;
    private static final String Nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int[] ints = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int livingAge = ints[1] - ints[0];
        return candidate.getAge() >= MinAge && candidate.isAllowedToVote()
                && candidate.getNationality().equals(Nationality)
                && livingAge >= MinLivingAge;
    }
}
