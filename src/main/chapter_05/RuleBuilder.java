package main.chapter_05;

public class RuleBuilder {
    private Condition condition;

    public RuleBuilder(Condition condition) {
        this.condition = condition;
    }

    public static RuleBuilder when(Condition condition) {
        return new RuleBuilder(condition);
    }

    public Rule then(Action action) {
        return new Rule(condition, action);
    }
}
