/** Provides training over functional tree operations.
 *
 *  ==Overview==
 *  We have tree structure defined as Tree. This tree structure
 *  consists of nodes, which has single data and link to a list of its subnodes.
 *
 *  for example,
 *
*
*/
package com.kazuf3.tree

/**
  * Tree structure of interest.
  *  {{{
  *  val tree = Tree(1,
  *                  List(
  *                       Tree(2, List(
  *                                    Tree(5, List()),
  *                                    Tree(6, List())
  *                       )),
  *                       Tree(3, List()),
  *                       Tree(4, List(
  *                                    Tree(7, List())
  *                       ))
  *                  )
  *  )
  *  }}}
  *  denotes a tree of:
  *  {{{
  *  1-+-2-+-5
  *    |   +-6
  *    +-3
  *    |
  *    +-4-+-7
  *  }}}
  *
  * @param root data of the node
  * @param children link to a list of subnodes
  */
case class Tree[T] (val root: T, val children: List[Tree[T]])

/**
  * The main object you want to implement
  */
object Main{
  /**
    * [[foldt]](tree) and [[foldf]](forest) are mutually recursive functions to
    * traverse the [[ Tree ]]. We want to implement generalized version of
    * depth-first and breadth-first traversing.
    *
    * @param f a higher order function which takes current node and intermediate
    * value (processed by `g` of next forest) and fold into result data type
    * @param g a function which takes a forest and process into intermediate
    * value
    * @param tree target Tree you want to fold
    * @return desired fold result
    */
  def foldt[A, B, C](f: A => C => B)(g: List[B] => C)(tree: Tree[A]):B = {
    f (tree.root) (foldf(f)(g)(tree.children))
  }
  /**
    * Task 1. You want to implement this [foldf] function, which is called in
    * pair of [[foldt]] as mutually recursive function.
    *
    * @param f
    * @param g
    * @param forest
    * @return
    */
  def foldf[A, B, C](f: A => C => B)(g: List[B] => C)(forest: List[Tree[A]]) = ???

  /**
    * Helper function used for summing a [[ Tree ]].
    *
    * @param l
    * @return
    */
  def sum(l: List[Int]) = {
    l.sum
  }

  /**
    * Helper function used for enumerating each data from a Tree.
    *
    * @param l
    * @return
    */
  def concat[T](l: List[List[T]]):List[T] = {
    l.flatMap(e => e)
  }

  /**
    * Task 4. You already have [[levelf]] for breadth traversing the forest. Now
    * the problem is how to traverse a Tree.
    *
    * @param tree
    * @return
    */
  def levelt[T](tree: Tree[T]): List[List[T]] = ???

  /**
    * Task 3. The function of interest. This function will traverse a forest in
    * breadth first order. In another word, how to group a Tree into levels?
    * Here we have a node and next forest. What do we want to do with a forest?
    * Use [[unfold]] from Task 2.
    *
    * @return
    */
  def levelf[T]: (List[Tree[T]]) => List[List[T]] = ???

  /**
    * Task 2. We want to traverse a Tree in breadth-first traversing. We want to
    * traverse in the order of 1, {2,3,4} then {5,6,7} from next example. This
    * is a generic function. It means the target can be other data structure
    * rather than a Tree. This function should be called in corecursion manner
    * (a.k.a. a generator)
    *
    *  {{{
    *  1-+-2-+-5
    *    |   +-6
    *    +-3
    *    |
    *    +-4-+-7
    *  }}}
    *
    * @param p specifies if the data from current node should be used
    * @param f specifies data transformation if we want to use the data node
    * @param g specifies data transformation if we want to use the forest
    * @param x target data structure we want to traverse
    * @return
    */
  def unfold[A,B](p: B => Boolean)(f: B=>A)(g:B=>B)(x:B):List[A] = ???
  def main(args:Array[String]) = {
    // write any code if you want to test quickly
  }
}
