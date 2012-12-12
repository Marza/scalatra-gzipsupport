scalatra-gzipsupport
====================

Scalatra handler for compressing responses with <a href="http://en.wikipedia.org/wiki/Gzip">gzip</a>

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
---

<pre>
libraryDependencies ++= Seq(
  "se.marza" %% "scalatra-gzipsupport" % "0.1"
)

resolvers += "marza-mvn-repo" at "https://github.com/marza/mvn-repo/raw/master/releases"
</pre>