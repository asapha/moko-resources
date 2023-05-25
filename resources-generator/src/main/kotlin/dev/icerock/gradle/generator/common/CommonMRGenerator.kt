/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.common

import com.squareup.kotlinpoet.KModifier
import dev.icerock.gradle.generator.MRGenerator
import dev.icerock.gradle.generator.MRGeneratorContext
import org.gradle.api.Task
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import java.io.File

class CommonMRGenerator(
    generatedDir: File,
    sourceSetName: String,
    mrSettings: MRSettings,
    generators: List<Generator>
) : MRGenerator<MRGeneratorContext>(
    generatedDir = generatedDir,
    sourceSetName = sourceSetName,
    mrSettings = mrSettings,
    generators = generators
) {

    override fun getMRClassModifiers(): Array<KModifier> = arrayOf(KModifier.EXPECT)

    override fun apply(generationTask: Task, context: MRGeneratorContext) = with(context) {
        project.tasks
            .withType<KotlinCompile<*>>()
            .matching { it.name.contains(sourceSetName, ignoreCase = true) }
            .configureEach { it.dependsOn(generationTask) }

        project.rootProject.tasks.matching {
            it.name.contains("prepareKotlinBuildScriptModel")
        }.configureEach {
            it.dependsOn(generationTask)
        }

        project.tasks
            .matching { it.name.startsWith("metadata") && it.name.endsWith("ProcessResources") }
            .configureEach {
                it.dependsOn(generationTask)
            }
    }
}
