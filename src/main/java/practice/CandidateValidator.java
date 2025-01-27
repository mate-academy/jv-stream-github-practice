package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
        public static final int MIN_AGE = 35;
        public static final int MINIMUM_YEARS_IN_UKR = 10;
        public static final String REQUIRED_NATIONALITY = "Ukrainian";

        @Override
        public boolean test(Candidate candidate) {
            List<Integer> yearsIssuing = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .map(Integer::parseInt)
                    .toList();
            return candidate.getAge() >= MIN_AGE
                    && candidate.isAllowedToVote()
                    && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                    && yearsIssuing.get(1) - yearsIssuing.get(0) >= MINIMUM_YEARS_IN_UKR;
        }
}
