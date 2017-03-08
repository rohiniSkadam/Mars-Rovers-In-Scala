package controller

import model.{Plateau, Rover}

import scala.collection.mutable.ListBuffer

/**
  * Created by synerzip on 21/2/17.
  */
object PlateauController {
  val roverList = new ListBuffer[Rover]()

  /**
    * Function to take Upper Right Coordinate & Rover Count
    */
  def getInput: Plateau = {
    print("Enter Upper Right Coordinates of Plateau : ")
    val upperRightCo: String = scala.io.StdIn.readLine()
    print("Enter Number of Rovers : ")
    val numOfRovers: Int = scala.io.StdIn.readLine().toInt
    val upperRightCoArray = splitUpperRightCo(upperRightCo)
    val plateau = getRoverDetails(numOfRovers, upperRightCoArray)
    plateau
  }

  /**
    * Function to take Rover Details i.e rover Position & commands for Rover
    *
    * @param numOfRovers - Number of rovers on plateau
    */
  def getRoverDetails(numOfRovers: Int, upperRightCoArray: Array[String]): Plateau = {
    var i = 0
    var plateau: Plateau = null
    while (i < numOfRovers) {
      print("Enter Rover Position (x y face) : ")
      val roverPosition: String = scala.io.StdIn.readLine().toUpperCase()
      print("Enter series of Rover commands  : ")
      val roverCommands: String = scala.io.StdIn.readLine().toUpperCase()
      val cmdArray = roverCommands.split("")
      val roverPositionArray = splitRoverPositions(roverPosition)
      getRoverList(cmdArray, roverPositionArray)
      val upperRightXco = upperRightCoArray(0).toInt
      val upperRightYco = upperRightCoArray(1).toInt
      plateau = Plateau(upperRightXco, upperRightYco, numOfRovers, roverList.toList)
      i += 1
    }
    plateau
  }

  /**
    * Function to split the Rover Positions in X,Y cordinate & its Face
    *
    * @param roverPositions - Rover Coordinates & its Face
    */
  def splitRoverPositions(roverPositions: String): Array[String] = {
    val roverPositionArray: Array[String] = roverPositions.split(" ")
    roverPositionArray
  }

  /**
    * Function to get the rover list which contain X,Y coordinate , rover face & Array of commands
    *
    * @param cmdArray - Stores commands given to Rover
    */
  def getRoverList(cmdArray: Array[String], roverPositionArray: Array[String]): ListBuffer[Rover] = {
    val roverPosXco = roverPositionArray(0).toInt
    val roverPosYco = roverPositionArray(1).toInt
    val roverFace = roverPositionArray(2)
    val rover: Rover = Rover(roverPosXco, roverPosYco, roverFace, cmdArray)
    roverList += rover
  }

  /**
    * Function to split the Upper Right coordinates Of Plateau
    *
    * @param upperRightCo - Upper Right Coordinates of Plateau
    */
  def splitUpperRightCo(upperRightCo: String): Array[String] = {
    val upperRightCoArray: Array[String] = upperRightCo.split(" ")
    upperRightCoArray
  }

  /**
    * Function to find the rover position & to fire the commands
    *
    * @param plateau - Object of Plateau to get the rover list
    */
  def roverPosition(plateau: Plateau): List[Rover] = {
    val rovList: List[Rover] = plateau.roverList
    val newList=rovList.map(r => {
      RoverController.fireCommand(r)
    })
    newList
  }
}
