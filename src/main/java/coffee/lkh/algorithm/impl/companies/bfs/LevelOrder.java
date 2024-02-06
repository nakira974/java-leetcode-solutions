package coffee.lkh.algorithm.impl.companies.bfs;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.*;

public class LevelOrder extends DetailedAlgorithmBase {


    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
          private int val;
          private TreeNode left;
          private TreeNode right;
          TreeNode() {}
          public TreeNode(int val) { this.val = val; }
          public TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
    private static final String ROOT = "root";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if(!isParametersValid(params)){
            throw new RuntimeException("Invalid BFS levelOrder parameter TreeNode root !");
        }
        final TreeNode root = (TreeNode) params.get(ROOT);
        params.put("result", levelOrder(root));
        return params;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        // if the root is null then return the empty result list
        if(root == null) return result;
        result.add(new ArrayList<>());
        final Queue<TreeNode> layerQueue = new LinkedList<>();
        // add the root into the head of queue
        layerQueue.offer(root);
        List<Integer> currentLayer;
        TreeNode currentNode;
        final Map<TreeNode, Integer> layersMap = new HashMap<>();
        int lastLayerCount = 1;
        layersMap.put(root, lastLayerCount);
        while(!layerQueue.isEmpty()){
            currentNode = layerQueue.poll();
            int layerCount = layersMap.get(currentNode);
            if(currentNode.left != null){
                layersMap.put(currentNode.left, layerCount+1);
                layerQueue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                layersMap.put(currentNode.right, layerCount+1);
                layerQueue.offer(currentNode.right);
            }
            if(layerCount>lastLayerCount){
                lastLayerCount = layerCount;
                currentLayer = new ArrayList<>();
                currentLayer.add(currentNode.val);
                result.add(currentLayer);
            }else{
                result.get(lastLayerCount-1).add(currentNode.val);
            }
        }

        return result;

    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(ROOT) && params.get(ROOT) instanceof TreeNode;
    }
}
