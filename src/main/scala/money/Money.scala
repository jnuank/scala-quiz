package money

/**
  * お金
  */
case class Money(private val amount:Long, private val currency:String) extends Ordered[Money]{
  def +(other:Money): Money = add(other)
  def add(other:Money):Money = {
    require(currency == other.currency, "failed to other currency")
//    Money(this.amount + other.amount, this.currency)
    copy(amount = this.amount + other.amount)
  }

  override def compare(that: Money): Int = {
    amount.compareTo(that.amount)
  }
}
object Money {
  lazy val JPY = "JPY"
  lazy val USD = "USD"
}

object Main {
  def main(args: Array[String]): Unit = {
    val a = Money.apply(10, Money.JPY)
    val b = Money(20, "USD")

    val Money(_, y) = a
    println(a)
    val e: Any = b
    e match {
      case Money(a, _) if a > 30 => println(a)
//      case Address(Pref(id), CityName(city)) if id == "" && city == "" => println(a)
      case x => println(x)
    }
    val c = a + b

    println(c)
  }
}