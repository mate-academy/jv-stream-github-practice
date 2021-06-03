package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String allowedNationality = "Ukrainian";
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(allowedNationality)
                && isCandidateLive10YearInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean isCandidateLive10YearInUkraine(String liveYears) {
        String datesSeparator = "-";
        int neededLengthOfStayInUkraine = 10;
        int[] dates = Arrays.stream(liveYears.split(datesSeparator))
                .mapToInt(Integer::parseInt)
                .toArray();

        return dates[1] - dates[0] >= neededLengthOfStayInUkraine;
    }
}
