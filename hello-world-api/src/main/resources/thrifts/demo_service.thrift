namespace java com.github.dapeng.demo.service
include "demo_domain.thrift"
service DemoService {

    string demoTest(1: demo_domain.Demo demo)
}(version="1.0.0")