class Solution {
    public List<List<Integer>> groupThePeople(int[] g) {

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        //Filling Logic
        for(int i=0;i<g.length;i++)
        {
            if(map.containsKey(g[i]))
            {   
                map.get(g[i]).add(i);
            }
            else{
                map.put(g[i],new ArrayList<>());
                map.get(g[i]).add(i);
            }
        }

        for(Integer key: map.keySet())
        {
            int j=0,k=(map.get(key).size()/key);
            for(int i=0;i<k;i++)
            {
                List<Integer> li = new ArrayList<>();
                int uLimit=j+key;
                while(j<(uLimit))
                {
                    li.add(map.get(key).get(j));
                    j++;
                }

                ans.add(li);


            }
        }

        return ans;

        
    }
}