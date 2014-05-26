package net.emourujarvi.TagProcessor.Test.TagReplaceStrategy;

import net.emourujarvi.TagProcessor.TagReplaceStrategy;

import java.util.Map;

public class SimpleStringTagReplaceStrategy implements TagReplaceStrategy {

    private Map<String, String> tagRules;

    public SimpleStringTagReplaceStrategy(Map<String, String> tagRules) {
        this.tagRules = tagRules;
    }

    @Override
    public String replace(String input) {
        for (Map.Entry<String, String> entry : tagRules.entrySet())
            input = input.replaceAll(entry.getKey(), entry.getValue());
        return input;
    }
}