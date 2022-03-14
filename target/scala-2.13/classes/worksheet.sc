import scala.collection.mutable.{ArrayStack, Stack}

var s = Stack[Int]()

s.push(1)
s.push(2)
s.push(3)


println(s)
println("Top: " + s.top)
println("Popped:" + s.pop)
println("Top: " + s.top)

val numbers = List(1,2,3,4,4,5,5)

numbers.filterNot(_==)