package main.chapter_05;

public class Rule {
    private Condition condition;
    private Action action;

    public Rule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    public void perform(Facts facts) {
        if (condition.evaluation(facts)) {
            action.execute(facts);
        }
    }
}
