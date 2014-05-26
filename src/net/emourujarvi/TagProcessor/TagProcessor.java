package net.emourujarvi.TagProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagProcessor {

    private List<TagReplaceStrategy> strategies;
    private String result;

    public TagProcessor(TagReplaceStrategy ... strategies) {
        this.strategies = new ArrayList<TagReplaceStrategy>(Arrays.asList(strategies));
    }

    public String process(String input) {
        result = input;
        for (TagReplaceStrategy strategy : strategies)
            result = strategy.replace(result);
        return result;
    }

    public String result() {
        return result;
    }

}
