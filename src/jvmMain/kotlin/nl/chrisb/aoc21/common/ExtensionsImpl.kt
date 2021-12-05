package nl.chrisb.aoc21.common

import java.security.MessageDigest

actual fun ByteArray.md5() = MessageDigest.getInstance("MD5").digest(this)
