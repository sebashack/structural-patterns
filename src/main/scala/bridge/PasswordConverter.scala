package password.converter

import hasher._

abstract class PasswordConverter {
  self: Hasher =>

  def convert(password: String): String
}

class SimplePasswordConverter extends PasswordConverter {
  self: Hasher =>

  def convert(password: String): String =
    hash(password)
}

class SaltedPasswordConverter(salt: String) extends PasswordConverter {
  self: Hasher =>

  def convert(password: String): String =
    hash(s"${salt}:${password}")
}
