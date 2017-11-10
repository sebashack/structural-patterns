package logger

// Third Party Logger
final class Logger {
  def log(message: String, severity: String): Unit = {
    println(s"${severity.toUpperCase}: $message")
  }
}
