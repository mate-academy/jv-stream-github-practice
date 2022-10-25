package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getLifePeriod(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getLifePeriod(String years) {
        return Arrays.stream(years.split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((x,y) -> y - x).getAsInt();
    }
}
