package com.derpbear

import scala.util.Random
import java.util.Calendar
import faker.{Lorem, Internet, Name}
import org.scalatest.{BeforeAndAfterEach, Matchers, FunSpec}

class UsersSpec extends FunSpec with Matchers with BeforeAndAfterEach {

  var user: User = _

  override def beforeEach(): Unit = {
    val first_name = Name.first_name
    val last_name = Name.last_name
    val full_name = first_name + "." + last_name
    val web_address = "www." + Lorem.words(3).head + "." + Internet.domain_suffix

    val pets = Array("cat", "dog", "horse", "snake")
    val pet = Random.shuffle(pets.toList).head


    user = User(
      Random.nextInt(100),
      first_name,
      last_name,
      Internet.email(full_name),
      web_address,
      pet,
      Calendar.getInstance.getTime,
      Calendar.getInstance.getTime
    )
  }

  describe("playing around with Scala-Faker") {
    info("sadly Factory_Girl requires you to use skinny ORM in which you need an actual db")
    info("and FactoryPal doesnt work with latest scala or have a package you dont have to hand build")
    describe("creates random users?") {
      it("User 1") {
        println(user)
      }
      it("User 2") {
        println(user)
      }
      it("User 3") {
        println(user)
      }
    }
  }
}
