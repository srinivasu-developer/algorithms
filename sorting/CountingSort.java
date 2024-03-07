public class CountingSort {

    /* Given the string, arrange it lexographically sorted with counting sort */
    public static String countSort(String arr) {
        int stringSize = arr.length();
        if(stringSize < 2) {
            return arr;
        }
        int[] charCount = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringSize; i++) {
            charCount[arr.charAt(i) - 97]++;
        }
        for(int i = 0; i < 26; i++) {
            while(charCount[i] > 0) {
                sb.append(Character.toString(97 + (i)));
                --charCount[i];
            }
        }
        return sb.toString();
    }
}
