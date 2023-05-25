/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.js

import dev.icerock.gradle.generator.MRGenerator
import dev.icerock.gradle.generator.MRGeneratorContext
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrCompilation

class JsMRGeneratorContext(
    project: Project,
    sourceSet: MRGenerator.SourceSet,
    val compilation: KotlinJsIrCompilation
) : MRGeneratorContext(project, sourceSet)
