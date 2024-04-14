package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {


        public IntegerDuplicateDeleter(Integer[] array){
            super(array);
        }
        @Override
        public Integer[] removeDuplicates(int maxNumberOfDuplications) {
            if(maxNumberOfDuplications <= 1){
                return new Integer[0];
            }
            Arrays.sort(array);
            int i = 0;
            //find the size of the new array
            int newArrSize = 0;
            while(i < array.length)
            {
                if(i+maxNumberOfDuplications-1< array.length && array[i].equals(array[i+maxNumberOfDuplications-1])){
                    int duplicate = array[i];
                    while(i<array.length && array[i] == duplicate){
                        i++;
                    }
                }
                else {
                    newArrSize++;
                    i++;
                }
            }

            //store non-duplicate values in the new array
            Integer[] newArray = new Integer[newArrSize];
            i=0;
            int newArrayIndex = 0;
            while(i < array.length)
            {
                if(i+maxNumberOfDuplications-1< array.length && array[i].equals(array[i+maxNumberOfDuplications-1])){
                    int duplicate = array[i];
                    while(i<array.length && array[i] == duplicate){
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
        public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
            if(exactNumberOfDuplications < 1){
                return new Integer[0];
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
                    int duplicate = array[i];
                    boolean isBiggerDup = (i+exactNumberOfDuplications < array.length && array[i].equals(array[i+exactNumberOfDuplications]));
                    while(i<array.length && array[i] == duplicate){
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
            Integer[] newArray = new Integer[newArrSize];
            i=0;
            int newArrayIndex = 0;
            while(i < array.length)
            {
                if(i+exactNumberOfDuplications-1< array.length
                        && array[i].equals(array[i+exactNumberOfDuplications-1])
                )
                {
                    int duplicate = array[i];
                    boolean isBiggerDup = (i+exactNumberOfDuplications < array.length && array[i].equals(array[i+exactNumberOfDuplications]));
                    while(i<array.length && array[i] == duplicate){
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
