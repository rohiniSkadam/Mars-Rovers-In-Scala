package view

import model.Rover

/**
  * Created by synerzip on 21/2/17.
  */
class DisplayRover {
  /**
    * Function to display the Rover Position
    *
    * @param rover -Rover Object which contains current position of Rover
    */
  def showRover(rover: Rover): Unit = {
    println(rover.getXCo + " " + rover.getYCo + " " + rover.getFace)
  }

}
