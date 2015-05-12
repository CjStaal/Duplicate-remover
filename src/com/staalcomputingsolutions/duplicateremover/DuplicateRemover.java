/* 
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.staalcomputingsolutions.duplicateremover;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class DuplicateRemover {

    /**
     * @param args0 The first string will be the characters to be removed (no
     * spaces in between), the rest of the strings are created in to one string,
     * saving the whitespaces.The second string will be the one that gets the
     * duplicates removed. The first instance of each character in the first
     * string are left alone and the rest of the instances of those characters
     * are removed.
     *
     */
    public static void main(String[] args0) {
        if (args0.length >= 2) {
            String toBeRemoved = args0[0];
            String theString = "";

            for (int x = 1; x < args0.length; x++) {
                theString += args0[x];
                if (x + 1 != args0.length) {
                    theString += " ";
                }
            }
            System.out.println(removeDuplicateVONE(toBeRemoved, theString));
            System.out.println(removeDuplicateVTHREE(toBeRemoved, theString));
        }
    }

    public static String removeDuplicateVONE(String toBeRemoved, String theString) {
        int firstIndex;
        char theChar;
        for (int index = 0; index < toBeRemoved.length(); index++) {
            theChar = toBeRemoved.charAt(index);
            firstIndex = theString.indexOf(theChar);
            if (theString.lastIndexOf(theChar, firstIndex) != -1) {
                theString = theString.substring(0, firstIndex + 1) + theString.substring(firstIndex + 1).replaceAll(Character.toString(theChar), "");

            }
        }
        return theString;
    }

    /*
     public static String removeDuplicateVTWO(String toBeRemoved, String theString) {
     char[] newString = new char[theString.length()];
     List<Integer> indexes = new LinkedList();
     char currentChar;
     int index;
     for (int rsi = 0; rsi < toBeRemoved.length(); rsi++) {
     currentChar = toBeRemoved.charAt(rsi);
     for (int tsi = 0; tsi < theString.length() - 1; tsi++) {
     if (theString.charAt(tsi) == currentChar) {
     indexes.add(tsi);
     }
     }
     for (int x = indexes.size() - 1; x > 0; x--) {
     index = indexes.get(x);
     newString[index] = theString.charAt(x);
     }
     indexes.clear();
     }
     StringBuilder sb = new StringBuilder();
     for (int x = 0; x < newString.length; x++) {
     if (newString[x] != '\0') {
     sb.append(newString[x]);
     }
     }
     return sb.toString();
     }*/
    public static String removeDuplicateVTHREE(String toBeDeleted, String theString) {

        char currentChar;
        char[] theStringCharArray = theString.toCharArray();
        boolean foundFirst;

        for (int index0 = 0; index0 < toBeDeleted.length(); index0++) {
            currentChar = toBeDeleted.charAt(index0);
            foundFirst = false;
            for (int index1 = 0; index1 < theStringCharArray.length; index1++) {
                if (theStringCharArray[index1] == currentChar) {
                    if (foundFirst) {
                        theStringCharArray[index1] = '\0';
                    } else {
                        foundFirst = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int index2 = 0; index2 < theStringCharArray.length; index2++) {
            if (theStringCharArray[index2] != '\0') {
                sb.append(theStringCharArray[index2]);
            }
        }
        return sb.toString();
    }
}