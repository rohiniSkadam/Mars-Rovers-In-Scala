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

/*
Test Input:
5 5
2
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E
 */