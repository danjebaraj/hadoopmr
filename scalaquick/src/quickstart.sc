object quickstart {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val count = 6                                   //> count  : Int = 6
  val countMore: Int = 6                          //> countMore  : Int = 6
  
  var countChange = 10                            //> countChange  : Int = 10
  countChange = 11
  
  case class Name(first: String, last: String)
  val name = new Name("Clark", "Kent")            //> name  : quickstart.Name = Name(Clark,Kent)
  println(name.first)                             //> Clark
  
  val lst:List[String] = List("Hello","world")    //> lst  : List[String] = List(Hello, world)
  println(lst)                                    //> List(Hello, world)
  
  val anotherLst = List("Hello","universe")       //> anotherLst  : List[String] = List(Hello, universe)
	println(anotherLst)                       //> List(Hello, universe)
  
  val combinedLst = lst ::: anotherLst            //> combinedLst  : List[String] = List(Hello, world, Hello, universe)
	println(combinedLst)                      //> List(Hello, world, Hello, universe)

	println(s"Hello! My name is ${name.first}.")
                                                  //> Hello! My name is Clark.
  
  val average = 3.456                             //> average  : Double = 3.456
  println(f"My score $average%2.2f.")             //> My score 3.46.
                                                  
  val names = List(Name("Mickey", "Mouse"), Name("Reginald", "Andrews"), Name("Donald", "Duck"))
                                                  //> names  : List[quickstart.Name] = List(Name(Mickey,Mouse), Name(Reginald,Andr
                                                  //| ews), Name(Donald,Duck))
	def sortByLastName(name: Name) = {
		name.last
	}                                         //> sortByLastName: (name: quickstart.Name)String
	
	println(names.sortBy(sortByLastName))     //> List(Name(Reginald,Andrews), Name(Donald,Duck), Name(Mickey,Mouse))
	
	println(names.sortBy { name => name.last})//> List(Name(Reginald,Andrews), Name(Donald,Duck), Name(Mickey,Mouse))

	println(names.sortBy { name => name.first})
                                                  //> List(Name(Donald,Duck), Name(Mickey,Mouse), Name(Reginald,Andrews))

	val address:(String, String, String) = ("1 Marlinspike Way", "Seneca", "South Carolina")
                                                  //> address  : (String, String, String) = (1 Marlinspike Way,Seneca,South Caroli
                                                  //| na)

	println(address._1)                       //> 1 Marlinspike Way

	address match  {
		case (_, _, state) => println(state)
	}                                         //> South Carolina
}