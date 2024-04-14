package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {


        public  StringDuplicateDeleter( String[] array){
            super(array);
        }
        @Override
        public String[] removeDuplicates(int maxNumberOfDuplications) {
            if(maxNumberOfDuplications <= 1){
                return new String[0];
            }
            Arrays.sort(array);
            int i = 0;
            //find the size of the new array
            int newArrSize = 0;
            while(i < array.length)
            {
                if(i+maxNumberOfDuplications-1< array.length && array[i].equals(array[i+maxNumberOfDuplications-1])){
                    String duplicate = array[i];
                    while(i<array.length && Objects.equals(array[i], duplicate)){
                        i++;
                    }
                }
                else {
                    newArrSize++;
                    i++;
                }
            }

            //store non-duplicate values in the new array
            String[] newArray = new String[newArrSize];
            i=0;
            int newArrayIndex = 0;
            while(i < array.length)
            {
                if(i+maxNumberOfDuplications-1< array.length && array[i].equals(array[i+maxNumberOfDuplications-1])){
                    String duplicate = array[i];
                    while(i<array.length && Objects.equals(array[i], duplicate)){
                        i++;
                    }
                }
                else {
                    newArray[newArrayIndex] = array[i];
                    i++;
                    newArrayIndex++;
                }
            }
            return newArray;
        }

        @Override
        public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
            if(exactNumberOfDuplications < 1){
                return new String[0];
            }
            Arrays.sort(array);
            int i = 0;
            //find the size of the new array
            int newArrSize = 0;
            while(i < array.length)
            {
                if(i+exactNumberOfDuplications-1< array.length
                        && array[i].equals(array[i+exactNumberOfDuplications-1])
                )
                {
                    String duplicate = array[i];
                    boolean isBiggerDup = (i+exactNumberOfDuplications < array.length && array[i].equals(array[i+exactNumberOfDuplications]));
                    while(i<array.length && Objects.equals(array[i], duplicate)){
                        if(isBiggerDup){
                            newArrSize++;
                        }
                        i++;
                    }
                }
                else {
                    newArrSize++;
                    i++;
                }
            }

            //store non-duplicate values in the new array
            String[] newArray = new String[newArrSize];
            i=0;
            int newArrayIndex = 0;
            while(i < array.length)
            {
                if(i+exactNumberOfDuplications-1< array.length
                        && array[i].equals(array[i+exactNumberOfDuplications-1])
                )
                {
                    String duplicate = array[i];
                    boolean isBiggerDup = (i+exactNumberOfDuplications < array.length && array[i].equals(array[i+exactNumberOfDuplications]));
                    while(i<array.length && Objects.equals(array[i], duplicate)){
                        if(isBiggerDup){
                            newArray[newArrayIndex] = array[i];
                            newArrayIndex++;
                        }
                        i++;
                    }
                }
                else {
                    newArray[newArrayIndex] = array[i];
                    i++;
                    newArrayIndex++;
                }
            }
            return newArray;
        }

}
