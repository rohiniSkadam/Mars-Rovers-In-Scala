package controller

import model.Rover

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
    var i: Int = 0
    val rcmd: Array[String] = rover.getRoverCommands

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
  def moveLeft(rover: Rover): Unit = {
    val currentFace: String = rover.getFace
    currentFace match {
      case "E" =>
        rover.setFace("N")
      case "N" =>
        rover.setFace("W")
      case "W" =>
        rover.setFace("S")
      case "S" =>
        rover.setFace("E")
      case _ => println("Invalid Face Direction")

    }
  }

  /**
    * Function to move & change its face When Rover having move Right command
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def moveRight(rover: Rover): Unit = {
    val currentFace: String = rover.getFace
    currentFace match {
      case "E" =>
        rover.setFace("S")
      case "S" =>
        rover.setFace("W")
      case "W" =>
        rover.setFace("N")
      case "N" =>
        rover.setFace("E")
      case _ => println("Invalid Face Direction")

    }
  }

  /**
    * Function to move When Rover having move command & to change its position
    *
    * @param rover - Rover Object which contains current position of Rover
    */
  def move(rover: Rover): Unit = {
    val currenFace: String = rover.getFace
    val xCo: Int = rover.getXCo
    val yCo: Int = rover.getYCo
    currenFace match {
      case "E" =>
        rover.setXCo(xCo + 1)
      case "S" =>
        rover.setYCo(yCo - 1)
      case "W" =>
        rover.setXCo(xCo - 1)
      case "N" =>
        rover.setYCo(yCo + 1)
      case _ => println("Invalid Face Direction")
    }
  }
}
