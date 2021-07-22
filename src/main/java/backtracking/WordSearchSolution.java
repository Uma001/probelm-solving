package backtracking;

import java.util.ArrayList;
import java.util.List;

class TrieNode{

    private TrieNode[] links;
    private boolean isEnd;
    private String endString;

    public TrieNode(){
        links = new TrieNode[26];
    }

    public TrieNode getNode(char ch){
        return links[ch-'a'];
    }

    public void putNode(char ch, TrieNode node){
        links[ch-'a']=node;
    }

    public boolean containsKey(char ch ){
        return links[ch-'a']!=null;
    }

    public void setEnd(boolean val){
        isEnd=val;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEndString(String str){
        this.endString=endString;
    }

    public String getEndString(){
        return endString;
    }
}

class TrieNodeUtil{

    TrieNode node=new TrieNode();

    // public TrieNodeUtil(){
    //     node=new TrieNode();
    // }

    public void insert(String word){

        int len=word.length();

        for(int i=0;i<len;i++){
            char curr = word.charAt(i);
            if(!node.containsKey(curr)){
                node.putNode(curr, new TrieNode());
            }
            node=node.getNode(curr);
        }

        node.setEnd(true);
        node.setEndString(word);

    }

    public TrieNode getRoot(){
        return node;
    }
}

class WordSearchSolution {

    public List<String> findWords(char[][] board, String[] words) {

        TrieNodeUtil util=new TrieNodeUtil();
        //build the trie
        for(int i=0;i<words.length;i++){
            util.insert(words[i]);
        }
        List<String> ans=new ArrayList<>();

//        findWordsDFS(board,TrieNodeUtil.getRoot(),0,0,board.length, board[0].length, ans);

        return ans;
    }

    private void findWordsDFS(char[][] board, TrieNode root, int r, int c,int rows, int cols, List<String> ans){

//        if(r<0 || r>=rows || col<0 || col>=cols ||  board[r][c]=='$' || root.containsKey(board[r][c]==null)){
//            return;
//        }

        char ch=board[r][c];

        board[r][c]='$';

        if(root.isEnd()){
            ans.add(root.getEndString());
            root.setEnd(false);
        }
        root=root.getNode(board[r][c]);

        findWordsDFS(board,root,r+1,c,rows,cols, ans);
        findWordsDFS(board,root,r-1,c,rows,cols, ans);
        findWordsDFS(board,root,r,c+1,rows,cols, ans);
        findWordsDFS(board,root,r,c-1,rows,cols, ans);

        board[r][c]=ch;

    }

}
