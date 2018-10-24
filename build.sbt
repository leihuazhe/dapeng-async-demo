name := "hello-world"

resolvers += Resolver.mavenLocal

lazy val commonSettings = Seq(
  organization := "com.github.dapeng",
  version := "1.0",
  scalaVersion := "2.12.4"
)

javacOptions ++= Seq("-encoding", "UTF-8")

lazy val api = (project in file("hello-world-api"))
  .settings(
    commonSettings,
    name := "hello-world-api",
    libraryDependencies ++= Seq(
      "com.github.dapeng-soa" % "dapeng-client-netty" % "2.1.1-SNAPSHOT"
    )
  ).enablePlugins(ThriftGeneratorPlugin)


lazy val service = (project in file("hello-world-service"))
  .dependsOn(api)
  .settings(
    commonSettings,
    name := "hello-world_service",
    libraryDependencies ++= Seq(
      "com.github.dapeng-soa" % "dapeng-spring" % "2.1.1-SNAPSHOT",
      "com.github.dapeng-soa" % "dapeng-client-netty" % "2.1.1-SNAPSHOT",
      "com.github.dapeng-soa" % "logback-classic" % "2.0.0",
      "com.github.wangzaixiang" %% "scala-sql" % "2.0.6",
      "org.codehaus.janino" % "janino" % "2.7.8", //logback (use if condition in logBack config file need this dependency)
      "mysql" % "mysql-connector-java" % "5.1.36",
      "com.alibaba" % "druid" % "1.1.9",
      "org.springframework" % "spring-context" % "4.3.5.RELEASE",
      "org.springframework" % "spring-tx" % "4.3.5.RELEASE",
      "org.springframework" % "spring-jdbc" % "4.3.5.RELEASE",
      //async-http-client
      "org.asynchttpclient" % "async-http-client" % "2.5.3"
    )).enablePlugins(ImageGeneratorPlugin)
  .enablePlugins(DbGeneratePlugin)
  .enablePlugins(RunContainerPlugin)
