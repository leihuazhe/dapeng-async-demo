package com.github.dapeng.service

import java.util.concurrent.{CompletableFuture, Executors}

import com.github.dapeng.hello.domain.{Hello, HelloResponse}
import com.github.dapeng.hello.service.HelloService
import com.maple.test.HttpAsyncClient
import org.asynchttpclient.Response
import org.slf4j.LoggerFactory

import scala.concurrent.{ExecutionContext, Future, Promise}


/**
  * @author maple 2018.09.13 上午10:02
  */
class HelloServiceImpl extends HelloService {
  //  private val executors = Executors.newFixedThreadPool(Runtime.getRuntime.availableProcessors)

  private val logger = LoggerFactory.getLogger(getClass)

  implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(20))

  /**
    * 服务实现方法
    **/
  override def sayHello(hello: Hello): HelloResponse = {
    //    val completeFuture: CompletableFuture[HelloResponse] = new CompletableFuture[HelloResponse]()
    //耗时很久的方法 20s
    val result: Response = getPayThirdRequest(hello).get

    val response = new HelloResponse()
    response.setContent(result.getResponseBody)
    response.setThirdMsg(result.getContentType)
    response
  }


  /**
    * 调用第三方接口
    */
  def getPayThirdRequest(hello: Hello): CompletableFuture[Response] = wrapLog("请求第三方接口") {
    //      requestForGet
    val asyncHttpFuture: CompletableFuture[Response] = HttpAsyncClient.requestForGet1("http://127.0.0.1:8080/test", "")
    asyncHttpFuture
  }

  /**
    * 调用第三方接口
    */
  def postPayThirdRequest(hello: Hello): CompletableFuture[Response] = wrapLog("请求第三方接口") {
    //      requestForGet
    val asyncHttpFuture: CompletableFuture[Response] = HttpAsyncClient.requestForGet1("http://127.0.0.1:8080/post", "{body}")
    asyncHttpFuture
  }

  /**
    * 记录日志
    */
  def wrapLog[T](label: String)(f: => T): T = {
    val startTime = System.currentTimeMillis
    val result = f
    val endTime = System.currentTimeMillis
    logger.info(s"$label => 程序运行时间:${(endTime - startTime) / 1000}")
    result
  }

  def toScala[T, R](response: CompletableFuture[T])(extractor: T => R): Future[R] = {

    val promise = Promise[R]()
    response.whenComplete((res: T, ex) => {
      if (ex != null) promise.failure(ex)
      else promise.success(extractor(res))
    })
    promise.future
  }

  /**
    *
    **/
  override def sayHello2(hello: Hello): HelloResponse = {
    //    val completeFuture: CompletableFuture[HelloResponse] = new CompletableFuture[HelloResponse]()
    //耗时很久的方法 20s
    val result: Response = getPayThirdRequest(hello).get

    val response = new HelloResponse()
    response.setContent(result.getResponseBody)
    response.setThirdMsg(result.getContentType)
    response
  }
}
