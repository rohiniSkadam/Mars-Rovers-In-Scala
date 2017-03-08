package controller

import model.{ Rover}

/**
  * Created by synerzip on 21/2/17.
  */
object RoverController {

  /**
    * Function to fire commands for Rover r
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def fireCommand(rover: Rover): Rover = {
    var rov=rover
    val rcmd: Array[String] = rov.roverCommands
    rcmd.foreach {
      case "L" =>
        rov=moveLeft(rov)
      case "R" =>
        rov=moveRight(rov)
      case "M" =>
        rov=move(rov)
      case _ => println("Invalid Command")
    }
    rov
  }

  /**
    * Function to move left When Rover having left command & also to change its face
    *
    * @param rover -Rover Object which contains current position of Rover
    */
  def moveLeft(rover: Rover): Rover = {
    val currentFace: String = rover.face
    currentFace match {
      case "E" =>
        rover.copy(face = "N")
      case "N" =>
        rover.copy(face = "W")
      case "W" =>
        rover.copy(face = "S")
      case "S" =>
        rover.copy(face = "E")
      case _ => println("Invalid Face Direction")
        rover.copy()
    }

  }

  /**
    * Function to move & change its face When Rover having move Right command
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def moveRight(rover: Rover): Rover = {
    val currentFace: String = rover.face
    currentFace match {
      case "E" =>
        rover.copy(face = "S")
      case "S" =>
        rover.copy(face = "W")
      case "W" =>
        rover.copy(face = "N")
      case "N" =>
        rover.copy(face = "E")
      case _ =>  println("Invalid Face Direction")
        rover.copy()
    }
  }

  /**
    * Function to move When Rover having move command & to change its position
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def move(rover: Rover): Rover = {
    val currentFace: String = rover.face
    val xCo: Int = rover.xCo
    val yCo: Int = rover.yCo
    currentFace match {
      case "E" =>
       rover.copy(xCo=xCo+1)
      case "S" =>
        rover.copy(yCo=yCo-1)
      case "W" =>
        rover.copy(xCo=xCo-1)
      case "N" =>
        rover.copy(yCo=yCo+1)
      case _ => println("Invalid Face Direction")
        rover.copy()
    }
  }
}
