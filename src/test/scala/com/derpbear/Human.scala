package com.derpbear

trait Friend {
  val name: String
  def listen = "I am " + name.capitalize + ", and I am your friend."
}

class Human(val name: String) extends Friend

class Dog(val name: String) extends Friend
class Cat(val name: String)