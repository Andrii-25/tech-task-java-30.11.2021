package com.andrii;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.processing(getListWithRandomStrings(1000000), 2));
    }

    public String processing(List<String> values, int maxDuplicates) {
        String str = "";
        if(values.isEmpty()) {
            str = "The list of strings is empty!";
        }
        if(values.size() == 1) {
            return "In the list is only one element: " + values.get(0);
        }
        List<String> duplicates = new ArrayList<>();

        if(!values.isEmpty()) {
            for (String s : values) {
                String withoutSpaces = s.replaceAll("\\s", "");
                int currentValueDuplicates = 0;
                if (currentValueDuplicates <= maxDuplicates) {
                    for (int i = 0; i < withoutSpaces.length(); i++) {
                        for (int j = i + 1; j < withoutSpaces.length(); j++) {
                            if (withoutSpaces.charAt(i) == withoutSpaces.charAt(j)) {
                                currentValueDuplicates++;
                            }
                        }
                    }
                }
                if (currentValueDuplicates > maxDuplicates) {
                    duplicates.add(s);
                }
            }

            System.out.println("Strings that have more than " + maxDuplicates + " duplicate characters: " + duplicates);

            int index = values.indexOf(values.stream().max(Comparator.comparingInt(String::length)).get());
            if((index >= 0) && (index + 1 < values.size()) && (index - 1 >= 0)) {
                return values.get(index - 1) + values.get(index + 1);
            }
            if(index == 0) {
                return values.get(index + 1);
            }
            if(index == values.size() - 1) {
                return values.get(index - 1);
            }
        }
        return str;
    }

    public static String generateString(int origin, int bound) {
        int targetStringLength = ThreadLocalRandom.current().nextInt(origin, bound);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static List<String> getListWithRandomStrings(int capacity) {
        ArrayList<String> generatedList = new ArrayList<>();
        generatedList.ensureCapacity(capacity);
        for(int i = 0; i < capacity; i++) {
            generatedList.add(generateString(0, 10));
        }
        return generatedList;
    }
}