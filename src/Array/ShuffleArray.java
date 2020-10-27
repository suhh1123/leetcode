package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
    private int[] array;
    private int[] original;
    private Random rand = new Random();
    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle1() {
        List<Integer> aux = getArrayCopy();
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return array;
    }

    public int[] shuffle2() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }
        return array;
    }
}
