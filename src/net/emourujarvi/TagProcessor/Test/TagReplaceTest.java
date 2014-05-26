package net.emourujarvi.TagProcessor.Test;

import net.emourujarvi.TagProcessor.TagProcessor;
import net.emourujarvi.TagProcessor.Test.Entity.*;
import net.emourujarvi.TagProcessor.Test.TagReplaceStrategy.*;

import java.util.Map;
import java.util.TreeMap;

public class TagReplaceTest {

    public static void main(String args[]) {

        String originalText = "Replace the following #tag with #creator. This is for #2nd_replace_strategy. #sender_name sends his regards to #receiver_name.";
        String processedText = originalText;


        Map<String, String> simpleTagRules1 = new TreeMap<String, String>();
        simpleTagRules1.put("#tag", "tag");
        simpleTagRules1.put("#creator", "esa-matti");

        Map<String, String> simpleTagRules2 = new TreeMap<String, String>();
        simpleTagRules2.put("#2nd_replace_strategy", "2nd replace strategy");


        SimpleNPC simpleNPC1 = new SimpleNPC("Fire Rabbit", 28);
        SimpleNPC simpleNPC2 = new SimpleNPC("Human Overlord", 31);

        Map<String, SimpleNPC.Field> simpleClassTagRules1 = new TreeMap<String, SimpleNPC.Field>();
        simpleClassTagRules1.put("#sender_name", SimpleNPC.Field.NAME);
        simpleClassTagRules1.put("#sender_age", SimpleNPC.Field.AGE);

        Map<String, SimpleNPC.Field> simpleClassTagRules2 = new TreeMap<String, SimpleNPC.Field>();
        simpleClassTagRules2.put("#receiver_name", SimpleNPC.Field.NAME);
        simpleClassTagRules2.put("#receiver_age", SimpleNPC.Field.AGE);


        TagProcessor tp = new TagProcessor(
            new SimpleStringTagReplaceStrategy(simpleTagRules1),
            new SimpleStringTagReplaceStrategy(simpleTagRules2),
            new SimpleNPCTagReplaceStrategy(simpleNPC1, simpleClassTagRules1),
            new SimpleNPCTagReplaceStrategy(simpleNPC2, simpleClassTagRules2)
        );

        tp.process(processedText);
        processedText = tp.result();


        System.out.print("Original:\n\t");
        System.out.println(originalText);

        System.out.print("Processed:\n\t");
        System.out.println(processedText);

    }


}
