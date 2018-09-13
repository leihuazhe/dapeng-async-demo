namespace java com.github.dapeng.hello.service

include "hello_domain.thrift"

service HelloService {

    hello_domain.HelloResponse sayHello(1: hello_domain.Hello hello)

    hello_domain.HelloResponse sayHello2(1: hello_domain.Hello hello)

}