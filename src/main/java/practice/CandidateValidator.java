package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator {

    Predicate<Candidate> candidatePredicate = new Predicate<Candidate>() {
        @Override
        public boolean test(Candidate candidate) {
            String[] period = candidate.getPeriodsInUkr().split("-");
            return candidate.getAge() >= 35
                    && candidate.isAllowedToVote()
                    && candidate.getNationality().equals("Ukrainian")
                    && Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= 10;
        }
    };
}
