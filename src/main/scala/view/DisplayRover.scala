package view

import model.Rover

/**
  * Created by synerzip on 21/2/17.
  */
object DisplayRover {
  /**
    * Function to display the Rover Position
    *
    * @param rover -Rover Object which contains current position of Rover
    */
  def showRover(rover: Rover): Unit = {
    println(rover.xCo + " " + rover.yCo + " " + rover.face)
  }

}
