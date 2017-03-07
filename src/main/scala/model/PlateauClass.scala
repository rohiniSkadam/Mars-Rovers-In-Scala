package model

/**
  * Created by synerzip on 6/3/17.
  */
case class Plateau(var upperRightXco:Int,var upperRightYco:Int,var numOfRovers:Int,var roverList:List[Rover])
case class Rover(var xCo:Int,var yCo:Int,var face:String,var roverCommands:Array[String])

