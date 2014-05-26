package net.emourujarvi.TagProcessor.Test.TagReplaceStrategy;

import net.emourujarvi.TagProcessor.TagReplaceStrategy;
import net.emourujarvi.TagProcessor.Test.Entity.SimpleNPC;

import java.util.Map;

public class SimpleNPCTagReplaceStrategy implements TagReplaceStrategy {

    private SimpleNPC simpleNPC;
    private Map<String, SimpleNPC.Field> simpleClassRules;

    public SimpleNPCTagReplaceStrategy(SimpleNPC simpleNPC, Map<String, SimpleNPC.Field> simpleClassRules) {
        setSimpleNPC(simpleNPC);
        setSimpleClassRules(simpleClassRules);
    }

    public SimpleNPC getSimpleNPC() {
        return simpleNPC;
    }

    public void setSimpleNPC(SimpleNPC simpleNPC) {
        this.simpleNPC = simpleNPC;
    }

    public Map<String, SimpleNPC.Field> getSimpleClassRules() {
        return simpleClassRules;
    }

    public void setSimpleClassRules(Map<String, SimpleNPC.Field> simpleClassRules) {
        this.simpleClassRules = simpleClassRules;
    }

    @Override
    public String replace(String input) {
        for (Map.Entry<String, SimpleNPC.Field> entry : simpleClassRules.entrySet())
            input = input.replaceAll(entry.getKey(), simpleNPC.getFieldValue(entry.getValue()));
        return input;
    }
}
