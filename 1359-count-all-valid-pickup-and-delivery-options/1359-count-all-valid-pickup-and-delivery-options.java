class Solution {
    public int countOrders(int n) {
        //dynamic programming
        //For there were 2*(n-1) services, so we have 2*(n-1)+1 choices for the Pickup.
        //And now there were 2*n-1 services, so we hava 2*n choices for the Delivery.
        //Now, the total choices is 2*n*(2*n-1).
        //Because that delivery(i) is always after of pickup(i), so we need divide 2.
        //And for every P&D inserting, we wil hava n*(2*n - 1) choices.
        
        long count = 1, mod = 1000000007;
        
        for(int i = 1; i <= n; i++) count = count * (2 * i - 1) * i % mod;
        
        return (int) count;
    }
}