package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    public static final int MINIMUM_YEARS_TO_LIVE_FOR_ELECTIONS = 10;
    public static final int MIN_AGE_FOR_PRESIDENT = 35;

    @Override
    public boolean test(Candidate candidate) {
        int yearsInCountry = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt).reduce((year1, year2) -> year2 - year1).orElse(0);
        return yearsInCountry >= MINIMUM_YEARS_TO_LIVE_FOR_ELECTIONS
            && candidate.isAllowedToVote()
            && candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
            && NATIONALITY_UKRAINIAN.equals(candidate.getNationality());
    }
}
