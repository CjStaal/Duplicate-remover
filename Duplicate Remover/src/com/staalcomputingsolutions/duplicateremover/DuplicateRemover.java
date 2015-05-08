/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staalcomputingsolutions.duplicateremover;

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
            String firstString = args0[0];
            String secondString = "";

            for (int x = 1; x < args0.length; x++) {
                secondString += args0[x];
                if (x + 1 != args0.length) {
                    secondString += " ";
                }
            }
            int firstIndex;
            char theChar;
            for (int index = 0; index < firstString.length(); index++) {
                theChar = firstString.charAt(index);
                firstIndex = secondString.indexOf(theChar);
                if (secondString.lastIndexOf(theChar, firstIndex) != -1) {
                    secondString = secondString.substring(0, firstIndex + 1) + secondString.substring(firstIndex + 1).replaceAll(Character.toString(theChar), "");

                }
            }
            System.out.println(secondString);
        }
    }
}
