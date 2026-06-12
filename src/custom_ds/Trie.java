public class Trie {
    private static class TrieNode{
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode(){
            isLeaf = false;
            children = new TrieNode[26];
        }
    }


    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }


    // Method to insert a string key into the Trie
    public void insert(String s){
        TrieNode curr = root;

        for(char c: s.toCharArray()){
            // check if the node exists for the current character in the trie
            if(curr.children[c - 'a'] == null){
                // if current node does not exist make a new node
                curr.children[c - 'a'] = new TrieNode();

            }
            // move the curr pointer to the newly created node
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }


    // Method to search a string key in the Trie
    public boolean search(String s){
        TrieNode curr = root;
        for(char c: s.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isLeaf;
    }


    // Method to check if a prefix exists in the Trie
    public boolean isPrefix(String prefix){
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }


    public static void main(String[] args){
        Trie trie = new Trie();

        // Method to insert a string key into the Trie
        String[] words = {"and", "ant", "sugar", "mum"};
        for(String w: words){
            trie.insert(w);
        }


        // Method to search a string key in the Trie
        String[] checkWords = {"and", "ant", "super", "cute"};
        for(String w: checkWords){
            System.out.println(w + " found: " + trie.search(w));
        }


        // Method to check if a prefix exists in the Trie
        String[] prefixKeys = {"an", "an", "su", "cu"};
        for(String w: prefixKeys){
            System.out.println(w + " found: " + trie.isPrefix(w));
        }
    }
}
