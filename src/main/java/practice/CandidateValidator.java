package practice;

import model.Candidate;
import java.util.Objects;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
  private static final String NATIONALITY = "Ukrainian";
  private static final int MIN_AGE = 35;
  private static final int MIN_PERIOD_IN_UKRAINE = 10;
  private static final int STARTED_PERIOD = 0;
  private static final int FINISHED_PERIOD = 1;

  @Override
  public boolean test(Candidate candidate) {
    String[] yearsFromTo = candidate.getPeriodsInUkr().split("-");
    int yearsInCountry = Integer.parseInt(yearsFromTo[FINISHED_PERIOD]) -
            Integer.parseInt(yearsFromTo[STARTED_PERIOD]);

    return candidate.isAllowedToVote()
            && Objects.equals(NATIONALITY, candidate.getNationality())
            && candidate.getAge() >= MIN_AGE
            && yearsInCountry >= MIN_PERIOD_IN_UKRAINE;
  }
}
