class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //init output
        //create set out of supplies
        //loop through ingredients
        //for all recipes check if supplies of all ingredients are present or not
        //if present then add to output and in supplies list (so that it can be used later)
        
        Set<String> supplys = new HashSet<>(Arrays.asList(supplies));
        Set<String> output = new HashSet<>();
        
        for(int i = 0; i < ingredients.size(); i++)
        {
            outer:
            for(int j = 0; j < ingredients.size(); j++)
            {                
                if(output.contains(recipes[j])) continue;
                
                for(String ingre : ingredients.get(j))
                {
                    if(!supplys.contains(ingre)) continue outer;
                }
                
                output.add(recipes[j]);
                supplys.add(recipes[j]);
            }
        }
        
        return new ArrayList<>(output);
    }
    
}