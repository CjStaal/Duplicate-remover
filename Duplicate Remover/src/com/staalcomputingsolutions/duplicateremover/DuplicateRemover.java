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
