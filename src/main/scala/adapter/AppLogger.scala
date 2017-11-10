package app.logger

import logger._


// My App Logger Interface
trait Log {
  def info(message: String)
  def debug(message: String)
  def warning(message: String)
  def error(message: String)
}


// Adapting the logger with implicit class
object LoggerAdapter {
  implicit class AppLogger(logger: Logger) extends Log {
    def info(message: String): Unit = logger.log(message, "info")

    def warning(message: String): Unit = logger.log(message, "warning")

    def error(message: String): Unit = logger.log(message, "error")

    def debug(message: String): Unit = logger.log(message, "debug")
  }
}
