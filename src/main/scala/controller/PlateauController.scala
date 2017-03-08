package controller

import java.io.{BufferedReader, File, FileReader}
import java.net.URL

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
    val resource: URL = getClass.getClassLoader.getResource("sample")
    val filenameTemp: String = resource.getFile
    val file: File = new File(filenameTemp)
    val fr: FileReader = new FileReader(file)
    val br: BufferedReader = new BufferedReader(fr)

    val upperRightCo = br.readLine()
    val numOfRovers = br.readLine().toInt

    val upperRightCoArray = splitUpperRightCo(upperRightCo)
    val plateau = getRoverDetails(numOfRovers, upperRightCoArray, br)
    plateau
  }

  /**
    * Function to take Rover Details i.e rover Position & commands for Rover
    *
    * @param numOfRovers - Number of rovers on plateau
    */
  def getRoverDetails(numOfRovers: Int, upperRightCoArray: Array[String], br: BufferedReader): Plateau = {
    var i = 0
    while (i < numOfRovers) {
      val roverPosition = br.readLine()
      val roverCommands = br.readLine()
      val cmdArray = roverCommands.split("")
      val roverPositionArray = splitRoverPositions(roverPosition)
      getRoverList(cmdArray, roverPositionArray)
      i += 1
    }
    val plateau = Plateau(upperRightCoArray(0).toInt, upperRightCoArray(1).toInt, numOfRovers, roverList.toList)
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
    val newList = rovList.map(r => {
      RoverController.fireCommand(r)
    })
    newList
  }
}
