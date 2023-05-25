/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator

import org.gradle.api.Project

/**
 * Contains dependencies required by [MRGenerator] during the apply phase.
 * These dependencies shouldn't be stored by the generated tasks as they're not compatible with Gradle's
 * configuration cache.
 */
open class MRGeneratorContext(
    val project: Project,
    val sourceSet: MRGenerator.SourceSet,
)
