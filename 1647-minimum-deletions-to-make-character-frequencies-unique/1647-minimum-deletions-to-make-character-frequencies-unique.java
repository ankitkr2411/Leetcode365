class Solution {
    public int minDeletions(String s) {

        if(s.equals(""))
        {
            return 0;
        }
        
        /*------------Counting frequency using HashMap But not Optimal-----------------*/

        // Map<Character,Integer> map = new HashMap<>();
        // char c;
        
        // for(int i=0;i<s.length();i++)
        // {
        //     c=s.charAt(i);
        //     if(!map.containsKey(c))
        //     {
        //         map.put(c,1);
        //     }
        //     else{
        //         map.put(c,map.get(c)+1);
        //     }
        // }

        // int count=0;
        // Set<Integer> set = new HashSet<>();
        
        // for(Integer v: map.values())
        // {

            
        //     while(set.contains(v)&& v!=0)
        //     {
        //         v--;
        //         count++;
        //     }
            
        //     set.add(v);    
        // }
        
        // return count;



        /*------------Counting frequency using Array and Optimal-----------------*/

        int[] ch = new int[26];

        for(char c:s.toCharArray())
        {
            ch[c-'a']++;
        }

        
        int count=0;
        Set<Integer> set = new HashSet<>();
        
        for(int v:ch)
        {      
            while(set.contains(v)&& v!=0)
            {
                v--;
                count++;
            }
            
            set.add(v);    
        }
        
        return count;
        
    }
}