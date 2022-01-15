val salaries = Seq(20000, 70000, 40000)
val doubleSalary: Int => Int =  x => x * 2
val newSalaries = salaries map doubleSalary

// Coercing methods into functions

case class WeeklyWeatherForeCast(temperatures: Seq[Double]) {

  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
}

object SalaryRaiser {

  private def promotion(salaries: Seq[Double], promotionFunction: Double => Double) = salaries.map(promotionFunction)

  def smallPromotion(salaries: Seq[Double]) = promotion(salaries, salary => salary * 1.1)

}

SalaryRaiser.smallPromotion(List(12))

// Partially applied function
def sum(a: Int, b: Int, c: Int) = a + b + c

def pSum = sum(_, _, 19)
pSum(10, 12)

def urlBuilder(ssl: Boolean, domain: String) = {
  val schema = if(ssl) "https://" else "http://"
  (endPoint: String, query: String) => s"$schema$domain/$endPoint?$query"
}

def getURL = urlBuilder(true, "www.google.com")
getURL("users", "id=10")






