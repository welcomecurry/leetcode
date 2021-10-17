class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int output = 0;
        PriorityQueue<Integer> studs = new PriorityQueue<>();
        PriorityQueue<Integer> seeds = new PriorityQueue<>();

        for(int i = 0; i < seats.length; i++)
        {
            studs.add(students[i]);
            seeds.add(seats[i]);
        }
        
        while(!studs.isEmpty())
        {
            int currStudent = studs.poll();
            int currSeat = seeds.poll();
            
            output += Math.max(currStudent, currSeat) - Math.min(currStudent, currSeat);
        }
        
        return output;
    }
}