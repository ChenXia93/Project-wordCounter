import java.util.*;

public class WordSet<K extends Comparable<K>, V> implements Counter<K, V> {
      // Declare any required instance variables or helpful auxiliary types and methods here
      private final Map<K, WordSetObject> map;
      public WordSet() {
            map = new HashMap<K, WordSetObject>();
      }
      //Defined my own class  wordSetObject:
      //mainly to define my own methods for add and getCount
      private static class WordSetObject{
            private int count;
            private final HashSet<String> forms;
            //constructor hashset form and add the newly form words

            public WordSetObject(String word) {
                  this.forms = new HashSet<>();
                  add(word);
            }
            //add the forms into map
            public void add(String word) {
                  this.forms.add(word);
                  count++;
            }
            //get count
            public int getCount() {
                  return count;
            }
      }


      public String get(K word) {
            // Return values of a json entry for a word.
            // In other words, the returned String should contain:
            // - the count for the word,
            // - followed by a comma,
            // - followed by all unique occurrences of the word separated by commas.
            //Enter code here
            StringBuilder sb = new StringBuilder();
            WordSetObject obj = map.get(word);
            if(obj == null) {
                  sb.append("0");
            }
            else {
                  sb.append(obj.getCount());
            }
            sb.append(",");
            StringBuilder forms = new StringBuilder();
            assert obj != null;
            for(String s : obj.forms) {
                  forms.append(s).append(",");
            }
            sb.append(forms);
            return sb.toString();
      }

      public int getCount(K word) {
            WordSetObject obj = map.get(word);
            if(obj == null) {
                  return 0;
            }
            return obj.getCount();
      }

      //remove special case conditions ending with
      //'s, ed, s, and ing
      //after its removed. The new form will be added
      public void put(K keyWord, V word) {
            String strKeyWord = keyWord.toString().toLowerCase().replaceAll("[^a-zA-Z']+$"," ");  //o(1)
            String strWord = word.toString().replaceAll("[^a-zA-Z']+$"," ");                     //o(1)
            if(strKeyWord.endsWith("'s")) {                                                                     //o(1)
                  strKeyWord = strKeyWord.substring(0, strKeyWord.length() - 2);
            } else if(strKeyWord.endsWith("s")) {                                                             //o(1)
                  strKeyWord = strKeyWord.substring(0, strKeyWord.length() - 1);
            } else if(strKeyWord.endsWith("ed")) {                                                          //o(1)
                  strKeyWord = strKeyWord.substring(0, strKeyWord.length() - 2);
            } else if(strKeyWord.endsWith("ing")) {                                                        //o(1)
                  strKeyWord = strKeyWord.substring(0, strKeyWord.length() - 3);
            }
            WordSetObject obj = map.get(strKeyWord);                                                     //o(1)
            if(obj == null) {                                                                         //B: o(1) W: o(n)
                  map.put((K) strKeyWord, new WordSetObject(strWord));
                  return;
            }
            obj.add(strWord);                                                                   //o(1) worst o(n)
      }

      public Set<K> keySet() {
            // You do not need to change this method, but can if you want to.
            return map.keySet();
      }
}