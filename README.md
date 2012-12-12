scalatra-gzipsupport
====================

Scalatra handler for compressing responses with <a href="http://en.wikipedia.org/wiki/Gzip">gzip</a>

Tested with scala 2.9.2, sbt 0.12.1 and scalatra 2.1.1

Usage
----

Just add the GZipSupport trait to your servlet.

<pre>
import se.marza.scalatra.gzip.GZipSupport

class MyServlet extends ScalatraServlet with GZipSupport {
  ...
}
</pre>

and you will now serve responses gzipped if the client sends in gzip as Accept-Encoding.


Dependency
----

Add this to your build.sbt file.

<pre>
libraryDependencies ++= Seq(
  "se.marza" %% "scalatra-gzipsupport" % "0.2"
)

resolvers += "marza-repository" at "https://github.com/marza/repository/raw/master/releases"
</pre>
