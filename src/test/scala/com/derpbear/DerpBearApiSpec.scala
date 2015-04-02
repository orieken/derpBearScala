package com.derpbear

import org.scalatest.matchers.{Matcher, MatchResult}
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfter, Matchers, FunSpec}
import scalaj.http._
import net.liftweb.json._
//import net.liftweb.json.JsonParser._


/**
 * Created by oscar on 4/1/15.
 */
class User(id:Int,
           first_name:String,
           last_name:String,
           email:String,
           website:String,
           pet:String,
           created_at: java.util.Date,
            updated_at: java.util.Date)



class DerpBearApiSpec extends FunSpec with Matchers with BeforeAndAfterAll {

  var response:HttpResponse[String] = _

  override def beforeAll() {
    response = Http("http://derp-bear-users-api.herokuapp.com/users/1").option(HttpOptions.readTimeout(10000)).asString
  }

  describe("DerpBearApi") {
    describe("GET #/users/1") {
      it("should be 200") {
        response.code should equal(200)
      }

      it("has the correct properties") {
        implicit val formats = net.liftweb.json.DefaultFormats
        val responseJson = parse(response.body)
        val res = responseJson.extract[Map[String, String]]

        res should (contain key "first_name" and contain value "Jarod")
        res should (contain key "last_name" and contain value "Adair")
        res should (contain key "pet" and contain value "cat")

      }
    }
  }


  private def haveProperty(expected: String) = new Matcher[JValue] {
    def apply(left: JValue): MatchResult = {
      MatchResult(left.hasProperty(expected), "false", "true" )
    }
  }
//    haveProperty(expected) compose { (o:JObject) => o.hasProperty(expected) }


  implicit class JValueExtended(value: JValue) {
    def hasProperty(childString: String): Boolean = {
      if ((value \ childString) != JNothing) {
        true
      } else {
        false
      }
    }
  }
}
