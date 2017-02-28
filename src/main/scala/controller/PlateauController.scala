package controller

import model.{Plateau, Rover}
import view.DisplayRover

import scala.collection.mutable.ListBuffer

/**
  * Created by synerzip on 21/2/17.
  */
class PlateauController {
  var roverPosXco: Int = 0
  var roverPosYco: Int = 0
  var upperRightXco: Int = 0
  var upperRightYco: Int = 0
  var roverFace: String = _
  var plateau: Plateau = _
  var roverList = new ListBuffer[Rover]()
  /**
    * Function to take Upper Right Coordinate & Rover Count
    */
  def getInput: Unit = {
    println("Enter Upper Right Coordinates of Plateau : ")
    val upperRightCo: String = scala.io.StdIn.readLine()
    println("Enter Number of Rovers : ")
    val numOfRovers: Int = scala.io.StdIn.readLine().toInt
    splitUpperRightCo(upperRightCo)
    getRoverDetails(numOfRovers)
  }

  /**
    * Function to take Rover Details i.e rover Position & commands for Rover
    *
    * @param numOfRovers - Number of rovers on plateau
    */
  def getRoverDetails(numOfRovers: Int): Unit = {
    var cmdArray: Array[String] = null
    var i = 0
    while (i < numOfRovers) {
      println("Enter Rover Position : ")
      val roverPosition: String = scala.io.StdIn.readLine().toUpperCase()
      println("Enter Series of commands : ")
      val roverCommands: String = scala.io.StdIn.readLine().toUpperCase()
      cmdArray = roverCommands.split("")
      splitRoverPositions(roverPosition)
      getRoverList(cmdArray)
      plateau = new Plateau(upperRightXco, upperRightYco, numOfRovers, roverList.toList)
      i += 1
    }
    roverPosition(plateau)
  }

  /**
    * Function to split the Rover Positions in X,Y cordinate & its Face
    *
    * @param roverPositions - Rover Coordinates & its Face
    */
  def splitRoverPositions(roverPositions: String): Unit = {
    val roverPositionArray: Array[String] = roverPositions.split(" ")
    roverPosXco = roverPositionArray(0).toInt
    roverPosYco = roverPositionArray(1).toInt
    roverFace = roverPositionArray(2)
  }

  /**
    * Function to get the rover list which contain X,Y coordinate , rover face & Array of commands
    *
    * @param cmdArray - Stores commands given to Rover
    */
  def getRoverList(cmdArray: Array[String]): Unit = {
    val rover: Rover = new Rover(roverPosXco, roverPosYco, roverFace, cmdArray)
    roverList += rover
  }

  /**
    * Function to find the rover position & to fire the commands
    *
    * @param plateau - Object of Plateau to get the rover list
    */
  def roverPosition(plateau: Plateau): Unit = {
    val reoverController = new RoverController
    val displayRover = new DisplayRover
    val rovList: List[Rover] = plateau.getRoverList

    rovList.foreach(r => {
      reoverController.fireCommand(r)
      displayRover.showRover(r)
    })

  }

  /**
    * Function to split the Upper Right coordinates Of Plateau
    *
    * @param upperRightCo - Upper Right Coordinates of Plateau
    */
  def splitUpperRightCo(upperRightCo: String): Unit = {
    val upperRightCoArray: Array[String] = upperRightCo.split(" ")
    upperRightXco = upperRightCoArray(0).toInt
    upperRightYco = upperRightCoArray(1).toInt
  }
}
