package hasher

import java.security.MessageDigest

trait Hasher {
  def hash(data: String): String

  protected def getDigest(algorithm: String, data: String) = {
    val crypt = MessageDigest.getInstance(algorithm)
    crypt.reset()
    crypt.update(data.getBytes("UTF-8"))
    crypt
  }
}

trait Sha1Hasher extends Hasher {
  def hash(data: String): String =
    new String(getDigest("SHA-1", data).digest())
}

trait Sha256Hasher extends Hasher {
  def hash(data: String): String =
    new String(getDigest("SHA-256", data).digest())
}

trait Md5Hasher extends Hasher {
  def hash(data: String): String =
    new String(getDigest("MD5", data).digest())
}
