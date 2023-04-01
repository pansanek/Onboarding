package ru.thekodingklowns.onboarding.core

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*


fun String.toMd5() = MessageDigest.getInstance("MD5").digest(
    this.trim().lowercase(Locale.getDefault()).toByteArray(StandardCharsets.UTF_8)
).joinToString("") { "%02x".format(it) }