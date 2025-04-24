import java.util.*;

//class Entry implements Comparable<Entry> {
//    private double key;
//    private int value;
//
//    public Entry(double key, int value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public double getKey() {
//        return key;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//// getters
//
//    @Override
//    public int compareTo(Entry other) {
//        return  (int)(this.getKey() - other.getKey());
//    }
//}

class Entry implements Comparable<Entry> {
    private double key;
    private int value;

    public Entry(double key, int value) {
        this.key = key;
        this.value = value;
    }

    public double getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setKey(double key) {
        this.key = key;
    }

    @Override
    public int compareTo(Entry o) {
        return (int)(o.getKey() - this.getKey());
    }
}



public class MinimizeMaxDistToGasStation {

    // TC: O(k * n) + O(n)
    //SC: O(n)
    public static Double mimimizeDistNaive(int[] arr, int k){
        int[] gapsToFill = new int[arr.length - 1];
        for(int gasStation = 1; gasStation <= k; gasStation++){
            double maxGap = -1;
            int maxGapIdx = -1;

            for(int i = 0; i < arr.length - 1; i++){
                int diff = arr[i + 1] - arr[i];
                double sectionGap = (double)diff / (gapsToFill[i] + 1);
                if(sectionGap > maxGap){
                    maxGap = sectionGap;
                    maxGapIdx = i;
                }
            }

            gapsToFill[maxGapIdx]++;
        }

        double maxAns = -1D;
        for(int i = 0; i < arr.length - 1; i++){
            int diff = arr[i + 1] - arr[i];
            double sectionGap = (double)diff / (gapsToFill[i] + 1);
            maxAns = Math.max(sectionGap, maxAns);
        }

        return maxAns;
    }

    public static Double minimizeDistPQ(int[] arr, int k){
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        int[] gapsToFill = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++){
            pq.add(new Entry(arr[i + 1] - arr[i], i));
        }

        for(int gasStation = 1; gasStation <= k; gasStation++) {
            Entry maxGapEntry = pq.poll();
            int sectionIdx = maxGapEntry.getValue();
            gapsToFill[sectionIdx]++;
            double initialDiff = arr[sectionIdx + 1] - arr[sectionIdx];
            double newDiff = initialDiff / (gapsToFill[sectionIdx] + 1);
            pq.add(new Entry(newDiff, sectionIdx));
        }

        return pq.poll().getKey();
    }

    public static void main(String[] args) {
        // Try to place gas stations as close as possible
        int[] arr = {1, 13, 17, 23};
        int k = 5;

        System.out.println(mimimizeDistNaive(arr, k));
    }
}
