package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_YEAR_LIVING_IN_UKRAINE = 10;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && getYearsLivingInUkraine(candidate) >= MIN_YEAR_LIVING_IN_UKRAINE;
    }

    public int getYearsLivingInUkraine(Candidate candidate) {
        List<Integer> years = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return years.get(SECOND_INDEX) - years.get(FIRST_INDEX);
    }
}
