class Solution {
    Set<List<Integer>> uniques;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        uniques = new HashSet<>();
        this.target = target;

        // Create a frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : candidates) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Extract keys as a unique list of elements
        List<Integer> uniqueCandidates = new ArrayList<>(freqMap.keySet());
        findCombinations(uniqueCandidates, 0, 0, new ArrayList<>(), freqMap);

        return new ArrayList<>(uniques);
    }

    public void findCombinations(List<Integer> candidates, int index, int sum, List<Integer> numList, Map<Integer, Integer> freqMap) {
        if (sum == target) {
            uniques.add(new ArrayList<>(numList));
            return;
        }

        for (int i = index; i < candidates.size(); i++) {
            int num = candidates.get(i);
            int remaining = target - sum;

            if (num > remaining) {
                continue; // skip if adding this number exceeds the target
            }

            if (freqMap.get(num) == 0) {
                continue; // skip if this number is exhausted
            }

            // Choose the current number
            numList.add(num);
            freqMap.put(num, freqMap.get(num) - 1);

            // Recur for the next elements
            findCombinations(candidates, i, sum + num, numList, freqMap);

            // Backtrack: remove the last chosen number and restore the count
            numList.remove(numList.size() - 1);
            freqMap.put(num, freqMap.get(num) + 1);
        }
    }
}
