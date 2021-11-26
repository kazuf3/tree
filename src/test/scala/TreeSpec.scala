package com.kazuf3.tree

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TreeSpec extends AnyFlatSpec with Matchers {
  val tree = Tree(1,
               List(
                 Tree(2, List(
                        Tree(5, List()),
                        Tree(6, List())
                      )),
                 Tree(3, List()),
                 Tree(4, List(
                      Tree(7, List())
                      ))
               )
  )

  "Fold" should "work for sum" in {
    assert(
      Main.foldt[Int, Int, Int](a => b => a+b)(Main.sum)(tree) === 28
    )
  }
  "Fold" should "work for traversing" in {
    assert(
      Main.foldt[Int,List[Int],List[Int]](a => b => a::b)(Main.concat)(tree) ===
        List(1, 2, 5, 6, 3, 4, 7)
    )
  }
  "levelt" should "work for BFS" in {
    assert(
      Main.levelt(tree) === List(
        List(1),
        List(2,3,4),
        List(5,6,7)
      )
    )
  }
}
