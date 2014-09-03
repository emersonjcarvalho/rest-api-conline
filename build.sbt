import play.{PlayJava, PlayImport, PlaySettings}

name := """rest-api-conline"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  PlayImport.javaCore,
  PlayImport.javaJpa,
  //JODA-TIME new Libs
  "joda-time" % "joda-time" % "2.3",
  //"org.jadira.usertype" % "usertype.core" % "3.0.0.CR1",
  "joda-time" % "joda-time-hibernate" % "1.3",
  //
  //JACKSON new Libs
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.2.3",
  //
  "org.apache.commons" % "commons-email" % "1.3.3",
  "com.amazonaws" % "aws-java-sdk" % "1.8.4",
  "javax.inject" % "javax.inject" % "1",
  //
  "org.springframework" % "spring-context" % "3.2.2.RELEASE",
  "org.springframework.data" % "spring-data-jpa" % "1.3.2.RELEASE",
  //javax.el usado pelo spring-data-jpa
  "javax.el" % "el-api" % "2.2",
  //"javax.el" % "el-api" % "1.0"
  "org.glassfish.web" % "el-impl" % "2.2",
  "org.springframework" % "spring-expression" % "3.2.2.RELEASE",
  //
  "org.hibernate" % "hibernate-entitymanager" % "3.6.10.Final",
  "org.hibernate" % "hibernate-validator" % "4.2.0.Final",
  //"org.hibernate" % "hibernate-core" % "4.0.1.Final",
  //"org.hibernate" % "hibernate-entitymanager" % "4.2.0.Final",
  "mysql" % "mysql-connector-java" % "5.1.18",
  PlayImport.cache
  //javaJdbc,
  //javaEbean,
  //javaWs
)
