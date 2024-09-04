package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int TEN_YEARS = 10;
    private static final int OLDER_THAN_35_TEARS = 35;

    @Override
    public boolean test(Candidate candidate) {
        boolean olderThenThirtyFiveYears = candidate.getAge() >= OLDER_THAN_35_TEARS;
        boolean livedInUkraineForTenYears = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((FROM_YEAR, TO_YEAR) -> TO_YEAR - FROM_YEAR)
                .orElse(0) >= TEN_YEARS;
        boolean allowedToVote = candidate.isAllowedToVote();
        boolean ukrainianNationality = candidate.getNationality().equals(UKRAINIAN_NATIONALITY);
        return olderThenThirtyFiveYears && livedInUkraineForTenYears && allowedToVote
                && ukrainianNationality;
    }
}
