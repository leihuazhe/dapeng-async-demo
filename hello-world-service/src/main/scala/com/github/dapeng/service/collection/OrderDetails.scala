package com.github.dapeng.service.collection

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-24 3:03 PM
  */
case class OrderDetails(name: String, prices: Option[Double])


object Main {
  val orderDetails = List(OrderDetails("maple", Some(2.2)))

  def main(args: Array[String]): Unit = {
    val value = "3#2#"


    val i: Int = value.indexOf("#")

    val s = "Replace the string with yourself."

    //根据要求，字符串有2个相同的字符，即判定为有相同字符
    def haveSameChar(s: String): Boolean = {
      var i = 0
      while ( {
        i < s.length
      }) {
        val ch = s.charAt(i)
        val s1 = s.substring(i + 1) //i之后的字符串
        if (s1.indexOf(ch) >= 0) return true

        {
          i += 1;
          i - 1
        }
      }
      false
    }

    //    println(i)
  }


}