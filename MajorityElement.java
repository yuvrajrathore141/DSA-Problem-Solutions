

//import java.util.HashMap;

class Solution{
    public int majorityElement(int[] n){
        //int threshold = n.length / 2;

        //Better Approch
        //HashMap<Integer, Integer> map = new HashMap<>();
        //for(int value : n){
        //    int updatedFrequency = map.getOrDefault(value, 0) + 1;
        //    map.put(value, updatedFrequency);
        //    if(updatedFrequency > threshold){
        //        return value;
        //    }
        //};

        //Optimal Approch - Boyer moore
        int candidate = n[0], balance = 0;
        for(int value : n){
            if(balance == 0)
                candidate = value;
            if(value == candidate){
                balance++;
            }else{
                balance--;
            }
            
        }

        return candidate;
    }
}
class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 2, 1, 2};

        // instance for class Solution
        Solution sol = new Solution();

        System.out.println(sol.majorityElement(nums));
    }
}


//For n/3
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     // Returns all elements appearing more than one-third of the time.
//     public List<Integer> majorityElement(int[] nums) {
//         int candidate1 = nums[0];
//         int candidate2 = nums[0];
//         int count1 = 0;
//         int count2 = 0;

//         // Select at most two possible candidates through vote cancellation.
//         for (int value : nums) {
//             // A match strengthens the first candidate.
//             if (value == candidate1) {
//                 count1++;
//             }
//             // A match strengthens the second candidate.
//             else if (value == candidate2) {
//                 count2++;
//             }
//             // An empty first slot accepts the current value as its candidate.
//             else if (count1 == 0) {
//                 candidate1 = value;
//                 count1 = 1;
//             }
//             // An empty second slot accepts the current value as its candidate.
//             else if (count2 == 0) {
//                 candidate2 = value;
//                 count2 = 1;
//             }
//             // A third distinct value cancels one vote from both candidates.
//             else {
//                 count1--;
//                 count2--;
//             }
//         }

//         int verified1 = 0;
//         int verified2 = 0;

//         // Count the real frequencies of the selected candidates.
//         for (int value : nums) {
//             // An occurrence of the first candidate increases its verified count.
//             if (value == candidate1) {
//                 verified1++;
//             }
//             // An occurrence of the second candidate increases its verified count.
//             else if (value == candidate2) {
//                 verified2++;
//             }
//         }

//         int threshold = nums.length / 3;
//         List<Integer> answer = new ArrayList<>();

//         // Include the first candidate only when its real frequency qualifies.
//         if (verified1 > threshold) {
//             answer.add(candidate1);
//         }

//         // Include a distinct second candidate only when it also qualifies.
//         if (candidate2 != candidate1 && verified2 > threshold) {
//             answer.add(candidate2);
//         }

//         return answer;
//     }
// }

// // Driver code
// class Main {
//     public static void main(String[] args) {
//         int[] nums = {1, 2, 3, 1, 2, 1, 2, 4, 2, 1};

//         // instance for class Solution
//         Solution sol = new Solution();

//         System.out.println(sol.majorityElement(nums));
//     }
// }