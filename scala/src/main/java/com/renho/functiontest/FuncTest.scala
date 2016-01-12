package com.renho.functiontest

object FuncTest {
    //����
    def addInt(a: Int, b: Int): Int = {
        var sum: Int = 0
        sum = a + b
        return sum
    }
    //����,�������κζ���
    def printMe(): Unit = {
        println("Hello, Scala!")
    }
    //
    def time() = {
        println("Getting time in nano seconds")
        System.nanoTime
    }
    def delayed(t: => Long) = {
        println("In delayed method")
        println("Param: " + t)
        t
    }
    def printInt(a: Int, b: Int) = {
        println("Value of a : " + a);
        println("Value of b : " + b);
    }
    def factorial(n: BigInt): BigInt = {
        if (n <= 1)
            1
        else
            n * factorial(n - 1)
    }
    def printStrings(args: String*) = {
        var i: Int = 0;
        for (arg <- args) {
            println("Arg value[" + i + "] = " + arg);
            i = i + 1;
        }
    }
    def addIntByDefault(a: Int = 5, b: Int = 7): Int = {
        var sum: Int = 0
        sum = a + b
        return sum
    }

    //�߽׺���
    def apply(f: Int => String, v: Int) = f(v)
    def layout[A](x: A) = "[" + x.toString() + "]"
    
    def main(args: Array[String]): Unit = {
        println(addInt(1, 100));
        printMe();
        delayed(time());
        printInt(b = 5, a = 7);

        for (i <- 1 to 10)
            println("Factorial of " + i + ": = " + factorial(i))
        printStrings("Hello", "Scala", "Python");
        println("Returned Value : " + addIntByDefault());
        println( apply( layout, 10) )
    }
}