object quickstart {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(19); 
  
  val count = 6;System.out.println("""count  : Int = """ + $show(count ));$skip(25); 
  val countMore: Int = 6;System.out.println("""countMore  : Int = """ + $show(countMore ));$skip(26); 
  
  var countChange = 10;System.out.println("""countChange  : Int = """ + $show(countChange ));$skip(19); 
  countChange = 11
  
  case class Name(first: String, last: String);$skip(89); 
  val name = new Name("Clark", "Kent");System.out.println("""name  : quickstart.Name = """ + $show(name ));$skip(22); 
  println(name.first);$skip(50); 
  
  val lst:List[String] = List("Hello","world");System.out.println("""lst  : List[String] = """ + $show(lst ));$skip(15); 
  println(lst);$skip(47); 
  
  val anotherLst = List("Hello","universe");System.out.println("""anotherLst  : List[String] = """ + $show(anotherLst ));$skip(21); 
	println(anotherLst);$skip(42); 
  
  val combinedLst = lst ::: anotherLst;System.out.println("""combinedLst  : List[String] = """ + $show(combinedLst ));$skip(22); 
	println(combinedLst);$skip(47); 

	println(s"Hello! My name is ${name.first}.");$skip(25); 
  
  val average = 3.456;System.out.println("""average  : Double = """ + $show(average ));$skip(38); 
  println(f"My score $average%2.2f.");$skip(148); 
                                                  
  val names = List(Name("Mickey", "Mouse"), Name("Reginald", "Andrews"), Name("Donald", "Duck"));System.out.println("""names  : List[quickstart.Name] = """ + $show(names ));$skip(51); 
	def sortByLastName(name: Name) = {
		name.last
	};System.out.println("""sortByLastName: (name: quickstart.Name)String""");$skip(41); 
	
	println(names.sortBy(sortByLastName));$skip(46); 
	
	println(names.sortBy { name => name.last});$skip(46); 

	println(names.sortBy { name => name.first});$skip(91); 

	val address:(String, String, String) = ("1 Marlinspike Way", "Seneca", "South Carolina");System.out.println("""address  : (String, String, String) = """ + $show(address ));$skip(22); 

	println(address._1);$skip(61); 

	address match  {
		case (_, _, state) => println(state)
	}}
}
