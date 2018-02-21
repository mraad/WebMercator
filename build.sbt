organization := "com.esri"

name := "webmercator"

version := "1.4"

isSnapshot := true

publishMavenStyle := true

crossScalaVersions := Seq("2.10.6", "2.11.8")

resolvers += Resolver.mavenLocal

libraryDependencies += "junit" % "junit" % "4.12" % "test"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

pomExtra :=
  <url>https://github.com/mraad/WebMercator</url>
    <licenses>
      <license>
        <name>Apache License, Verision 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:mraad/WebMercator.git</url>
      <connection>scm:git:git@github.com:mraad/WebMercator.git</connection>
    </scm>
    <developers>
      <developer>
        <id>mraad</id>
        <name>Mansour Raad</name>
        <url>https://github.com/mraad</url>
        <email>mraad@esri.com</email>
      </developer>
    </developers>
