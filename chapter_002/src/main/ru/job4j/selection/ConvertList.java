package ru.job4j.selection;

public class Convertlist{
  public List<Integer> toList (int[][] array) {
    List<Integer> list = new ArrayList<Integer>();
    for(int[] arr: array){
     for (int i: arr){
      this.list.add(i);
      } 
     }
    return list;
  }
  public int[][] toArray (List<Integer> list, int rows) {
   int[][] arr  = new int[rows][rows];
    for (Integer i:list){
      for (int i = 0; i < rows; i++){
        for (int j = 0; j < rows; j++){
         if ((i+j+2) <= list.toarray().length) {
         arr[i][j] = (int)i;
         } else {
          arr[i][j] = 0;
          }
        }     
      }
    }
    return arr;
  }
}
