package com.renho.ch6

/**
  * Created by renho on 2016/1/12.
  */
class Rational(n: Int, d:Int) {
//	println("Created "+n+"/"+d)
	//分母d不能为0
	require(d != 0)
	//简化分数
	private val g = gcd(n.abs, d.abs)
	val numer = n / g
	val denom = d / g
	//从构造器
	def this(n: Int) = this(n, 1)
	def +(that: Rational): Rational =
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom
		)
	def +(i: Int): Rational =
		new Rational(numer + i * denom, denom)
	def -(that: Rational): Rational =
		new Rational(
			numer * that.denom - that.numer * denom,
			denom * that.denom
		)
	def -(i: Int): Rational =
		new Rational(numer - i* denom, denom)
	def *(that: Rational): Rational =
		new Rational(numer * that.numer, denom * that.denom)
	def *(i: Int): Rational =
		new Rational(numer * i, denom)
	def /(that: Rational): Rational =
		new Rational(numer * that.denom, denom * that.numer)
	def /(i: Int): Rational =
		new Rational(numer, denom * i)
	override def toString = numer+"/"+denom
	private def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)
}

object Test {
	def main(args: Array[String]) {
		//隐式转换
		implicit def intToRational(x: Int) = new Rational(x)
		var r0 = new Rational(1, 2)
		println(2 * r0)
	}
}