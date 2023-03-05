package algorithm.uniset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MergeUser {

    class User {
        String a;
        String b;

        public User(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }


    public int mergeUser(List<User> users){
        HashMap<String,User> mapA = new HashMap<>();
        HashMap<String,User> mapB = new HashMap<>();
        UnionFind<User> unionSet = new UnionFind<>(users);

        for (User user : users) {
            if(mapA.containsKey(user.a)){
                unionSet.union(user,mapA.get(user.a));
            }else{
                mapA.put(user.a,user);
            }

            if(mapB.containsKey(user.b)){
                unionSet.union(user,mapB.get(user.b));
            }else{
                mapB.put(user.b,user);
            }
        }
        return unionSet.setSize();
    }

}
