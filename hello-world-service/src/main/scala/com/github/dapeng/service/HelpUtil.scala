package com.github.dapeng.service

import com.maple.test.HttpAsyncClient


/**
  * @author maple 2018.09.13 下午2:35
  */
object HelpUtil {



  def doJsonPost(name: String, message: Option[String]): String = {
    Thread.sleep(20000)
    s"处理成功 $name , $message"
  }




}
