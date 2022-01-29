class Solution {
    public int largestRectangleArea(int[] heights) {
        //init two stacks to keep track of height and position
        //init max area
        //loop through the heights array
        //init a last position variable, init to length of the heights
        //while the height stack is not empty and heightStack.peek() > heights[i]
            //update lastPosition with the peek of the postion stack
            //currArea = i - positionStack.pop() * heightStack.pop() 
            //take max of currArea and maxArea
        //if the height stack is empty or heightStack.peek() < heights[i]
            //push the height onto heightStack
            //push the minimum of the lastpoistion and i onto the positionStack
        //after we break from the loop we need to compute the remaining rectangles
        //so, while the height stack is not empty
        //calculate the area by heights length - position.pop() * height.pop()
        //then take max of currArea and maxArea
        //return maxArea
        
        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> positionStack = new Stack<>();
        int maxArea = 0;
        
        for(int i = 0; i < heights.length; i++)
        {
            int lastPosition = heights.length;
            
            while(!heightStack.isEmpty() && heightStack.peek() > heights[i]) //calculate area
            {
                //we found a dip so calculate area of current rectangle on top of the stack
                //we are using a while loop since if we might have multiple rectangeles to calculate
                lastPosition = positionStack.peek();
                int currArea = (i - positionStack.pop()) * heightStack.pop();
                maxArea = Math.max(maxArea, currArea);
            }
            
            if(heightStack.isEmpty() || heightStack.peek() < heights[i])//push pos and height on stacks
            {
                //we are now pushing a new height and postion onto respective stacks
                heightStack.push(heights[i]);
                positionStack.push(Math.min(i, lastPosition));
            }
        }
        
        while(!heightStack.isEmpty())
        {
            int currArea = (heights.length - positionStack.pop()) * heightStack.pop();
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
}