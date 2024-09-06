package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int TEN_YEARS = 10;
    private static final int OLDER_THAN_35_YEARS = 35;
    private static final String DELIMITER_HYPHEN = "-";

    @Override
    public boolean test(Candidate candidate) {
        boolean olderThenThirtyFiveYears = candidate.getAge() >= OLDER_THAN_35_YEARS;
        boolean livedInUkraineForTenYears = Arrays.stream(candidate.getPeriodsInUkr()
                .split(DELIMITER_HYPHEN))
                .mapToInt(Integer::parseInt)
                .reduce((fromYear, toYear) -> toYear - fromYear)
                .orElse(0) >= TEN_YEARS;
        boolean allowedToVote = candidate.isAllowedToVote();
        boolean ukrainianNationality = candidate.getNationality().equals(UKRAINIAN_NATIONALITY);
        return olderThenThirtyFiveYears && livedInUkraineForTenYears && allowedToVote
                && ukrainianNationality;
    }
}
