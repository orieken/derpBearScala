package com.derpbear

import org.scalatest.{Matchers, FunSpec}
import scalaj.http._

/**
 * Created by oscar on 4/1/15.
 */
class DerpBearApiSpec extends FunSpec with Matchers {

  describe("DerpBearApi") {
    describe("GET #/users/1") {
      it("should be 200") {
        val response: HttpResponse[String] = Http("http://derp-bear-users-api.herokuapp.com/users/1").option(HttpOptions.readTimeout(10000)).asString

//        println(response)
        response.code should equal(200)

      }
    }
  }
}
