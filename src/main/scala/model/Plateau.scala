package model

import scala.beans.BeanProperty

/**
  * Created by synerzip on 21/2/17.
  */
class Plateau(@BeanProperty var upperRightXco: Int,
              @BeanProperty var upperRightYco: Int,
              @BeanProperty var numOfRovers: Int,
              @BeanProperty var roverList: List[Rover]) {
}
