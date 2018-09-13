namespace java com.github.dapeng.hello.domain

struct Hello {
    1: string name,
    2: optional string message,
}


struct HelloResponse {
    1: string content,
    2: string thirdMsg,
}