import controller.PlateauController

/**
  * Created by synerzip on 21/2/17.
  */
object MarsRoverApp {
  /**
    * Main Function to start the MarsRover App by calling Methods
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val plateauController = new PlateauController
    plateauController.getInput
  }
}
