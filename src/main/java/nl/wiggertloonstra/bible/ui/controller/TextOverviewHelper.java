package nl.wiggertloonstra.bible.ui.controller;

import java.util.List;

import com.google.common.collect.Lists;

public class TextOverviewHelper {
    
    public static List<String> defaultTexts() {
        List<String> texts = Lists.newArrayList();
        texts.add("Gen+1:1-10");
        texts.add("Mat+2:1-5");
        texts.add("Ruth+3:1-8");
        texts.add("Mal+1:3-7");
        texts.add("Joh+3:16");
        texts.add("1+Kor+15:58");
        return texts;
    }

}
