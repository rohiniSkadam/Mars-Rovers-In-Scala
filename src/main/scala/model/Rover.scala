package model

import scala.beans.BeanProperty

/**
  * Created by synerzip on 21/2/17.
  */
class Rover(@BeanProperty var xCo: Int,
            @BeanProperty var yCo: Int,
            @BeanProperty var face: String,
            @BeanProperty val roverCommands: Array[String]) {
  override def toString = s"Rover($xCo, $yCo, $face, $roverCommands)"
}