package com.github.dapeng.hello.domain;

        import java.util.Optional;
        import com.github.dapeng.org.apache.thrift.TException;
        import com.github.dapeng.org.apache.thrift.protocol.TCompactProtocol;
        import com.github.dapeng.util.TCommonTransport;

        /**
         * Autogenerated by Dapeng-Code-Generator (2.0.4)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING

        *
        **/
        public class HelloResponse{
        
            /**
            *
            **/
            public String content ;
            public String getContent(){ return this.content; }
            public void setContent(String content){ this.content = content; }

            public String content(){ return this.content; }
            public HelloResponse content(String content){ this.content = content; return this; }
          
            /**
            *
            **/
            public String thirdMsg ;
            public String getThirdMsg(){ return this.thirdMsg; }
            public void setThirdMsg(String thirdMsg){ this.thirdMsg = thirdMsg; }

            public String thirdMsg(){ return this.thirdMsg; }
            public HelloResponse thirdMsg(String thirdMsg){ this.thirdMsg = thirdMsg; return this; }
          

        public static byte[] getBytesFromBean(HelloResponse bean) throws TException {
          byte[] bytes = new byte[]{};
          TCommonTransport transport = new TCommonTransport(bytes, TCommonTransport.Type.Write);
          TCompactProtocol protocol = new TCompactProtocol(transport);

          new com.github.dapeng.hello.domain.serializer.HelloResponseSerializer().write(bean, protocol);
          transport.flush();
          return transport.getByteBuf();
        }

        public static HelloResponse getBeanFromBytes(byte[] bytes) throws TException {
          TCommonTransport transport = new TCommonTransport(bytes, TCommonTransport.Type.Read);
          TCompactProtocol protocol = new TCompactProtocol(transport);
          return new com.github.dapeng.hello.domain.serializer.HelloResponseSerializer().read(protocol);
        }

        public String toString(){
          StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("\"").append("content").append("\":\"").append(this.content).append("\",");
    stringBuilder.append("\"").append("thirdMsg").append("\":\"").append(this.thirdMsg).append("\",");
    
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

          return stringBuilder.toString();
        }
      }
      