class Solution {
    public int numUniqueEmails(String[] emails) {
        // get domain name by looping from the end of the string to @
       // if before domain contains a . remove it
       // if there is a + everything after up until domain is ignored
        // add the local name and domain together and add it to hashset
        // return hashset.size()
        
        Set<String> set = new HashSet<>();
        
        for(String email : emails)
        {
            int index = email.indexOf("@");
            String localName = email.substring(0, index);
            String domainName = email.substring(index);
            
            if(localName.contains("+"))
            {
                localName = localName.substring(0, localName.indexOf("+"));
            }
            
            localName = localName.replace(".", "");
            
            set.add(localName + domainName);
        }
        
        return set.size();
    }
}