package com.hariommaurya.interview.codingQuestions.trees.medium;

import java.util.*;

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}

public class InfectedTimeBTree {

    public static Map<Integer, List<Integer>> convertBinaryTreeIntoUndirectedGraph(TreeNode root){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        dfs(root,null,graph);
        return graph;
    }
    public static void dfs(TreeNode node,TreeNode parent,Map<Integer,List<Integer>> graph){
        if(node == null) return;
        if(parent != null){
            int currentNode = node.val;
            int parentNode = parent.val;
            if(graph.get(currentNode) == null){
                List<Integer> list =new ArrayList<>();
                list.add(parentNode);
                graph.put(currentNode,list);
            } else{
                List<Integer> list = graph.get(currentNode);
                list.add(parentNode);
                graph.put(currentNode,list);
            }
            if(graph.get(parentNode) == null){
                List<Integer> list =new ArrayList<>();
                list.add(currentNode);
                graph.put(parentNode,list);
            } else{
                List<Integer> list = graph.get(parentNode);
                list.add(currentNode);
                graph.put(parentNode,list);
            }
//            System.out.println("graph parent: "+parent.val+" node :"+node.val);
//            graph.forEach((key,value) -> System.out.println(key +" : "+value));

        }
        dfs(node.left,node,graph);
        dfs(node.right,node,graph);
    }
   // public static int findMaxDepth(Map<Integer,List<Integer>> graph,int start){
//        if(graph.size() == 0 || graph.size() == 1) return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer,Boolean> visited = new HashMap<>();
//        for(Integer i : graph.get(start)){
//            queue.add(i);
//            visited.put(i,true);
//        }
//
//        for(Integer key : graph.keySet()){
//            if(visited.get(key) == null){
//                visited.put(key,false);
//            }
//        }
//        //System.out.println("visited : "+visited.toString());
//        int res = 0;
//        while (!queue.isEmpty()){
//            int len = queue.size();
//            while (len > 0){
//                Integer current = queue.poll();
//                List<Integer> list = graph.get(current);
//                //System.out.println("current :"+current+" list :"+list);
//                for (Integer i : list){
//                    //System.out.println("visited check: "+i+" :"+(visited.get(i) != null && !visited.get(i)));
//                    if(visited.get(i) != null && !visited.get(i)){
//                        queue.add(i);
//                        visited.put(i,true);
//                    }
//                }
//                --len;
//            }
//            res++;
//        }
//        return res;
   // }
    public static int findMaxDepth(Map<Integer, List<Integer>> graph,int startNode) {
        Set<Integer> visited = new HashSet<>();
        return dfs(startNode, visited, 0,graph);
    }

    private static int dfs(int currentNode, Set<Integer> visited, int depth,Map<Integer, List<Integer>> graph) {
        visited.add(currentNode);
        int maxDepth = depth;

        for (int neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                maxDepth = Math.max(maxDepth, dfs(neighbor, visited, depth + 1,graph));
            }
        }

        return maxDepth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        Map<Integer,List<Integer>> graph = convertBinaryTreeIntoUndirectedGraph(root);
        graph.forEach((key,value) -> System.out.println(key +" : "+value));
        System.out.println("Time : " + findMaxDepth(graph,5));
    }

}
