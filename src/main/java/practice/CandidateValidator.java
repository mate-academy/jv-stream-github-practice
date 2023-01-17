package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_AGES_LIVE_IN_UKRAINE = 10;
    private static final int FIRST_PART_OF_STRING_PERIODS_IN_UKRAINE = 0;
    private static final int SECOND_PART_OF_STRING_PERIODS_IN_UKRAINE = 1;
    private static final String SYMBOL_FOR_SPLIT_PERIODS_IN_UKRAINE = "-";
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(UKRAINIAN)
                && getAgesInUkraine(candidate) >= MIN_AGES_LIVE_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getAgesInUkraine(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split(SYMBOL_FOR_SPLIT_PERIODS_IN_UKRAINE);
        return Integer.parseInt(ages[SECOND_PART_OF_STRING_PERIODS_IN_UKRAINE])
                - Integer.parseInt(ages[FIRST_PART_OF_STRING_PERIODS_IN_UKRAINE]);
    }
}
