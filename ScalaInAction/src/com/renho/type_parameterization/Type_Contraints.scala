package com.renho.type_parameterization
object Type_Contraints {

  def main(args: Array[String]){
    //A =:= B  //��ʾA���͵�ͬ��B����
    //A <:< B  //��ʾA������B���͵�������
    def rocky[T](i:T)(implicit ev: T <:< java.io.Serializable) {
      print("Life is short,you need spark!") }
    rocky("Spark")
  
    
    
  }

}