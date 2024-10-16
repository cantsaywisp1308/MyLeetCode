package trial;

public class DistributionCountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[] list = {'b', 'c', 'd', 'c', 'b', 'a', 'a', 'b'};
	        char[] sortedList = sort(list);
	        
	        for (char c : sortedList) {
	            System.out.print(c + " ");
	        }
	}
	public static char[] sort(char[] list) {
        // Counting the occurrences
        int[] count = new int[4]; // since there are 4 possible letters {a, b, c, d}
        for (char c : list) {
            count[getIndex(c)]++;
        }

        // Redistributing
        char[] sortedList = new char[list.length];
        int currentIndex = 0;
        char[] letters = {'a', 'b', 'c', 'd'};
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sortedList[currentIndex++] = letters[i];
            }
        }
        return sortedList;
    }

    // Helper function to get index of a character in {a, b, c, d}
    public static int getIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            default: return -1; // Should not occur
        }
    }

}
