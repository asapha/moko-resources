/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.apple

import dev.icerock.gradle.generator.MRGenerator
import dev.icerock.gradle.generator.MRGeneratorContext
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeCompilation

class AppleMRGeneratorContext(
    project: Project,
    sourceSet: MRGenerator.SourceSet,
    val compilation: AbstractKotlinNativeCompilation
) : MRGeneratorContext(project, sourceSet)
