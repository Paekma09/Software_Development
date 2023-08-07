package main.chapter_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {
    private final List<ConditionalAction> conditionalActionList;

    public Inspector(final ConditionalAction... conditionalActions) {
        this.conditionalActionList = Arrays.asList(conditionalActions);
    }

    public List<Diagnosis> inspect(final Facts facts) {
        final List<Diagnosis> diagnosisList = new ArrayList<>();
        for (ConditionalAction conditionalAction : conditionalActionList) {
            final boolean conditionResult = conditionalAction.evaluate(facts);
            diagnosisList.add(new Diagnosis(facts, conditionalAction, conditionResult));
        }
        return diagnosisList;
    }
}
