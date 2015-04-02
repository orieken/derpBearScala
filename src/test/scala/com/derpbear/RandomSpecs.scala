package com.derpbear

import org.scalatest.{BeforeAndAfterEach, FunSpec, Matchers, BeforeAndAfter}

class RandomSpecs extends FunSpec with Matchers with BeforeAndAfterEach {
  val numbers = List(1,2,3,4,5,6,7,8,9,10,11,12)

  describe("Learning Scala") {
    describe("Passing a function to a function") {

      it("sums up all items"){
       val total = Extras.totalListValues(numbers, { e => true } )
        total should equal(78)
      }

      it("sums up all even items"){
        val total = Extras.totalListValues(numbers, { e => e % 2 == 0 } )
        total should equal(42)
      }

      it("sums up all items higher than 4"){
        val total = Extras.totalListValues(numbers, { _ > 4 } )
        total should equal(68)
      }
    }

    describe("using traits") {
      it("Franklin is my friend") {
        val franklin = new Human("franklin")
        franklin.listen should equal("I am Franklin, and I am your friend.")
      }

      it("Gingy is my friend") {
        val gingy = new Dog("gingy")
        gingy.listen should equal("I am Gingy, and I am your friend.")
      }
      it("Butch is a cat") {
        val butch = new Cat("butch")
        butch.getClass()
      }
      it("Cassie is my friend") {
        val cassie = new Cat("cassie") with Friend
        cassie.listen should equal("I am Cassie, and I am your friend.")
      }
    }
  }
}


