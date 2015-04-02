package com.derpbear

object Extras {
  def totalListValues(list: List[Int], selector: Int => Boolean) = {
    var sum = 0
    list.foreach {
      e =>
        if (selector(e)) sum += e
    }
    sum
  }
}
