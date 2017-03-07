package controller

import model.{ Rover}

/**
  * Created by synerzip on 21/2/17.
  */
class RoverController {

  /**
    * Function to fire commands for Rover r
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def fireCommand(rover: Rover): Unit = {
    val rcmd: Array[String] = rover.roverCommands
    rcmd.foreach {
      case "L" => moveLeft(rover)
      case "R" => moveRight(rover)
      case "M" => move(rover)
      case _ => println("Invalid Command")
    }
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
        rover.face="N"
      case "N" =>
        rover.face="W"
      case "W" =>
        rover.face="S"
      case "S" =>
        rover.face="E"
      case _ => println("Invalid Face Direction")
    }
    rover
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
        rover.face="S"
      case "S" =>
        rover.face="W"
      case "W" =>
        rover.face="N"
      case "N" =>
        rover.face="E"
      case _ => {
        println("Invalid Face Direction")
      }
    }
    rover
  }

  /**
    * Function to move When Rover having move command & to change its position
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def move(rover: Rover): Rover = {
    val currenFace: String = rover.face
    val xCo: Int = rover.xCo
    val yCo: Int = rover.yCo
    currenFace match {
      case "E" =>
        rover.xCo=xCo + 1
      case "S" =>
        rover.yCo=yCo - 1
      case "W" =>
        rover.xCo=xCo - 1
      case "N" =>
        rover.yCo=yCo + 1
      case _ => println("Invalid Face Direction")
    }
    rover
  }
}
