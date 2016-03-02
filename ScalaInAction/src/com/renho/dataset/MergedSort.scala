package com.renho.dataset

object MergedSort {

  def main(args: Array[String]){
     
    def mergedsort[T] (less: (T, T) => Boolean) (input: List[T]): List[T] = {

    def merge(xList: List[T], yList: List[T]): List[T] =
      (xList, yList) match {
      case (Nil, _) => yList
      case (_, Nil) => xList
      case (x :: xtail, y :: ytail) =>
        if (less(x, y)) x :: merge(xtail, yList)
        else y :: merge(xList, ytail)
    }
    val n = input.length / 2
    if (n == 0) input
    else {
      val (x, y) = input splitAt n //��Ҫ������б�inputƽ���ֳ������б�
      merge(mergedsort(less)(x), mergedsort(less)(y))  //�ȶԷֺ�������б�鲢�����ٶ��źõ��������й鲢
    }
  }
    println(mergedsort((x: Int, y: Int) => x < y) (List (3, 7, 9, 5)))
    val reversed_mergedsort=mergedsort((x: Int, y: Int) => x > y) _
    println(reversed_mergedsort(List(3, 7, 9, 5)))
    
    
    
    
    
}
}