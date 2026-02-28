class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        if(n==2) return 1;
        // List<List<Integer>>adj=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        // for(int i=0;i<n;i++){
        //     if(i-1>=0) adj.get(i).add(i-1);
        //     if(i+1<n) adj.get(i).add(i+1);
        //     for(int idx:map.get(arr[i])){
        //         if(idx!=i) adj.get(i).add(idx);
        //     }
        // }
        boolean []vis=new boolean[n];
        vis[0]=true;
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        int steps=0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int cur = q.poll();

                if(cur == n - 1) return steps;

                // i - 1
                if(cur - 1 >= 0 && !vis[cur - 1]) {
                    vis[cur - 1] = true;
                    q.add(cur - 1);
                }

                // i + 1
                if(cur + 1 < n && !vis[cur + 1]) {
                    vis[cur + 1] = true;
                    q.add(cur + 1);
                }

                // same value
                if(map.containsKey(arr[cur])) {
                    for(int idx : map.get(arr[cur])) {
                        if(!vis[idx]) {
                            vis[idx] = true;
                            q.add(idx);
                        }
                    }
                    map.remove(arr[cur]); // 🔥 critical optimization
                }
            }
            steps++;
        }
        return -1;
        

        
    }
}