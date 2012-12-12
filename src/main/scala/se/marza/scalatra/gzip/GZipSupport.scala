package se.marza.scalatra.gzip

import java.io.PrintWriter
import java.util.zip.GZIPOutputStream
import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponseWrapper
import org.scalatra.ScalatraBase
import org.scalatra.Handler
import org.scalatra.Initializable

object GZipSupport {

  private def isGzip(request: HttpServletRequest): Boolean = {
	  val encoding: java.util.Enumeration[_] = request.getHeaders("Accept-Encoding")
	  
	  while (encoding.hasMoreElements) {
	    if (encoding.nextElement().toString.contains("gzip")) {
	      return true
	    }
	  }
	  
		return false
	}
}

trait GZipSupport extends Handler with Initializable {
  self: ScalatraBase =>
    
  import GZipSupport._
  
  abstract override def handle(req: HttpServletRequest, res: HttpServletResponse) {
    
    if (isGzip(req)) {
      var w: PrintWriter = null
      
      val response = new HttpServletResponseWrapper(res) {
        
	      override def getOutputStream(): ServletOutputStream = {
	        var gzip = new GZIPOutputStream(res.getOutputStream())
	        w = new PrintWriter(gzip)
	        return new ServletOutputStream {
	          override def write(b: Int) = {gzip.write(b)}
	        }
	      }
	      override def getWriter(): PrintWriter = {
	        w = new PrintWriter(new GZIPOutputStream(res.getOutputStream())); 
	        return w
	      }
	      override def setContentLength(i: Int) = {
	        println("Content-length should have been set to [" + i + "]")
	      }
      }
      
      super.handle(req, response)
      
      if (w != null) {
      	response.addHeader("Content-Encoding", "gzip")

	      w.flush
	      w.close
      }
    }
    else {
      super.handle(req, res)
    }
  }
}