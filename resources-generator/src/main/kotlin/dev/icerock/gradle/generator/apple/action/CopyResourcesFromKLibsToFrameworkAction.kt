/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.apple.action

import org.gradle.api.Task
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.tasks.KotlinNativeLink

internal class CopyResourcesFromKLibsToFrameworkAction : CopyResourcesFromKLibsAction() {
    override fun execute(task: Task) {
        task as KotlinNativeLink

        val framework: Framework = task.binary as Framework

        copyResourcesFromLibraries(
            linkTask = task,
            outputDir = framework.outputFile
        )
    }
}
