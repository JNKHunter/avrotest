name := "avrotest"
val confluentVersion = "3.3.0"


resolvers += "confluent" at "http://packages.confluent.io/maven/"

seq(sbtavro.SbtAvro.avroSettings : _*)
version in sbtavro.SbtAvro.avroConfig := "1.8.0"

version := "1.0"

scalaVersion := "2.11.11"

sbtavrohugger.SbtAvrohugger.scavroSettings

(sourceDirectory in sbtavrohugger.SbtAvrohugger.avroConfig) := new java.io.File("avro")

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "1.0.0",
  "org.oedura" %% "scavro" % "1.0.2",
  "io.confluent" % "kafka-avro-serializer" % confluentVersion
  
)

mainClass in Compile := Some("HelloAvro")

